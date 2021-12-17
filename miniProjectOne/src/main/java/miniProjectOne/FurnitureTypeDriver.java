package miniProjectOne;

import io.javalin.Javalin;

public class FurnitureTypeDriver {
			static FurnitureType[] furnituretypes;
			static int currentIndex;
			
	public static void main(String[] args) {			
				currentIndex=0;
				furnituretypes = new FurnitureType[10]; // initializing the FurnitureType array
				
				Javalin app = Javalin.create();
				
				app.start();
				
				app.post("/furnituretypes", ctx -> {
					// our information is going to be coming in as "form parameters"
					FurnitureType furnituretype = new FurnitureType();
					furnituretype.TypeOfFurniture = ctx.formParam("typeoffurniture");
					furnituretype.Color = ctx.formParam("color");
					
					furnituretypes[currentIndex] = furnituretype;
					currentIndex++;
					
					String responseText = "";
					
					for (FurnitureType eachFurnitureType : furnituretypes) {
						System.out.println(eachFurnitureType);
						if (eachFurnitureType != null) {
							responseText += eachFurnitureType.Color + " " + eachFurnitureType.TypeOfFurniture +  "<br>";
						}
					}
					
					ctx.html(responseText);
				});
			}
		}

	


