package training.task4.runner;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import training.task4.helper.BuilderHelper;
import training.utilities.HelperUtils;
import training.exceptions.CustomException;

public class TestRunner{


    public static void main(String[] args) {
    	Logger logger = Logger.getGlobal();
		try {
			HelperUtils.formatLogger("4");
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
                StringBuilder builder ;
                String string_1;


                BuilderHelper builderHelper = new BuilderHelper();
                switch (option) {
                    case 1:
                        logger.info("Question 1: Create StringBuilder with no String, print length, add a String, print length and final String");

                        logger.info("Empty Builder length : ");
                        builder = builderHelper.createBuilder();

                        logger.info(""+builderHelper.lengthOfBuilder(builder));
                        logger.info("Enter a String :");
                        String string = scanner.next();
                        builderHelper.appendBuilder(builder,string);
                        logger.info("Length after adding string : "+builderHelper.lengthOfBuilder(builder));

                        logger.info("builder after adding string : "+builder);


                        break;

                    case 2:
                    	logger.info("Question 2: Create StringBuilder with a String, add 4 Strings separated by \"#\", print length and final String");
                    	logger.info("Enter a String :");
                        string_1 = scanner.nextLine();
                        builder = builderHelper.createBuilder(string_1);
                        logger.info("Enter 4 Strings : ");
                        for(int i=0; i<4; i++){
                        	System.out.print("Enter String "+i+ " : ");
                        	builderHelper.appendBuilder(builder,"#");
                        	String stringI = scanner.nextLine();
			builderHelper.appendBuilder(builder,stringI);
                        
                        }
                        logger.info("Length after adding string : "+builderHelper.lengthOfBuilder(builder));

                        logger.info("builder after adding string : "+builder);

                        break;

                    case 3:
                        logger.info("Question 3: Create StringBuilder with two Strings, insert another String between them, print length and final String");
                        logger.info("Enter 2 Strings :");
                        string_1 = scanner.nextLine();
                        builder = builderHelper.createBuilder(string_1);
                        logger.info("Enter a String : ");
                        String string_2 = scanner.nextLine();

                        int position = builderHelper.findNthPlace(builder," ",0);
                        builder = builderHelper.insertBuilder(builder,string_2+" ",position+1);

                        logger.info("Length after adding string : "+builderHelper.lengthOfBuilder(builder));

                        logger.info("builder after adding string : "+builder);

                        break;

                    case 4:
                        logger.info("Question 4: Create StringBuilder with two Strings, delete the first String, print length and final String");
                        logger.info("Enter 2 Strings :");
                        string_1 = scanner.nextLine();
                        builder = builderHelper.createBuilder(string_1);
                        builderHelper.deleteFirst(builder," ");
                        logger.info("Length after deleting first string : "+builderHelper.lengthOfBuilder(builder));

                        logger.info("builder after deleting string : "+builder);

                        break;

                    case 5:
                        logger.info("Question 5: Create StringBuilder with 3 Strings, replace space with \"-\", print length and final String");
                        logger.info("Enter 3 Strings :");
                        string_1 = scanner.nextLine();
                        builder = builderHelper.createBuilder(string_1);
                        builder = builderHelper.builderReplace(builder," ","-");
                        logger.info("Length after replacing : "+builderHelper.lengthOfBuilder(builder));

                        logger.info("builder after replacing : "+builder);
                        break;

                    case 6:
                        logger.info("Question 6: Create StringBuilder with 3 Strings, reverse the string, print length and final String");
                        logger.info("Enter 3 Strings :");
                        string_1 = scanner.nextLine();
                        builder = builderHelper.createBuilder(string_1);
                        builder = builderHelper.reverseBuilder(builder);
                        logger.info("Length after reversing : "+builderHelper.lengthOfBuilder(builder));

                        logger.info("builder after reversing : "+builder);
                        break;

                    case 7:
                        logger.info("Question 7: Create StringBuilder with a String, delete characters from 6 to 8 index, print length and final String");
                        logger.info("Enter a String :");
                        string_1 = scanner.nextLine();
                        builder = builderHelper.createBuilder(string_1);
                        builderHelper.deleteSubstring(builder,6,8);
                        logger.info("Length after deleting : "+builderHelper.lengthOfBuilder(builder));

                        logger.info("builder after deleting : "+builder);
                        break;

                    case 8:
                        logger.info("Question 8: Create StringBuilder with a String, replace characters from 6 to 8 index with \"XYZ\","+
                        " print length and final String");
                        logger.info("Enter a String :");
                        string_1 = scanner.nextLine();
                        builder = builderHelper.createBuilder(string_1);
                        builderHelper.deleteSubstring(builder,6,8);
                        builder = builderHelper.insertBuilder(builder,"XYZ",6);
                        logger.info("Length after deleting : "+builderHelper.lengthOfBuilder(builder));

                        logger.info("builder after deleting : "+builder);
                        break;

                    case 9:
                        logger.info("Question 9: Create StringBuilder with 3 Strings separated by \"#\", print length, find index of first \"#\"");
                        logger.info("Enter 3 Strings :");
                        string_1 = scanner.nextLine();
                        builder = builderHelper.createBuilder(string_1);
                        builder = builderHelper.builderReplace(builder," ","#");
                        logger.info("Output Builder : "+ builder);
                        logger.info("Length of builder : "+builderHelper.lengthOfBuilder(builder));

                        logger.info("Index of first # : "+builderHelper.findNthPlace(builder,"#",0));
                        break;

                    case 10:
                        logger.info("Question 10: Create StringBuilder with 3 Strings separated by \"#\", print length, find index of last \"#\"");
                        logger.info("Enter 3 Strings :");
                        string_1 = scanner.nextLine();
                        builder = builderHelper.createBuilder(string_1);
                        builder = builderHelper.builderReplace(builder," ","#");
                        logger.info("Output Builder : "+ builder);
                        logger.info("Length of builder : "+builderHelper.lengthOfBuilder(builder));

                        logger.info("Index of last # : "+builderHelper.findNthPlace(builder,"#",1));
                        break;
		case 11:
			builder = builderHelper.createBuilder("01ABC122ABC");
			logger.info(""+builderHelper.findNthPlace(builder,"ABC",1));
			break;
		
                    default:
                        logger.info("Invalid choice.");
                        scanner.close();
                }

                logger.info("--------------------------------------------------");
            }


            catch(CustomException e){
                logger.severe(e.getMessage()+"\n");


            }
            catch(Exception e){
               logger.warning("Enter Correct Input : ");
                e.printStackTrace();
                scanner.nextLine();

            }
        }


    }


}