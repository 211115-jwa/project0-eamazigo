package projectZero;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//tell JUnit that we're using Mockito
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	// tell Mockito which classes/interfaces that we'll be mocking
		@Mock
		private BicycleDAO bicycleDao;
		
		@Mock
		private PersonDAOs personDao;
		
		// tell Mockito to override the regular DAOs with our mock DAOs
		@InjectMocks
		private EmployeeService employeeServ = new EmployeeServiceImpl();
		
		@Test
		public void addNewBicycleSuccessfully() {
			Bicycle bicycle = new Bicycle();
			
			when(bicycleDao.create(bicycle)).thenReturn(10);
			
			Bicycle actualBicycle = employeeServ.addNewBicycle(bicycle);
			assertEquals(10, actualBicycle.getId());
		}
		
		@Test
		public void editBicycleSuccessfully( ) {
			Bicycle bicycle = new Bicycle();
			
			when(bicycleDao.create(bicycle)).thenReturn(10);
			
			Bicycle actualBicycle = employeeServ.editBicycle(bicycle);
			assertEquals(10,actualBicycle.getId());
	
		}
		
	
}	
		
		
