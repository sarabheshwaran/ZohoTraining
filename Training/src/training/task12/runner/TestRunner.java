package training.task12.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import org.json.*;

import training.exceptions.CustomException;
import training.task11.helper.Dependant;
import training.task11.helper.Employee;
import training.task12.helper.JSONHelper;
import training.utilities.HelperUtils;

public class TestRunner {

	public static void main(String[] args) {
		Logger logger = Logger.getGlobal();
		try {
			HelperUtils.formatLogger("4");
		} catch (SecurityException | IOException | CustomException e) {
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				logger.info("Enter Option :");

				int option = scanner.nextInt();

				scanner.nextLine();

				logger.info("-------------------------------------------------");

				JSONHelper serialHelper = new JSONHelper();
				
				
				switch (option) {
				case 1: {

					JSONObject object = new JSONObject("{\n"
							+ "  \"name\": \"John Doe\",\n"
							+ "  \"age\": 30,\n"
							+ "  \"city\": \"New York\",\n"
							+ "  \"isStudent\": false,\n"
							+ "  \"grades\": [85, 90, 78],\n"
							+ "  \"address\": {\n"
							+ "    \"street\": \"123 Main St\",\n"
							+ "    \"zipCode\": \"10001\"\n"
							+ "  }\n"
							+ "}\n"
							+ "");
//					
//					object.put("Name", "Deadpool");
//					object.put("Name", new JSONObject());
//					object.put("Null",JSONObject.NULL);
					
//					object.put("Damage",);
//					Employee e= new Employee();
					
//					System.out.println(object.get("Name"));
					
					JSONArray array = new JSONArray();
					
//					array.put(e);
					array.put("Hel\nlo");
					array.put(true);
					array.put(JSONObject.NULL);
//					System.out.println(array);

					object.put("Array", array);
					
					
					System.out.println(object);
					break;

				}
				case 2:{
					
	
				}


				default: {
					logger.info("Invalid choice.");
					scanner.close();
					break;
				}
				}

				logger.info("--------------------------------------------------");
			}

//			catch (CustomException e) {
//				logger.severe(e.getMessage() + "\n" );
//				e.getCause().printStackTrace();
//			} 
		catch (Exception e) {
				logger.warning("Enter Correct Input : ");
				e.printStackTrace();
				scanner.nextLine();

			}
		}

	}
	
}

