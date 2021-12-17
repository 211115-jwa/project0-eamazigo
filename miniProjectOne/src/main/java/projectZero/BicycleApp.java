package projectZero;
import io.javalin.Javalin;
import io.javalin.http.HttpCode;

// this static import is for the path and for get/post/put methods
import static io.javalin.apibuilder.ApiBuilder.*;
import java.util.Set;
import org.eclipse.jetty.http.HttpStatus;

public class BicycleApp {
	private static UserService userServ = new UserServiceImp();
	private static EmployeeService empServ;

	public static void main(String[] args) {
		Javalin app = Javalin.create();
		
		app.start();
		
		/*
		 what end-points do we need?
		 in other words, what actions would a user need to do
		 and what address + HTTP method combo would represent
		 each of those actions?
		 (in your p0, these end-points are provided to you.)
		*/
		app.routes(() -> {
			//Listening on http://localhost:8080/
			path("/bicycle_app", () -> {
				get(ctx -> {
					// checking if they did /bicycles?brand=
					String brandSearch = ctx.queryParam("brand");
					// when using .equals with a String literal, put the
					// String literal first because it prevents null pointer
					// exceptions
					if (brandSearch != null && !"".equals(brandSearch)) {
						Set<Bicycle> bicyclesFound = userServ.searchAvailableBicyclesByBrands(brandSearch);
						ctx.json(bicyclesFound);
					} else {
						// if they didn't put ?brands
						Set<Bicycle> availableBicycles = userServ.viewAvailableBicycles();
						ctx.json(availableBicycles);
					}
					
				});
				path("/bicycle_app", () -> {
					get(ctx -> {
						// checking if they did /bicycles?model=
						String modelSearch = ctx.queryParam("model");
						// when using .equals with a String literal, put the
						// String literal first because it prevents null pointer
						// exceptions
						if (modelSearch != null && !"".equals(modelSearch)) {
							Set<Bicycle> bicyclesFound = userServ.searchAvailableBicyclesByBrands(modelSearch);
							ctx.json(bicyclesFound);
						} else {
							// if they didn't put ?brands
							Set<Bicycle> availableBicycles = userServ.viewAvailableBicycles();
							ctx.json(availableBicycles);
						}
						
					});
				post(ctx -> {
					// bodyAsClass turns JSON into a Java object based on the class you specify
					Bicycle newBicycle = ctx.bodyAsClass(Bicycle.class);
					if (newBicycle !=null) {
						empServ.addNewBicycle(newBicycle);
						ctx.status(HttpStatus.CREATED_201);
					} else {
						ctx.status(HttpStatus.BAD_REQUEST_400);
					}
				});
				
				//Listening on http://localhost:8080/
				path("/buy/{id}", () -> {
					put(ctx -> {
						try {
							int bikeId = Integer.parseInt(ctx.pathParam("id")); // numeric format exception
							Person newOwner = ctx.bodyAsClass(Person.class);
							// returns the person with their new bicycle added
							newOwner = userServ.buyBicycle(bikeId, newOwner);
							ctx.json(newOwner);
						} catch (NumberFormatException e) {
							ctx.status(400);
							ctx.result("Bike ID must be a numeric value");
						}
					});
				});
				
				// Listening on http://localhost:8080/
				path("/{id}", () -> {
					
					get(ctx -> {
						try {
							int bikeId = Integer.parseInt(ctx.pathParam("id")); // numeric format exception
							Bicycle bicycle = empServ.getBicycleById(bikeId);
							if (bicycle != null)
								ctx.json(bicycle);
							else
								ctx.status(404);
						} catch (NumberFormatException e) {
							ctx.status(400);
							ctx.result("Bike ID must be a numeric value");
						}
					});
					
					put(ctx -> {
						try {
							int bikeId = Integer.parseInt(ctx.pathParam("id")); // numeric format exception
							Bicycle bikeToEdit = ctx.bodyAsClass(Bicycle.class);
							if (bikeToEdit != null && bikeToEdit.getId() == bikeId) {
								bikeToEdit = empServ.editBicycle(bikeToEdit);
								if (bikeToEdit != null)
									ctx.json(bikeToEdit);
								else
									ctx.status(404);
							} else {
								// conflict: the id doesn't match the id of the bicycle sent
								ctx.status(HttpCode.CONFLICT);
							}
						} catch (NumberFormatException e) {
							ctx.status(400);
							ctx.result("Bike ID must be a numeric value");
						}
					});
					
				});
			});
		});
	});
	}	
}
