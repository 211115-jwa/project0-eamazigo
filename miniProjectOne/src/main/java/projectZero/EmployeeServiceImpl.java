package projectZero;

	public class EmployeeServiceImpl implements EmployeeService {
		private BicycleDAO bicycleDao = new BicyclePostgres();

		@Override
		public Bicycle addNewBicycle(Bicycle newBicycle) {
				int newId = bicycleDao.create(newBicycle);
				if (newId != 0) {
					newBicycle.setId(newId);
					return newBicycle;
				}
				return null;
		}
		
		@Override
		public Bicycle editBicycle(Bicycle bicycleToEdit) {
			Bicycle bicycleFromDatabase = bicycleDao.getById(bicycleToEdit.getId());
			if (bicycleFromDatabase != null) {
				bicycleDao.update(bicycleToEdit);
				return bicycleDao.getById(bicycleToEdit.getId());
			}
			return null;
		}
		
		@Override
		public Bicycle getBicycleById(int id) {
			Bicycle bicycleFromDatabase = bicycleDao.getById(id);
			if (bicycleFromDatabase != null) {
				Bicycle bicycleById = null;
				bicycleDao.update(bicycleById);
			return bicycleDao.getById(id);
		}
			return bicycleFromDatabase;

		}
	
}

