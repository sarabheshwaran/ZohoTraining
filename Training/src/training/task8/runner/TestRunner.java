package training.task8.runner;


import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import training.exceptions.CustomException;
import training.task6.helper.ArrayListHelper;
import training.task7.helper.MapHelper;
import training.task8.helper.FileHelper;
import training.task8.helper.MyCustomClass;
import training.task8.helper.Boy;
import training.task8.helper.Configuration;
import training.task8.helper.DateHelper;
import training.task8.helper.PropHelper;
import training.task8.helper.Rainbow;
import training.task8.helper.ReflectionHelper;
import training.utilities.HelperUtils;

public class TestRunner {
	


	public static void main(String[] args) {
		Logger logger = Logger.getGlobal();
		try {
			HelperUtils.formatLogger("LogRecord-8");
		} catch (SecurityException | IOException | CustomException e) {
			
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			try {
				logger.info("Enter Option : (0 for Exit )");

				int choice = scanner.nextInt();

				scanner.nextLine();

				logger.info("-------------------------------------------------");

				FileHelper fileHelper = new FileHelper();
				ReflectionHelper reflectHelper = new ReflectionHelper();
				ArrayListHelper listHelper = new ArrayListHelper();
				MapHelper mapHelper = new MapHelper();

				switch (choice) {
			    case 1:{
			        logger.info("1. Create a file sample.txt programmatically and write the following lines in that file");
			        logger.info("   Line 1: Programmatically created file.");
			        logger.info("   Line 2: These words were written programmatically.");
			        logger.info("   Line 3: All is Well. Be happy & enjoy the moment.");
			        
			        logger.info("\n");
			        logger.info("Enter the Strings to write to the file :");
			        List<String> list = listHelper.getList();
			        while(true) {
			    		
	    				String line = scanner.nextLine();
	    				
	    				if(line.equals("")) {
	    					break;
	    				}else {
	    					listHelper.add(list, line);
	    					
	    				}
	    				
	    			}
			        
			        fileHelper.fileCreation("hello.txt", "", list);
			        
			        
			        break;
			    }
			    case 2:{
			        logger.info("2. Write a Class to store the values in java.util.Properties (approx 5 Keys vs Values)");
			        logger.info("   object. Keys & Values can be provided from the runner class.");
			        logger.info("   After loading the properties with the provided keys & values, store the values in a text file (myprops.txt)");
			        
			        logger.info("Enter key and value pairs to store in properties (5) ");
			        
			        
			        
					Properties properties = fileHelper.getProp();
					logger.info("Enter key - value Pairs : ");
					for(int i=0; i<5; i++) {
						
						String key = scanner.next();
						String value = scanner.next();
						
						fileHelper.addProperty(properties,key, value);
						
						scanner.nextLine();
						
					}
			        
					fileHelper.writeProp("myProps.txt", "", properties);
			        
			        
			        break;
			    }
			    case 3:{
			        logger.info("3. Write a Class to read the keys & values from the above created myprops.txt file(any file)");
			        logger.info("   & store those values back into the java.util.Properties object and print the properties.");
			        
			        logger.info("Enter the property file to get");
			        
			        
			        Properties properties = fileHelper.getProp();
			        
			        fileHelper.readProp("myProps.txt", "", properties);
			        
			        Set<String> keySet = fileHelper.keySet(properties);
			        
			        logger.info("The Properties are : ");
			        for(String key : keySet) {
			        	
			        	logger.info(key +" : "+ fileHelper.getProperty(properties,key));
			        }
			        break;
			    }
			    case 4:{
			        logger.info("4. Repeat tasks 1, 2, 3 by creating the files sample.txt, myprops.txt under");
			        logger.info("   /home/INC*/myDir. Please note that you should create the myDir directory programmatically.");
			        
			        List<String> list = listHelper.getList();
			        while(true) {
			    		
	    				String line = scanner.nextLine();
	    				
	    				if(line.equals("")) {
	    					break;
	    				}else {
	    					listHelper.add(list, line);
	    					
	    				}
	    				
	    			}
			        
			        fileHelper.fileCreation("hello.txt", "jjj/", list);
			        
			        
			        
			        break;
			    }
			    case 5:{
			        logger.info("5. Write a class with an additional constructor which accepts a 'String'.");
			        logger.info("   Assign that String to an instance variable.");
			        logger.info("   Invoke this constructor from a separate runner class & print your object.");
			        logger.info("   This printing should print the object alone but the String variable should get printed automatically.");
			        
			        logger.info("Enter input to store in the class instance string :");
			        String input = scanner.nextLine();
			        
			        MyCustomClass customClass = new MyCustomClass(input);
			        
			        logger.info("Printing the class :-");
			        logger.info(customClass.toString());
			        
			        break;
			    }

			    case 6:{
			        logger.info("6. Write a POJO class with a String variable, integer variable.");
			        logger.info("   Have the necessary getter & setter methods for these variables with proper access specifiers & return types.");
			        logger.info("   Now define a constructor which accepts all these variables as an argument & set the");
			        logger.info("   incoming values to the appropriate variables.");
			        logger.info("   Now from a separate runner class, you should try to create an instance for your class");
			        logger.info("   using the above said constructor & print your object.");
			        logger.info("   You have to print the object alone in the Runner but it should print those");
			        logger.info("   String & Integer variables automatically.");
			        
			        Boy boy = new Boy("java",11);
			        
			        logger.info("Printing POJO class : ");
			        logger.info(boy.toString());
			        
			        break;
			    }
			    case 7:{
			        logger.info("7. Now from a separate runner class, you should try to create an instance for the above");
			        logger.info("   POJO class using the default constructor. Using that, call the appropriate setter");
			        logger.info("   methods to set the values for the String, integer.");
			        logger.info("   After that invoke the appropriate getter methods & print each value that is set previously.");
			        
			        Boy boy = new Boy();
			        
			        boy.setName("Java");
			        boy.setAge(11);
			        
			        logger.info("Printing getters and setters  : ");
			        logger.info("String : "+ boy.getName());
			        logger.info("Integer : "+ boy.getAge());
			        
			        break;
			    }
			    case 8:{
			        logger.info("8. Write a POJO class with a default constructor & an overloaded constructor (String & Integer args).");
			        logger.info("   It has a String variable & Integer variable, with proper getter & setter methods for");
			        logger.info("   these variables. Compile the class.");
			        logger.info("   Write a runner class with a different package than the POJO class.");
			        logger.info("   Invoke the default constructor of the POJO from the runner class");
			        logger.info("   Invoke the overloaded constructor of the POJO from the runner class");
			        logger.info("   Invoke any one getter method of the POJO from the runner class");
			        logger.info("   Invoke any one setter method of the POJO from the runner class");
			        
			        Class<?> Boy = reflectHelper.getClass("training.task8.helper.Boy");
			        
			        Constructor<?> defaultConst = Boy.getConstructor();
			        Object reference = reflectHelper.getInstance(defaultConst);
			        logger.info("Invoking default constructor : "+ reference);
			        
			        
			        Constructor<?> overloadedConst = Boy.getConstructor(String.class,int.class);
			        reference = reflectHelper.getInstance(overloadedConst,"xxxx",11);
			        logger.info("Invoking loaded constructor : "+ reference);
			        
			        
			        
			        Method setMethod = Boy.getMethod("setName", String.class);
			        setMethod.invoke(reference,"Java");
			        logger.info("Object after invoking setMethod : "+ reference);
			        
			        
			        
			        Method getMethod = Boy.getMethod("getName");
			        logger.info("Invoking getMethod : "+ getMethod.invoke(reference));
			        
			        
			        
			        
			        
			        
			        
			        
//			        logger.info(reference);types
//			        logger.info("Get method : "+ reflectHelper.invokeMethod(getMethod,reference));
//			      
			        break;
			    }
			    case 9:
			        logger.info("9. Define an Enum for the rainbow colors, with values(colorcode) ranging from 1 to 7.");
			        logger.info("   Print the color and its corresponding color code from the main method.");
			        logger.info("   For example: Color code of Violet is 1, Color code of Indigo is 2, etc.");
			        logger.info("   Invoke values() ordinal methods of the enum as well.");
			        
			        
			        for(Rainbow color : Rainbow.values()) {
			        	
			        	
			        	logger.info(color+" : "+color.getCode());
			        	
			        }
			        
			        
			        break;

			    case 10:{
			        logger.info("10. Write a Singleton class, so that there exists only one instance of the class in a JVM.");
			        logger.info("    Also read about how the Singleton pattern evolved in Java & what will be the best");
			        logger.info("    way to write a Singleton class.");
			        
			        
			        Configuration configAtSetting = Configuration.getConfiguration();
				     
			        
			        configAtSetting.printConfiguration();
			        
			        
			        break;
			    }
			    case 11:{
			        logger.info("11. Write a class & add methods to do the following. Refer: java.time package");
			        logger.info("    1. Return the currentTime with Date, seconds, etc");
			        logger.info("    2. Return the currentTime in milliseconds. Using System class as well.");
			        logger.info("    3. Return the currentTime with Date, seconds in New York & London. Observer");
			        logger.info("       the difference.");
			        logger.info("    4. Return the week day for the currentTime in millis or any given time in millis");
			        logger.info("    5. Return the month(not numeric) of the currentTime in millis or any given time");
			        logger.info("       in millis");
			        logger.info("    6. Return the Year of the currentTime in millis or any given time in millis");
			        
			        
			        
			        DateHelper dateHelper = new DateHelper();
			        
			        Long currentMillis = System.currentTimeMillis();
			        ZonedDateTime todayHere = dateHelper.getDateTime();
			        
			        logger.info("Current time using LocalDateTime : "+dateHelper.formatted(todayHere));
			        
			        logger.info("Current time in milliseconds : "+ currentMillis);
			        
			        ArrayList<String> timeZones = (ArrayList<String>) dateHelper.getZoneIds();
			        
			        
			        int size = timeZones.size();
			        for(int i=0; i<size; i++) {
			        	
			        	logger.info(i+" : "+ timeZones.get(i));
			        	
			  
			        }
			        logger.info("Enter the timezone index : ");
			        
			        int zone = scanner.nextInt();
			        scanner.nextLine();
			        
			        ZonedDateTime relativeZone =  dateHelper.getDateTime(timeZones.get(zone));
			       
			        
			        logger.info("Time in London : "+ dateHelper.formatted(relativeZone) );
			        
			        
			        ZonedDateTime dateFromMillis = dateHelper.dateTimeFromMillis(currentMillis);
			        
			        logger.info("Day of week : "+ DayOfWeek.from(dateFromMillis));
			        logger.info("Month of Year : "+ Month.from(dateFromMillis));
			        logger.info("Year : "+ Year.from(dateFromMillis));
			        break;
			    }
			    case 12:{
			        logger.info("12. Logger:");
			        logger.info("    1. Replace all your logger.info() in your previous tasks with appropriate");
			        logger.info("       Logger.log method. Make sure to do this in your future tasks as well.");
			        logger.info("    2. Replace all your exp.getMessage() & exp.printStackTrace() with appropriate");
			        logger.info("       Logger.log method. Make sure to do this in your future tasks as well.");
			        break;
			        
			        
			        
			    }
			    case 0: {
					loop = false;
					scanner.close();

					break;
				}
				default: {
					logger.warning("Invalid case number.");

					break;
				}
				}

				logger.info("--------------------------------------------------");
			}

			catch (CustomException e) {
				logger.severe(e.getMessage() + "\n");
				e.getStackTrace();

			} catch (Exception e) {
				e.printStackTrace();
				scanner.nextLine();

			}
		}

	}




}

