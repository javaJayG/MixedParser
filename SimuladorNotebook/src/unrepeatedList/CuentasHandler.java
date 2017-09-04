package unrepeatedList;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import repositorios.TestSerializingAndDeserializing;
import tipos.Cuenta;
import tipos.Empresa;

public class CuentasHandler {
	
	HashSet<String> unrepeatedNombresDeCuentas ;
	
	public CuentasHandler() {
		this.setUnrepeatedCuentasOfAllEmpresas
					(TestSerializingAndDeserializing.getEmpresas());
	}
	
	public void setUnrepeatedCuentasOfAllEmpresas(List<Empresa> empresas)
	{
		this.unrepeatedNombresDeCuentas = new HashSet<>(); 
		Stream <Cuenta>cuentas = empresas.stream()
								.map(e -> e.getCuentas())
								.flatMap(x -> x.stream());
		List<String> nombresDeCuentas = cuentas
								.map(e -> e.getNombre())
								.collect(Collectors.toList());
		nombresDeCuentas.forEach(e -> unrepeatedNombresDeCuentas.add(e));
		unrepeatedNombresDeCuentas.forEach(System.out::println);
		System.out.println("Contiene el HashSet 'EBITDA': "+
				this.existeLaCuenta("EBITDA"));
		System.out.println("Contiene el HashSet 'Carcala': "+
				this.existeLaCuenta("Carcala"));
	}

	public boolean existeLaCuenta(String nombreDeCuenta)
	{
		return this.getUnrepeatedNombresDeCuentas().contains(nombreDeCuenta);
	}

	public HashSet<String> getUnrepeatedNombresDeCuentas() {
		return this.unrepeatedNombresDeCuentas;
	}

	public List<String> getUnrepeatedNombresDeCuentasAsList() {
		return this.getUnrepeatedNombresDeCuentas()
				.stream().collect(Collectors.toList());
	}
	
	public void setUnrepeatedNombresDeCuentas(HashSet<String> unrepeatedNombresDeCuentas) {
		this.unrepeatedNombresDeCuentas = unrepeatedNombresDeCuentas;
	}
	
}





















