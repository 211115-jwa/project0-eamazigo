package miniProjectOne;
import java.util.HashSet;
import java.util.Set;
import projectZero.Bicycle;
import projectZero.BicycleDAO;

	public class BicycleCollection implements BicycleDAO {
		private Set<Bicycle> allBicycles = new HashSet<>();
		private int lastindex;

		public BicycleCollection() {
			allBicycles = new HashSet<>();
			Bicycle bicycle1 = new Bicycle();
			bicycle1.setStatus("available");
			allBicycles.add(bicycle1);
			
			lastindex = 0;
		}
		
		@Override
		public int create(Bicycle dataToAdd) {
			dataToAdd.setId(lastindex);
			allBicycles.add(dataToAdd);
			lastindex++;
			return dataToAdd.getId();
		}

		@Override
		public Bicycle getById(int id) {
			for (Bicycle bicycle : allBicycles) {
				if (bicycle.getId() == id) {
					return bicycle;
				}
		}
		return null;
		}
		@Override
		public Set<Bicycle> getAll() {
		
			return allBicycles;
		}

		@Override
		public Set<Bicycle> getByStatus(String status) {
	
			return null;
		}

		@Override
		public void update(Bicycle dataToUpdate) {
			Bicycle previousData = getById(dataToUpdate.getId());
			if (previousData != null) {
				allBicycles.remove(previousData);
				allBicycles.add(dataToUpdate);
			}
			
		}

		@Override
		public void delete(Bicycle dataToDelete) {
			Bicycle previousData = getById(dataToDelete.getId());
			if (previousData != null) {
				allBicycles.remove(previousData);
			
		}

	}

}


