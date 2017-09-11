package testDivideIdAndExpression;

import tipos.Expresion;
import unrepeatedList.CuentasHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


import scala.ScalaUtils;

public class TestDivideIndicador {
	
	String expresion ;
	String formulaString ;
	List<String> cuentas;
	CuentasHandler cuentasHandler;
	
	public static void main ( String[] args)
	{
		TestDivideIndicador test = new TestDivideIndicador();
	}
	
	public TestDivideIndicador ()
	{
		this.cuentasHandler = new CuentasHandler();
		this.cuentas = new ArrayList<>();
		//Si queda un string env�a NumberFormatException por EBITDA
		
		obtainSidesOfExp("IdIndicador=4+EBITDA+-8/0");
		System.out.println("Expresi�n: "+this.expresion);
		imprimirIdAndformula();
	}
	//
	public void imprimirIdAndformula()
	{
		System.out.println("F�rmula: "+this.formulaString);
		System.out.println("Expresi�n: "+this.expresion);
		String formula = transformarVariablesANumeros(this.expresion);
		try
		{
			System.out.println(ScalaUtils.eval(formula));
			System.out.println(ScalaUtils.esIndicadorValido(formula));
			System.out.println(ScalaUtils.sePuedeAplicarA(formula));
			System.out.println("El indicador se puede cargar");
		}
		catch (NumberFormatException e)
		{
			System.out.println("Hubo un error de sintaxis");
		}
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
	      if ( (expr.charAt(i) >='a' && expr.charAt(i)<='z') || 
	    		  (expr.charAt(i)>='A' && expr.charAt(i)<='Z') )
	      {
	        resultado += expr.charAt(i) ;
	        if ( !recognizingVar )  {
	          recognizingVar = true ;
	        }
	        //Encontr� la variable que se halla m�s a la izquierda de la expresi�n,
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
	        	  System.out.println("Si esto anda estamo activo: "+ScalaUtils.eval(expresionFinal));
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
	
	private void obtainSidesOfExp(String myFormulaString)
	  {
	    int i = myFormulaString.length()-1 ;
	    while ( i > 0 )
	    {
	      if ( myFormulaString.charAt(i)=='=')
	      {
	    	  this.formulaString=myFormulaString.substring(0,i);
//	        nombreIndicador = expr.substring(0,i)
	    	  this.expresion=myFormulaString.substring(i+1,myFormulaString.length());
	    	  i = -1 ;
	      }
	      	i -= 1 ;
	    }
	  }
	
}
