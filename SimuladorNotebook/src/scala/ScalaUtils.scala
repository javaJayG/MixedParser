package scala

object ScalaUtils {
  def reverseThis( original : String) 
  : String =
  {
    original.reverse
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
         * si es este el caso, entonces estamos ante un n�mero negativo, 
         * por lo tanto, no hago nada...
         * TODO: arreglar el caso en que el nro negativo est� entre par�ntesis
         * "6+5*(-2)"
         */
      }
      else if ( parensCount == 0 && expr(i)=='+' || expr(i)=='-' )
      {
        opLoc = i
        i = -1
      }
      
      /*
       * si todav�a no guard� ning�n operador, no estoy dentro de par�ntesis
       * y encontr� un * o un /, entonces simplemente guardo la posici�n del
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
        //todo estaba entre par�ntesis
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
        case '/' => {
          
          val doubleOf = eval(expr.substring(0, opLoc))/eval(expr.substring(opLoc+1,expr.length))
          if (doubleOf.isInfinite())
            0.0
          else
            doubleOf
        }
      }
    }
  }
}