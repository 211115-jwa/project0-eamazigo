package projectZero;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// tell JUnit that we're using Mockito
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	// tell Mockito which classes/interfaces that we'll be mocking
	@Mock
	private BicycleDAO bicycleDao;
	
	@Mock
	private PersonDAOs personDao;
	
	// tell Mockito to override the regular DAOs with our mock DAOs
	@InjectMocks
	private UserService userServ = new UserServiceImp();
	
	private static Set<Bicycle> mockAvailableBicycles;
	
	@BeforeAll
	public static void mockAvailableBicyclesSetup() {
		mockAvailableBicycles = new HashSet<>();
		
		for (int i=1; i<=5; i++) {
			Bicycle bicycle = new Bicycle();
			bicycle.setId(i);
			if (i<3)
				bicycle.setBrand("colnago");
			mockAvailableBicycles.add(bicycle);
		}
	}
	
	@Test
	public void logInSuccessfully() {
		// input setup
		String username="qwertyuiop";
		String password="pass";
		
		// set up the mocking
		Person mockPerson = new Person();
		mockPerson.setUsername(username);
		mockPerson.setPassword(password);
		when(personDao.getByUsername(username)).thenReturn(mockPerson);
		
		// call the method we're testing
		Person actualPerson = userServ.logIn(username, password);
		
		// assert the expected behavior/output
		assertEquals(mockPerson,actualPerson);
	}
	
	@Test
	public void logInIncorrectPassword() {
		String username="qwertyuiop";
		String password="12345";
		
		Person mockPerson = new Person();
		mockPerson.setUsername(username);
		mockPerson.setPassword("pass");
		when(personDao.getByUsername(username)).thenReturn(mockPerson);
		
		Person actualPerson = userServ.logIn(username, password);
		assertNull(actualPerson);
	}
	
	@Test
	public void logInUsernameDoesNotExist() {
		String username="asdfghjkl";
		String password="pass";
		
		when(personDao.getByUsername(username)).thenReturn(null);
		
		Person actualPerson = userServ.logIn(username, password);
		assertNull(actualPerson);
	}
	
	@Test
	public void registerPersonSuccessfully() {
		Person person = new Person();
		
		when(personDao.create(person)).thenReturn(10);
		
		Person actualPerson = userServ.register(person);
		assertEquals(10, actualPerson.getId());
	}
	
	@Test
	public void registerPersonSomethingWrong() {
		Person person = new Person();
		when(personDao.create(person)).thenReturn(0);
		Person actualPerson = userServ.register(person);
		assertNull(actualPerson);
	}
	
	@Test
	public void searchByBrandsExists() {
		String brand = "colnago";
		
		when(bicycleDao.getAll()).thenReturn(mockAvailableBicycles);
		
		Set<Bicycle> actualBicycles = userServ.searchAvailableBicyclesByBrands(brand);
		boolean onlyBicycles = true;
		for (Bicycle bicycle : actualBicycles) {
			if (!bicycle.getBrand().equals(brand))
				onlyBicycles = false;
		}
		
		assertTrue(onlyBicycles);
	}
	
	@Test
	public void searchByBrandsDoesNotExist() {
		String brand = "qwertyuiop";
		
		when(bicycleDao.getAll()).thenReturn(mockAvailableBicycles);
		
		Set<Bicycle> actualBicycles = userServ.searchAvailableBicyclesByBrands(brand);
		assertTrue(actualBicycles.isEmpty());
	}
	
	@Test
	public void searchByModelsExists() {
		String model = "classic arabesque";
		
		when(bicycleDao.getAll()).thenReturn(mockAvailableBicycles);
		
		Set<Bicycle> actualBicycles = userServ.searchAvailableBicyclesByBrands(model);
		boolean onlyBicycles = true;
		for (Bicycle bicycle : actualBicycles) {
			if (!bicycle.getModel().equals(model))
				onlyBicycles = false;
		}
		
		assertTrue(onlyBicycles);
	}
	
	@Test
	public void searchByModelDoesNotExist() {
		String model = "qwertyuiop";
		
		when(bicycleDao.getAll()).thenReturn(mockAvailableBicycles);
		
		Set<Bicycle> actualBicycles = userServ.searchAvailableBicyclesByModels(model);
		assertTrue(actualBicycles.isEmpty());
	}
	@Test
	public void buyBicycleSuccessfully() {
	
	}
	
	@Test
	public void buyBicycleAlreadyBought() {
		
	}
}