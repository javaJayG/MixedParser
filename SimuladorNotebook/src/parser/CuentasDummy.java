package parser;

public class CuentasDummy {
	String nombre ;
	int cotizacion ;
	public CuentasDummy(String myNombre, int myCotizacion)
	{
		this.nombre=myNombre ;
		this.cotizacion=myCotizacion ;
	}
	
	public String getNombre ()
	{
		return this.nombre ;
	}
	public int getCotizacion()
	{
		return this.cotizacion;
	}
	
}
