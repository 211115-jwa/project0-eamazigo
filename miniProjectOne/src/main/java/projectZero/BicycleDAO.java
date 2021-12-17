package projectZero;

import java.util.Set;

	//the BicycleDAO extends the GenericDAO in order to
	//inherit the CRUD methods, and it sets the type of the
	//data to be Pet objects
	public interface BicycleDAO extends GenericDAO<Bicycle> {
		// here, we could add any additional behaviors that are
		// unique to accessing Pet data (not just basic CRUD)
		public Set<Bicycle> getByStatus(String status);

		public int create(Bicycle newBicycle);
	}



