package projectZero;
import java.util.Set;

public interface UserService {
	// services represent business logic - actual user activities.
	// what can a user do?
	public Person register(Person newUser);
	public Person logIn(String username, String password);
	public Person updateUser(Person userToUpdate);
	public Person buyBicycle(int bicycleId, Person newOwner);
	public Set<Bicycle> viewAvailableBicycles();
	public Set<Bicycle> searchAvailableBicyclesByBrands(String Brands);
	public Set<Bicycle> searchAvailableBicyclesByModels(String Models);
}
