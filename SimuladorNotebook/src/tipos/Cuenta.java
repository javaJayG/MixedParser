package tipos;

import java.util.List;

public class Cuenta {
	private List <Periodo> periodos;
	private String nombre;
	
	public Cuenta(String myNombre) {
		nombre = myNombre;
	}
	
	public Cuenta (String myNombre, List<Periodo> myPeriodos) {
		nombre = myNombre;
		periodos=myPeriodos;
	}
	
	public Cuenta(String myNombre, Periodo myPeriodo) {
		nombre = myNombre;
		addPeriodo(myPeriodo);
	}

	public void addPeriodo(Periodo myPeriodo) {
		periodos.add(myPeriodo);
	}
	
	public List<Periodo> getPeriodos(){
		return periodos;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	
}
