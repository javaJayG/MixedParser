package testTransformarVariablesANumeros;

import java.util.ArrayList;
import java.util.List;

import scala.ScalaUtils;
import tipos.Expresion;
import unrepeatedList.CuentasHandler;

public class TestTransformarVariablesANumeros {
	
	private CuentasHandler cuentasHandler ;
	List <String> cuentas ;
	
	public TestTransformarVariablesANumeros()
	{
		this.cuentasHandler = new CuentasHandler();
		this.cuentas = new ArrayList<>();
		this.transformarVariablesANumeros("EBITDA+ROE");
	}
	
	public static void main(String[] args) {
		TestTransformarVariablesANumeros id = new TestTransformarVariablesANumeros();
	}
	
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
	          //si estaba reconociendo una variable y encontró otra cosa
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
	
}
