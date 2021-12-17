package projectZero;

public interface EmployeeService {

		// services represent business logic - actual user activities.
		// what can an employee do?
		public Bicycle addNewBicycle(Bicycle newBicycle);
		public Bicycle editBicycle(Bicycle bicycleToEdit);
		public Bicycle getBicycleById(int id);
	}



