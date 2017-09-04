package tipos;

import java.util.List;

public class Empresa implements PersistedType {
	private String nombre ;
	private List <Cuenta> cuentas;
	public Empresa( String myNombre) {
		this.setNombre(myNombre);
	}
	
	public Empresa (String myNombre, List<Cuenta> myCuentas) {
		nombre = myNombre;
		cuentas=myCuentas;
	}
	
	public Empresa(String myNombre, Cuenta myCuenta) {
		nombre = myNombre;
		addCuenta(myCuenta);
	}

	
	public String getNombre() {
		return nombre;
	}
	
	
	public void addCuenta(Cuenta myCuenta) {
		cuentas.add(myCuenta);
	}
	
	public List<Cuenta> getCuentas(){
		return cuentas;
	}

	@Override
	public void setNombre(String nombre) {
	
	}
}
