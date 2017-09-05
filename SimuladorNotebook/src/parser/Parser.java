package parser;

import unrepeatedList.CuentasHandler;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import scala.ScalaUtils;
import tipos.Expresion;
import tipos.Indicador;
import java.util.ArrayList;
import java.util.Collection;

public class Parser  
{
	CuentasHandler cuentasHandler ;
	List <String> cuentas ;
	
	public Parser(String formula)
	{
	  CuentasHandler cuentasHandler = new CuentasHandler();
	}
  
  //TODO
  //necesito saber qué cuentas utilicé,para asi saber que ondita
  //con el tema de que cuentas son las que el indicador utiliza y asi saber
  //si puedo el indicador a una empresa determinada... no voy a poder aplicar
  //un indicador a una cuenta que no tiene las cuentas que necesita
  //para aplicar dicho indicador
  
  
  
    //esta función debe devolver un string con los valores de las cuentas obtenidos
  private String transformarVariablesANumeros(String expr)
  {
    boolean recognizingVar = false ;
    String resultado = "";
    String expresionFinal = "";
    String variableName = "";
    int i = expr.length()-1;
    while ( i >= 0 )
    {
      if ( (expr.charAt(i) >='a' && expr.charAt(i)<='z') || (expr.charAt(i)>='A' && expr.charAt(i)<='Z') )
      {
        resultado += expr.charAt(i) ;
        if ( !recognizingVar )  {
          recognizingVar = true ;
        }
        //Encontró la variable que se halla más a la izquierda de la expresión,
        //la cual era la unica que quedaba
        if (i == 0)
        {
          //encontr� una variable que fue le�da de derecha a izq
          variableName = ScalaUtils.reverseThis(resultado);
          
          //expresionFinal tiene la concatenaci�n parcial de haber
          //reemplazado los nombres de variables por Doubles
          String strAux = expresionFinal ;
          //TODO: poner bloques try catch para manejar una variable sintacticamente incorrecta
          //si estaba reconociendo una variable y encontr� otra cosa
          
          //la expresi�n final es con el reemplazo de todas las variables a un double
          //strAux
          if ( cuentasHandler.existeLaCuenta(variableName) )
          {
        	  expresionFinal = String.valueOf(0) + strAux;
        	  this.cuentas.add(variableName);
          }
          else
          {
            expresionFinal = variableName + strAux;
          }
        }
      }
      else
      {
        if ( recognizingVar  )
        {
          variableName = ScalaUtils.reverseThis(resultado);
          String strAux = expresionFinal;
          //si estaba reconociendo una variable y encontr� otra cosa
          if ( cuentasHandler.existeLaCuenta(variableName) )
          {
        	  expresionFinal = expr.charAt(i) + String.valueOf(0) + strAux;
        	  this.cuentas.add(variableName);
          }
          else
          {
            expresionFinal = expr.charAt(i) + variableName + strAux ;
          }
          resultado= "" ;
          recognizingVar = false ;
        }
        else
        {
          String strAux = ""; 
          strAux += expr.charAt(i);
          expresionFinal = strAux + expresionFinal ;
        }
      }
      i-=1 ;
    }
    return expresionFinal ;
  }
    
  private Expresion obtainSidesOfExp(String formulaString)
  {
    int i = formulaString.length()-1 ;
    Expresion expresion = new Expresion();
    while ( i > 0 )
    {
      if ( formulaString.charAt(i)=='=')
      {
    	  expresion.setNombreExpresion(formulaString.substring(0,i));
//        nombreIndicador = expr.substring(0,i)
    	  expresion.setFormula(formulaString.substring(i+1,formulaString.length()));
    	  i = -1 ;
      }
      	i -= 1 ;
    }
    return expresion ;
  }
}