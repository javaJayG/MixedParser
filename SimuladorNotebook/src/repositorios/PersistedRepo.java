package repositorios;
import tipos.*;

import java.util.List;

import dao.*;

public abstract class PersistedRepo {
	
	DAOPersisted daoPersisted;
	PersistedType persisted;
	String filePath ;
	
	public String getFilePath() {
		return this.filePath;
	}
	
	public String baseFilePath() {
		return "c:\\pruebas\\";
	}
	
	public abstract List<PersistedType> getAllPersisted();
	
}
