package miniProjectOne;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectZero.Person;
import projectZero.PersonDAOs;

// this imports the static methods from Assertions so that
// we can type "assertEquals" rather than "Assertions.assertEquals"
import static org.junit.jupiter.api.Assertions.*;

//@TestMethodOrder(Alphanumeric.class)
//@TestMethodOrder(OrderAnnotation.class)
public class PersonDAOtest {
	private PersonDAOs personDao = new PersonCollection();
	
	//@Order(1)
	@Test
	public void getByUsernameWhenUsernameExists() {
		// setup
		String usernameInput = "Ezekiel";
		// call the method we're testing
		Person personOutput = personDao.getByUsername(usernameInput);
		// assert that it did what we expected
		assertEquals("Ezekiel", personOutput.getUsername());
	}
	
	//@Order(2)
	@Test
	public void getByUsernameButUsernameDoesNotExist() {
		String usernameInput = "qwertyuiop";
		Person personOutput = personDao.getByUsername(usernameInput);
		assertNull(personOutput); // assertEquals(null, personOutput)
	}
	
	// JUnit tests will be annotated with @Test
	// they are public, void, and have no parameters
	@Test
	public void basicTest() {
		// setup
		StringBuilder input = new StringBuilder("tyron");
		// call the method we're testing
		input.reverse();
		// check for the expected behavior
		Assertions.assertEquals("noryt", input.toString());
	}
	
	@Test
	public void basicTest2() {
		// setup
		StringBuilder input = new StringBuilder("hello");
		// call the method we're testing
		String output = input.substring(0,1);
		// check for the expected behavior
		Assertions.assertEquals("h", output);
	}
	
	@BeforeAll // this method will run ONCE before any of our tests run
	public static void setup() {
		System.out.println("this happens before any tests");
	}
	
	@BeforeEach // this method runs before each test
	public void beforeEachTest() {
		System.out.println("this happens before each test");
	}
	
	@AfterEach // this method runs after each test
	public void afterEachTest() {
		System.out.println("this happens after each test");
	}
	
	@AfterAll // this method will run ONCE after all tests have completed
	public static void tearDown() {
		System.out.println("this happens after all the tests have completed");
	}
}



