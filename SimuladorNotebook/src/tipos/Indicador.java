package tipos;

import java.util.ArrayList;
import java.util.List;

public class Indicador implements PersistedType {
	private String nombre ;
	private String formula ;
	private List<String> cuentas ;
	private List<String> indicadores ;
	
	public static void main(String[] args) {
		Indicador esInd = new Indicador ("Indicatory=ROE+EBITDA/7");
		esInd.guardarIndicadorSiEsPosible();
	}
	
	public Indicador( String formula) {
		this.setFormula(formula);
		cuentas = new ArrayList<>();
		indicadores = new ArrayList<>();
	}
	
	public void guardarIndicadorSiEsPosible()
	{
//		this.parser.guardarIndicadorSiEsPosible();
	}
	
	public String getFormula() {
		return formula;
	}
	
	public void addNombreDeCuenta(String nombreDeCuenta)
	{
		this.cuentas.add(nombreDeCuenta);
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public List<String> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<String> cuentas) {
		this.cuentas = cuentas;
	}
	
	public boolean sePuedeAplicar(Empresa e,Periodo p){
		return true ;
	}
	
	public double aplicar(Empresa e , Periodo p ){
		return 0;
	}

	public List<String> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(List<String> indicadores) {
		this.indicadores = indicadores;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
