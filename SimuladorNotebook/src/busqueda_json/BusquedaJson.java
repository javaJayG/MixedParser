package busqueda_json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tipos.*;

public class BusquedaJson {
	public static void main(String[] args) {
		try {
			File file = new File ("C:\\pruebas\\output.json");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line ;
			Gson gson = new Gson();
			List<Empresa>empresasParseadas = new ArrayList<Empresa>();
			while ((line = bufferedReader.readLine())!=null) {
				Empresa empresa = gson.fromJson(line, Empresa.class);
				empresasParseadas.add(empresa);
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			
			
			
//			empresasParseadas.forEach(System.out::println);
			
			List<List <Cuenta>> listaDeCuentas = 
					empresasParseadas.stream().filter(e -> "Facebook".equals(e.getNombre()))
									.map(e->e.getCuentas())
									.collect(Collectors.toList());
			List<Cuenta> cuentas = listaDeCuentas.stream()
									.flatMap(List::stream)
									.collect(Collectors.toList());
			Gson gson_2 = new GsonBuilder().setPrettyPrinting().create();
			cuentas.forEach(e->System.out.println(e.getNombre()+gson_2.toJson(e.getPeriodos())));
			fileReader.close();
			System.out.println("Content of file:");
//			System.out.println(stringBuffer);
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
}
