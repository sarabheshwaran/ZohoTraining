package training.task5.runner;

import training.utilities.HelperUtils;
import java.util.Scanner;
import java.util.logging.Logger;

import training.exceptions.CustomException;

import java.io.IOException;
import java.util.InputMismatchException;

import training.task5.objects.carobjects.Car;
import training.task5.objects.carobjects.SCross;
import training.task5.objects.carobjects.XUV;
import training.task5.objects.carobjects.Swift;

import training.task5.objects.birdobjects.Duck;
import training.task5.objects.birdobjects.ParrotMod;



public class TestRunner{
    
    public static void processSwift(Swift swift) throws CustomException {
    	
    	Logger logger = Logger.getGlobal();
		try {
			HelperUtils.formatLogger("5");
		} catch (SecurityException | IOException | CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	HelperUtils.nullCheck(swift);
    
    	logger.info("Swift function...");

        logger.info("Model: " + swift.getModel());
        logger.info("Color: " + swift.getColor());

        logger.info("\n");
    }
    
    
    public static void processCar(Car car) throws CustomException {
    	
    	Logger logger = Logger.getGlobal();
		try {
			HelperUtils.formatLogger("5");
		} catch (SecurityException | IOException | CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
      logger.info("Car function...");

	HelperUtils.nullCheck(car);
       
        if (car instanceof Swift) {
        	logger.info("Hatch");
        } else if (car instanceof XUV) {
        	logger.info("SUV");
        } else if (car instanceof SCross) {
        	logger.info("Sedan");
        } else {
        	logger.info("Unidentified Car");
        }


        logger.info("\n");
    }
    

    public static void main(String[] args) {
    	Logger logger = Logger.getGlobal();
		try {
			HelperUtils.formatLogger("5");
		} catch (SecurityException | IOException | CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                logger.info("Enter Option :");

                int option = scanner.nextInt();

                scanner.nextLine();

                logger.info("-------------------------------------------------");
                
		//Car Object references ...
		Car car;
		SCross sCross;
		XUV xuv;
		Swift swift;
                
		//Bird Object references...
		ParrotMod parrot;
		Duck duck;


                switch (option) {
                    case 2:
                        logger.info("2. From the runner class create an instance for Swift. Using that, call all the setter methods"+
                        " & then all the getter methods in Swift class alone. Print the values returned from the getter methods");
                        
                        swift = new Swift();

                        System.out.print("Enter year of make: ");
                        swift.setYearOfMake(scanner.nextInt());

                        scanner.nextLine();

                        System.out.print("Enter number of seats: ");
                        swift.setSeats(scanner.nextInt());

                        System.out.print("Enter number of airbags: ");
                        swift.setAirbags(scanner.nextInt());

                        scanner.nextLine();

                        System.out.print("Enter model: ");
                        swift.setModel(scanner.nextLine());

                        System.out.print("Enter color: ");
                        swift.setColor(scanner.nextLine());

                        logger.info("Swift instance after setting values:");
                        
                        logger.info("Seats: " + swift.getSeats());
                        logger.info("Airbags: " + swift.getAirbags());
                        logger.info("Model: " + swift.getModel());
                        logger.info("Color: " + swift.getColor());


                        break;

                    case 3:
                        logger.info("3. From the runner class create an instance for SCross. Using that, call all the setter methods"+
                        " & then all the getter methods in SCross including superclass methods. Print the values returned from the getter methods");
                        
                        sCross = new SCross();

                        System.out.print("Enter year of make: ");
                        sCross.setYearOfMake(scanner.nextInt());

                        scanner.nextLine();

                        System.out.print("Enter engine number: ");
                        sCross.setEngineNumber(scanner.nextLine());

                        System.out.print("Enter type: ");
                        sCross.setType(scanner.nextLine());

                        System.out.print("Enter number of seats: ");
                        sCross.setSeats(scanner.nextInt());

                        System.out.print("Enter number of airbags: ");
                        sCross.setAirbags(scanner.nextInt());
                        scanner.nextLine();
                        
                        System.out.print("Enter Model : ");
                        sCross.setModel(scanner.nextLine());
                        
                        System.out.print("Enter Color : ");
                        sCross.setColor(scanner.nextLine());

                      

                        logger.info("SCross instance after setting values:");

                        logger.info("Year of Make: " + sCross.getYearOfMake());
                        logger.info("Engine Number: " + sCross.getEngineNumber());
                        logger.info("Type: " + sCross.getType());

                        logger.info("Seats: " + sCross.getSeats());
                        logger.info("Airbags: " + sCross.getAirbags());
                        logger.info("Model: " + sCross.getModel());
                        logger.info("Color: " + sCross.getColor());
                        break;

                    case 4:
			logger.info("4. In the runner class create a method which accepts a Car object as an argument."+
			" Try to invoke that method with objects of XUV, SCross & Swift. For example, Swift obj = new Swift()");

                       
                       
                        xuv = new XUV();
                        sCross = new SCross();
                        swift = new Swift();

                        processCar(xuv);
                        processCar(sCross);
                        processCar(swift);
                        
                        
                        break;

                    case 5:
			logger.info("5. In the method created above, identify the actual underlying object of the incoming Car object."+
			" If the incoming object is Swift print “Hatch'', if XUV print SUV & if SCross print Sedan.");

		
                        xuv = new XUV();
                        sCross = new SCross();
                        swift = new Swift();

                        processCar(xuv);
                        processCar(sCross);
                        processCar(swift);

                        break;

                    case 6:
			logger.info("6. In the runner class create another method which accepts a Swift object as an argument.\n" +
			"  1. Try to invoke that method with a Swift object i.e Swift obj = new Swift()\n" +
			"  2. Try to invoke that method with a Car object which is assigned a Swift Object. i.e Car obj = new Swift(); \n"+
			"Understand how different this scenario is from (i).\n" +
			"  3. Try to invoke that method with objects of XUV, SCross & understand how different this scenario is from the 4th task.");

                        swift = new Swift();
                        logger.info("Using Swift object : ");
                        processSwift(swift);

                        car = new Swift();
                        logger.info("Using Car object : ");
                        processSwift((Swift)car);

                       // xuv = new XUV();
                       // logger.info("Using XUV object : ");
                       // processSwift(xuv);
                        
                       // sCross = new SCross();
                       // logger.info("Using SCross object : ");
                       // processSwift(sCross);
                        break;

                    case 7:
			logger.info("7. In the Car class create a method maintenance (). Inside that print \" Car under maintenance\" . "+
			"Now override this method in SCross class & print “Maruti SCross under maintenance” .\n" +
			"  1. Create an instance for Scross object & call maintenance() method\n" +
			"  2. Create an instance for SCross object & assign it to Car variable(Car obj = new SCross();) & call maintenance() method\n" +
			"  3. Create an instance for Car object & call maintenance() method\n" +
			"  4. Create an instance for Swift object & call maintenance() method.");
                                
                        sCross = new SCross();
                        sCross.maintenance();

                        car = new SCross();
                        car.maintenance();

                        car = new Car();
                        car.maintenance();

                        swift = new Swift();
                        swift.maintenance();

                        break;

                    case 8:
			logger.info("8. In the Car class create an overloaded constructor which accepts a String & print the incoming String. "+
			"In the XUV class’s default constructor, try to call the overloaded Constructor of the super class."+
			" You should not create the overloaded constructor in XUV class. Now from the runner class,\n" +
			"  1. Try to create an instance of XUV using default constructor\n" +
			"  2. Try to create an instance of XUV using the overloaded constructor");

                                
                        xuv = new XUV();

                        //XUV xuvOverloaded = new XUV("Additional info for XUV");

                        break;

                    case 9:
			logger.info("9. Create an abstract class BirdAbstract with two methods: fly() & speak()."+
			" Both the fly() & speak() can print a statement & these methods need not be abstract."+
			" From a runner class try to create an instance for the BirdAbstract class.\n" +
			"  1. Now compile the runner class & check the output & understand.\n" +
			"  2. Now create a subclass ParrotMod extending BirdAbstract & you need not override the methods fly & speak."+
			" Create an instance for the ParrotMod from the runner class & invoke the fly & speak methods.");

                        //BirdAbstrat birdAbstract = new BirdAbstract();
                        parrot = new ParrotMod();
                        parrot.fly();
                        parrot.speak();
                        break;

                    case 10:
                        logger.info("10. Create a class Bird with two methods: fly() & speak(). Let the fly() method alone be abstract."+
                        " Now create a subclass Duck extending Bird & provide implementation for the fly."+
                        " Create an instance for the Duck from the runner class & invoke the fly & speak methods.");
                        
                        duck = new Duck();
                        duck.fly();
                        duck.speak();
                        break;


                    default:
                        logger.info("Invalid choice.");
                        scanner.close();
                        break;
                }

                logger.info("--------------------------------------------------");
            }


            catch(CustomException e){
                logger.severe(e.getMessage()+"\n");


            }
            catch(InputMismatchException e){
                logger.warning("\nEnter Correct Input ! ");
                scanner.nextLine();

            }
        }


    }

}