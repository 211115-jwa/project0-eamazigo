package projectZero;
import java.util.Set;
import java.util.stream.Collectors;

public class UserServiceImp implements UserService {
	private PersonDAOs personDao = new PersonPostgres();
	private BicycleDAO bicycleDao = new BicyclePostgres();

	@Override
	public Person register(Person newUser) {
		int newId = personDao.create(newUser);
		if (newId != 0) {
			newUser.setId(newId);
			return newUser;
		}
		return null;
	}

	@Override
	public Person logIn(String username, String password) {
		Person personFromDatabase = personDao.getByUsername(username);
		if (personFromDatabase != null && personFromDatabase.getPassword().equals(password)) {
			return personFromDatabase;
		}
		return null;
	}

	@Override
	public Person updateUser(Person userToUpdate) {
		if (personDao.getById(userToUpdate.getId()) != null) {
			personDao.update(userToUpdate);
			userToUpdate = personDao.getById(userToUpdate.getId());
			return userToUpdate;
		}
		return null;
	}

	@Override
	public Person buyBicycle(int bicycleId, Person newOwner) {
		Bicycle bicycleToBuy = bicycleDao.getById(bicycleId);
		if (bicycleToBuy.getStatus().equals("Available")) {
			bicycleToBuy.setStatus("Sold");
			newOwner.getBicycles().add(bicycleToBuy);
			
			bicycleDao.update(bicycleToBuy);
			personDao.update(newOwner);
			return newOwner;
		}
		return null;
	}

	@Override
	public Set<Bicycle> viewAvailableBicycles() {
		return bicycleDao.getByStatus("Available");
	}

	@Override
	public Set<Bicycle> searchAvailableBicyclesByBrands(String brands) {
		Set<Bicycle> availableBicycles = bicycleDao.getByStatus("Available");
		
		/* 
		   using a Stream to filter the pets
		   "filter" takes in a Predicate (functional interface)
		   and iterates through each bicycle, adding the pet to the stream
		   if the predicate returns "true"
		*/
		availableBicycles = availableBicycles.stream()
				.filter(Bicycle -> Bicycle.getBrand().toLowerCase().contains(brands.toLowerCase()))
				.collect(Collectors.toSet());
		
		// if you don't want to use a Stream, you can always just
		// do this yourself using a for loop :) it will do the same thing!
		/*
		 * Set<Pet> bicyclesByBrands = new HashSet<>();
		 * for (Bicycle bicycle : availableBicycles) {
		 * 		if(bicycle.getBrands().toLowercase().contains(species.toLowercase())) {
		 * 			petsByBrands.add(bicycle);
		 * 		}
		 * }
		 * 
		 * availableBicycles = bicyclesByBrands;
		 */
		
		return availableBicycles;
	}
	
	@Override
	public Set<Bicycle> searchAvailableBicyclesByModels(String models) {
		Set<Bicycle> availableBicycles = bicycleDao.getByStatus("Available");
	
		availableBicycles = availableBicycles.stream()
				.filter(Bicycle -> Bicycle.getBrand().toLowerCase().contains(models.toLowerCase()))
				.collect(Collectors.toSet());
			
		return availableBicycles;
	}	
}
