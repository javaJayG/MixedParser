package repositorios;
import tipos.*;
import java.util.List;

import dao.DAOJson;

public class RepoEmpresa extends PersistedRepo{
	
	
	public RepoEmpresa() {
		persisted = new Empresa("Facebook");
		filePath = this.baseFilePath() + "empresas.json"; 
		daoPersisted = new DAOJson();
	}
	
	public List<PersistedType> getAllPersisted(){
		List<PersistedType> empresas =  this.daoPersisted.getAllPersisted(persisted);
		System.out.println(empresas.get(0).getNombre());
		return empresas;
	}
	
}
