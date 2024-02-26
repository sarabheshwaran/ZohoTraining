package training.task3.runner;


import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

import training.exceptions.CustomException;

import training.utilities.HelperUtils;
import training.task3.helper.StringHelper;


public class TestRunner{
	
	
	
	public static ArrayList<String> takeInput(){
	Scanner scanner = new Scanner(System.in);
		
	ArrayList<String> input = new ArrayList<>();
	while(true) {
    		
    				String line = scanner.nextLine();
    				
    				if(line.equals("")) {
    					break;
    				}else {
    					Collections.addAll(input,line.split(" "));
    				}
    				
    			}
			scanner.close();
    			return input;
	}
	

	public static void main(String [] args){
		

		Logger logger = Logger.getGlobal();
		try {
			HelperUtils.formatLogger("3");
		} catch (SecurityException | IOException | CustomException e) {
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(System.in);
		
		while(true){
		try{
			logger.info("Enter Option :");
			
			int option = scanner.nextInt();
			
			scanner.nextLine();
			
			logger.info("-------------------------------------------------");
			ArrayList<String> input = new ArrayList<>();
			
			
    			
    			StringHelper stringHelper = new StringHelper();
    			switch(option){
    				case(1):
    					logger.info("Q1: Find the Length of a String \n Please enter a String to find its length:\n");
    					
    					input = takeInput();
    					logger.info(""+HelperUtils.lengthOfString(input.get(0))+"\n");
    					break;
    				case(2):
    					logger.info("Q2: Convert String to Character Array");
					logger.info("Please enter a String to convert into a character array:");
					input = takeInput();
    					logger.info(""+stringHelper.toCharacterArray(input.get(0)));
    					break;
    				case(3):
    					logger.info("Q3: Find the Penultimate Character");
					logger.info("Please enter a String to find the character at the last but one place (penultimate):");
					input = takeInput();

    					logger.info(stringHelper.lastButX(input.get(0),2));
    					break;
    				case(4):
    					logger.info("Q4: Count Occurrences of a Character");
					logger.info("Please enter the String and Character : ");
					input = takeInput();
    					logger.info(""+stringHelper.countChar(input.get(0),input.get(1).charAt(0)));
    					
    					break;
    				case(5):
    					logger.info("Q5: Find Greatest Position of a Character");
					logger.info("Please enter the String and Character : ");
					input = takeInput();
					
    					logger.info(""+stringHelper.greatestPosition(input.get(0),input.get(1).charAt(0)));
    					break;
    				case(6):
    					logger.info("Q6: Print the Last 5 Characters");
					logger.info("Please enter a String to print its last 5 characters:");
					input = takeInput();
    					logger.info(stringHelper.specificFirst(input.get(0),5));
    					break;
    				case(7):
    					logger.info("Q7: Print the First 3 Characters");
					logger.info("Please enter a String to print its first 3 characters:");
					input = takeInput();
    					logger.info(stringHelper.specificLast(input.get(0),3));
    					break;
    				case(8):
    					logger.info("Q8: Replace First 3 Characters");
					logger.info("Please enter a String to replace its first 3 characters with \"XYZ\":");
					input = takeInput();
    					logger.info(stringHelper.addSubstringFront(input.get(0),"XYZ"));
    					break;
    				case(9):
    					logger.info("Q9: Check if String Starts with \"ent\"");
					logger.info("Please enter a String to check if it starts with \"ent\":");
					input = takeInput();
    					logger.info(""+stringHelper.prefixFinder(input.get(0),"ent"));
    					break;
    				case(10):
    					logger.info("Q10: Check if String Ends with \"le\"");
					logger.info("Please enter a String to check if it ends with \"le\":");
					input = takeInput();
    					logger.info(""+stringHelper.suffixFinder(input.get(0),"le"));
    					break;
    				
    				case(11):
    					logger.info("Q11: Convert to Uppercase");
					logger.info("Please enter a String to convert to uppercase:");
					input = takeInput();
    					logger.info(stringHelper.upperCase(input.get(0)));
    					break;
    				
    				case(12):
    					logger.info("Q12: Convert to Lowercase");
					logger.info("Please enter a String to convert to lowercase:");
					input = takeInput();
    					logger.info(stringHelper.lowerCase(input.get(0)));
    					break;
    				
    				case(13):
    					logger.info("Q13: Reverse a String");
					logger.info("Please enter a String to reverse:");
					input = takeInput();
    					logger.info(stringHelper.reverseString(input.get(0)));
    					break;
    				
    				case(14):
    					logger.info("Q14: Get multiple String in Single line ");
					logger.info("Please enter a line with multiple Strings :");
					logger.info(scanner.nextLine());
    					break;
    				
    				case(15):
    					logger.info("Q15: Concatenate Strings without Space");
					logger.info("Please enter a line with multiple Strings to concatenate without space:");
					String inputString = scanner.nextLine();
    					logger.info(stringHelper.stringReplace(inputString," ",""));
    					break;
    				case(16):
    					logger.info("Q16: Enclose Strings in an Array");
					logger.info("Please enter a line with multiple Strings to enclose them in a String array:");
					input = takeInput();
    					logger.info(""+stringHelper.stringArray(input.get(0)," "));
    					break;
    				case(17):
    					logger.info("Q17: Merge Strings with \"-\"");
    					logger.info("Enter the Strings :");
    					input = takeInput();
    					logger.info(stringHelper.stringChaining(input,"-"));
    					break;
    				case(18):
    					logger.info("Q18: Check String Equality (Case-sensitive)");
    					input = takeInput();
    					logger.info(""+stringHelper.equalsWithCase(input.get(0),input.get(1)));
    					break;	
    				case(19):
    					logger.info("Q19: Check String Equality (Case-insensitive)");
    					input = takeInput();
    					logger.info(""+stringHelper.equalsWithoutCase(input.get(0),input.get(1)));
    					break;
    				case(20):
    					logger.info("Q20: Remove Spaces at the Beginning or End");
    					input = takeInput();
					logger.info(stringHelper.removePadding(input.get(0)));
					break;
				case(21):
    					logger.info("length of null : "+ HelperUtils.lengthOfString(null));
					break;
  
    				default:
    					logger.info("Enter crct option (1-20) : ");
    					scanner.close();
    				
    			}
    			
    			logger.info("--------------------------------------------------");
    	}
		
		
		catch(CustomException e){
		logger.info(e.getMessage()+"\n"); 
		
		
		}
		catch(Exception e){
		System.out.print("Enter Correct Input : ");
		scanner.nextLine();
		
		}
		}
	
	}

}