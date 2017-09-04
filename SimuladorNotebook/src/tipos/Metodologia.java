package tipos;

public class Metodologia implements PersistedType {
	private String nombre ;
	public Metodologia( String myNombre) {
		this.setNombre(myNombre);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
