package repositorios;
import tipos.Cuenta;

import tipos.Empresa;
import tipos.Periodo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

public class TestSerializingAndDeserializing {
	

	private static final int SHIFT_MONTH = - 1 ; 
	private static final int SHIFT_YEAR = -1900 ;
	
	
	public static void main ( String args[]) {
		compare(getEmpresas());
	}
	
	public static List<Empresa> getEmpresas() {
		
		//TODO: manejar el tema de las fechas como strings
		
		//cargo varios periodos a esas cuentas
		List<Periodo> periodos_uno_ROE = new ArrayList<Periodo>();
		List<Periodo> periodos_uno_EBITDA = new ArrayList<Periodo>();
		List<Periodo> periodos_uno_IngresoNeto = new ArrayList<Periodo>();
		
		List<Periodo> periodos_dos_IngresoNeto = new ArrayList<Periodo>();
		List<Periodo> periodos_dos_EBITDA = new ArrayList<Periodo>();
		List<Periodo> periodos_dos_ROE = new ArrayList<Periodo>();
		
		List<Periodo> periodos_tres_IngresoNeto = new ArrayList<Periodo>();
		List<Periodo> periodos_tres_EBITDA = new ArrayList<Periodo>();
		List<Periodo> periodos_tres_ROE = new ArrayList<Periodo>();
		
		Date initialDate2014 = new Date (2014 + SHIFT_YEAR, 01 + SHIFT_MONTH, 01, 00, 00, 00) ;
		Date finalDate2014 = new Date (2014 + SHIFT_YEAR, 12 + SHIFT_MONTH, 31, 00, 00, 00) ;
		Date initialDate2015 = new Date (2015 + SHIFT_YEAR, 01 + SHIFT_MONTH, 01, 00, 00, 00) ;
		Date finalDate2015 = new Date (2015 + SHIFT_YEAR, 12 + SHIFT_MONTH, 31, 00, 00, 00) ;
		Date initialDate2016 = new Date (2016 + SHIFT_YEAR, 01 + SHIFT_MONTH, 01, 00, 00, 00) ;
		Date finalDate2016 = new Date (2016 + SHIFT_YEAR, 12 + SHIFT_MONTH, 31, 00, 00, 00) ;
		
		periodos_uno_ROE.add(new Periodo(initialDate2014, finalDate2014, 50000));
		periodos_uno_ROE.add(new Periodo(initialDate2015, finalDate2015, 60000));
		periodos_uno_ROE.add(new Periodo(initialDate2016, finalDate2016, 70000));
		
		periodos_uno_EBITDA.add(new Periodo(initialDate2016, finalDate2016, 111111));
		periodos_uno_EBITDA.add(new Periodo(initialDate2015, finalDate2015, 123456));
		periodos_uno_EBITDA.add(new Periodo(initialDate2014, finalDate2014, 50000));
		
		periodos_uno_IngresoNeto.add(new Periodo(initialDate2014, finalDate2014, 555));
		periodos_uno_IngresoNeto.add(new Periodo(initialDate2015, finalDate2015, 789789));
		periodos_uno_IngresoNeto.add(new Periodo(initialDate2016, finalDate2016, 123654));
		
		periodos_dos_ROE.add(new Periodo(initialDate2014, finalDate2014, 66546));
		periodos_dos_ROE.add(new Periodo(initialDate2015, finalDate2015, 64555));
		periodos_dos_ROE.add(new Periodo(initialDate2016, finalDate2016, 65465));
		
		periodos_dos_EBITDA.add(new Periodo(initialDate2016, finalDate2016, 98798));
		periodos_dos_EBITDA.add(new Periodo(initialDate2015, finalDate2015, 74145));
		periodos_dos_EBITDA.add(new Periodo(initialDate2014, finalDate2014, 87397));
		
		periodos_dos_IngresoNeto.add(new Periodo(initialDate2014, finalDate2014, 11698));
		periodos_dos_IngresoNeto.add(new Periodo(initialDate2015, finalDate2015, 48632));
		periodos_dos_IngresoNeto.add(new Periodo(initialDate2016, finalDate2016, 48963));
		
		periodos_tres_ROE.add(new Periodo(initialDate2014, finalDate2014, 963963));
		periodos_tres_ROE.add(new Periodo(initialDate2015, finalDate2015, 17888));
		periodos_tres_ROE.add(new Periodo(initialDate2016, finalDate2016, 664654132));
		
		periodos_tres_EBITDA.add(new Periodo(initialDate2016, finalDate2016, 8946));
		periodos_tres_EBITDA.add(new Periodo(initialDate2015, finalDate2015, 56613));
		periodos_tres_EBITDA.add(new Periodo(initialDate2014, finalDate2014, 849846));
		
		periodos_tres_IngresoNeto.add(new Periodo(initialDate2014, finalDate2014, 25156));
		periodos_tres_IngresoNeto.add(new Periodo(initialDate2015, finalDate2015, 52153));
		periodos_tres_IngresoNeto.add(new Periodo(initialDate2016, finalDate2016, 4864698));
		
		//cargo varias cuentas a esas empresas
		List<Cuenta> cuentas_fb= new ArrayList<Cuenta>();
		List<Cuenta> cuentas_ebay= new ArrayList<Cuenta>();
		List<Cuenta> cuentas_amazon= new ArrayList<Cuenta>();
		
		cuentas_fb.add(new Cuenta("AccionesEnBitCoins", periodos_uno_ROE));
		cuentas_fb.add(new Cuenta("ROE", periodos_uno_ROE));
		cuentas_fb.add(new Cuenta("EBITDA", periodos_uno_EBITDA));
		cuentas_fb.add(new Cuenta("IngresoNeto", periodos_uno_IngresoNeto));
		
		cuentas_ebay.add(new Cuenta("ROE", periodos_dos_ROE));
		cuentas_ebay.add(new Cuenta("EBITDA", periodos_dos_EBITDA));
		cuentas_ebay.add(new Cuenta("IngresoNeto", periodos_dos_IngresoNeto));
		
		cuentas_amazon.add(new Cuenta("ROE", periodos_tres_ROE));
		cuentas_amazon.add(new Cuenta("EBITDA", periodos_tres_EBITDA));
		cuentas_amazon.add(new Cuenta("IngresoNeto", periodos_tres_IngresoNeto));
		
		//cargo varias empresas
		Empresa fb = new Empresa("Facebook", cuentas_fb);
		Empresa ebay = new Empresa("ebay",cuentas_ebay);
		Empresa amazon = new Empresa("Amazon", cuentas_amazon);

		List <Empresa> empresas = new ArrayList<Empresa>();
		empresas.add(fb);
		empresas.add(ebay);
		empresas.add(amazon);
		return empresas;
		
	}
	
	public static void compare(List<Empresa> cuentas) {
		
		System.out.println(cuentas.get(0));
		Empresa fb = cuentas.get(0);
		Gson gson = new Gson();
		
		String accGson = gson.toJson(fb);
		System.out.println(accGson);
		
		Empresa fb_2 = gson.fromJson(accGson, Empresa.class);
		
		String fb_2Json = gson.toJson(fb_2);
		
		System.out.println(fb_2Json);
		
		
	}
	
	public static List <String> getJsonOfEmpresas(){
		
		List <String> empresasJson = new ArrayList<>();
		
		List<Empresa> empresas = getEmpresas();
		
		Gson gson = new Gson();
		
		for ( Empresa e : empresas) {
			empresasJson.add(gson.toJson(e));
		}
		return empresasJson;
	}
	
	public static List<String> gimmeAccounts(){
		List<String> accounts = new ArrayList<String>();
		accounts.add("ROE");
		accounts.add("EBITDA");
		accounts.add("Ventas discontinuadas");
		return accounts;
	}
	
}
