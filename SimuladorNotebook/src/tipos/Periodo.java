package tipos;

import java.util.Date;

public class Periodo {
	String fechaInicio;
	String fechaFin;
	int cotizacion;
	
	public Periodo(Date fecInic, Date fecFin, int myCot) {
		fechaInicio = fecInic.toString();
		fechaFin = fecFin.toString();
		cotizacion = myCot;
	}
	
	public String toString () {
		return this.fechaInicio+" - "+this.fechaFin;
	}
	
	public int getCotizacion () {
		return this.cotizacion;
	}
	
}
