package dao;
import java.util.List;
import tipos.*;

public interface DAOPersisted {
	public List<PersistedType> getAllPersisted(PersistedType persisted);
}
