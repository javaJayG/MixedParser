package dao;

import java.util.Arrays;
import java.util.List;

import tipos.PersistedType;

public class DAOJson implements DAOPersisted {
	public List<PersistedType> getAllPersisted(PersistedType persisted){
		return Arrays.asList(persisted);
	}
}
