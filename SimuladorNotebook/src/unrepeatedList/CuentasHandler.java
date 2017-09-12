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
	HashSet<String> unrepeatedNombresDeIndicadres ;
	
	public CuentasHandler() {
		this.setUnrepeatedCuentasEIndicadores
					( TestSerializingAndDeserializing.getEmpresas () );
		//recordar que getEmpresas devuelve las empresas que están en
		//memoria, no las está leyendo AHORA del archivo,
		//pero definitivamente lo sabe hacer
					//don't forget getIndicadores!!!
					//getEmpresas() -> devuelve cuentas
					//--------------------------------
	}
	
	public void setUnrepeatedCuentasEIndicadores( List <Empresa> empresas )
	{
		this.unrepeatedNombresDeCuentas = new HashSet<>(); 
		Stream <Cuenta>cuentas = empresas.stream()
								.map(e -> e.getCuentas())
								.flatMap(x -> x.stream());
		List<String> nombresDeCuentas = cuentas
								.map(e -> e.getNombre())
								.collect(Collectors.toList());
		//TODO a cada uno estos los creo como un List<SinRepetirIndicadoresYCuentas>
		//del siguiente modo, 
		//
		//nombresDeCuentas.forEach(e -> 
		// 			{nuevaCuenta = new SinRepetirIndicadoresYCuentas(true,e);
		//				CuentasEIndicadoresSinRepetir.add(nuevaCuenta);
		//						}	
		// 							)
		//
		nombresDeCuentas.forEach(e -> unrepeatedNombresDeCuentas.add(e));
		//unrepeatedNombresDeCuentas ya no es de strings sino de
		//CuentasEIndicadoresSinRepetir
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





















