package projectZero;

import java.util.Set;

public interface GenericDAO<D> {
	// DAO: data access object
	// an object that is designed for exclusively accessing data (e.g. in a database)
	// the <D> generic type represents the type of Data you are working with (person, pet, etc)
	// accessing the database should use CRUD operations:
	// create, read, update, delete
	
	public int create(D dataToAdd);
	public D getById(int id);
	public Set<D> getAll();
	public void update(D dataToUpdate);
	public void delete(D dataToDelete);
}

