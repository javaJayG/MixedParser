package scala

object ScalaUtils {
  def reverseThis( original : String) 
  : String =
  {
    original.reverse
  }
  
   def esIndicadorValido(expresion:String):Boolean = {
   try
   {
   	  eval(expresion)
    	true
    }
    catch
    {
      case e : ArithmeticException => true
    }
  }
   
   def sePuedeAplicarA(expresion:String):Boolean = {
     if ( eval(expresion).isInfinite())
     {
       println("Infinito!")
       false
     }
     else
     {
       println("Correcto, es un número!")
       true
     }
   }
   
  
  def eval (expr:String):Double = 
  {
    
    //Hallar operador de menor precedencia
    var parensCount = 0
    var opLoc = -1
    var i = expr.length-1
    while ( i > 0 )
    {
      if ( expr(i)==')')
      {
        parensCount += 1
      }
      else if (expr(i)=='(')
      {
        parensCount -= 1
      }
      else if ( parensCount == 0 && expr(i) == '-' && 
                ( expr(i-1)=='+' || expr(i-1)=='*' || expr(i-1)=='/'))
      {
        /*
         * si es este el caso, entonces estamos ante un nï¿½mero negativo, 
         * por lo tanto, no hago nada...
         * TODO: arreglar el caso en que el nro negativo estï¿½ entre parï¿½ntesis
         * "6+5*(-2)"
         */
      }
      else if ( parensCount == 0 && expr(i)=='+' || expr(i)=='-' )
      {
        opLoc = i
        i = -1
      }
      
      /*
       * si todavï¿½a no guardï¿½ ningï¿½n operador, no estoy dentro de parï¿½ntesis
       * y encontrï¿½ un * o un /, entonces simplemente guardo la posiciï¿½n del
       * operador 
       */
      else if ( parensCount == 0 && opLoc < 0 && expr(i)=='*' || expr(i)=='/')
      {
        opLoc = i
      }
      i -= 1
    }
    
    //Deal with it
    if (opLoc < 0)
    {
      if (expr.trim()(0) =='(')
      {
        //todo estaba entre parï¿½ntesis
        eval(expr.substring(1, expr.length()-1))
      }
      else
      {
            expr.toDouble
      }
    }
    else 
    {
      expr(opLoc) match {
        case '+' => eval(expr.substring(0, opLoc))+eval(expr.substring(opLoc+1,expr.length))
        case '-' => eval(expr.substring(0, opLoc))-eval(expr.substring(opLoc+1,expr.length))
        case '*' => eval(expr.substring(0, opLoc))*eval(expr.substring(opLoc+1,expr.length))
        case '/' => eval(expr.substring(0, opLoc))/eval(expr.substring(opLoc+1,expr.length))
//        {
//          
//          val doubleOf = eval(expr.substring(0, opLoc))/eval(expr.substring(opLoc+1,expr.length))
//          if (doubleOf.isInfinite())
//            0.0
//          else
//            doubleOf
//        }
      }
    }
  }
}