package testsCargaJsonYLecturaJson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import repositorios.*;
import tipos.Cuenta;
import tipos.Empresa;
import tipos.Periodo;

public class TestGuardadoYCargaDeArchivosJson {
	
	public static void main(String[] args) {
		PersistedRepo repositorioDeEmpresas = new RepoEmpresa();
		repositorioDeEmpresas.getAllPersisted();
		System.out.println(repositorioDeEmpresas.getFilePath());
		
		List<String> empresas = TestSerializingAndDeserializing.getJsonOfEmpresas();
		
		try {
		    FileWriter writer = new FileWriter("C:\\pruebas\\output.json");
		    for ( String e: empresas) {
		    	writer.write(e);
		    	writer.write("\n");
		    }
		    writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
