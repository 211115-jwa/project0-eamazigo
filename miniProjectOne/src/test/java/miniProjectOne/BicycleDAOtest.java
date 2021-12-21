package miniProjectOne;
import projectZero.Bicycle;
import projectZero.BicycleDAO;
import projectZero.BicyclePostgres;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotEquals;
import java.util.Set;

public class BicycleDAOtest {
	
	private BicycleDAO bicycleDao = new BicyclePostgres();
	
	@Test 
	public void getByIdWhenIdExists() {
		// test setup
		int idInput = 1;
		// call the method to be tested
		Bicycle idOutput = bicycleDao.getById(idInput);
		// assert that it did what we expected
		assertEquals(1, idOutput.getId());
	}
	

	@Test
	public void getByIdWhenIdDoesNotExists() {
		int idInput = -1;
		Bicycle petOutput =bicycleDao.getById(idInput);
		assertNull(petOutput);
	}
	

	@Test
	public void getAll() {
		Set<Bicycle> givenOutput = bicycleDao.getAll();
		assertNull(givenOutput);
		// assertNotNull(bikeDao.getall();
	}
	
	@Test
	public void addNewBicycle() {
		Bicycle newBicycle = new Bicycle();
		System.out.println(newBicycle);
		
		int generatedId = bicycleDao.create(newBicycle);
		
		assertNotEquals(0, generatedId);
		System.out.println(generatedId);
	}
	
}
