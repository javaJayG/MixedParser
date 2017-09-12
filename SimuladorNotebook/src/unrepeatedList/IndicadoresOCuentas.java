package unrepeatedList;

public class IndicadoresOCuentas {
	
	private boolean esCuenta ;
	private String nombreDeCuentaOIndicador ;
	
	public IndicadoresOCuentas ( boolean myEsCuenta, 
			String myNombreDeCuentaOIndicador )
	{
		this.esCuenta = myEsCuenta ;
		this.nombreDeCuentaOIndicador = myNombreDeCuentaOIndicador ;
	}

	public boolean isEsCuenta() {
		return esCuenta;
	}

	public void setEsCuenta(boolean esCuenta) {
		this.esCuenta = esCuenta;
	}

	public String getNombreDeCuentaOIndicador() {
		return nombreDeCuentaOIndicador;
	}

	public void setNombreDeCuentaOIndicador(String nombreDeCuentaOIndicador) {
		this.nombreDeCuentaOIndicador = nombreDeCuentaOIndicador;
	}

}
