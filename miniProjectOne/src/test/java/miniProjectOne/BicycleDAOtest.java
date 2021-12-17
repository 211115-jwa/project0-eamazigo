package miniProjectOne;
import projectZero.Bicycle;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotEquals;

public class BicycleDAOtest {
@Test
	public void addNewBicycle() {
		Bicycle newBicycle = new Bicycle();
		System.out.println(newBicycle);
		
		int generatedBikeId = BicycleDAOtest.create(newBicycle);
		
		assertNotEquals(0, generatedBikeId);
	}

private static int create(Bicycle newBicycle) {
	// TODO Auto-generated method stub
	return 0;
}
}



