package training.task10.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import training.exceptions.CustomException;
import training.task10.helper.RegexHelper;
import training.task6.helper.ArrayListHelper;
import training.utilities.HelperUtils;

public class TestRunner {
	public static void main(String[] args) {
		Logger logger = Logger.getGlobal();
		try {
			HelperUtils.formatLogger("7");
		} catch (SecurityException | IOException | CustomException e) {
			e.printStackTrace();
		}


		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			try {
				logger.info("Enter Option : (0 for Exit )");

				int choice = scanner.nextInt();

				RegexHelper regHelper = new RegexHelper();
				scanner.nextLine();

				logger.info("-------------------------------------------------");

				switch (choice) {
				case 1:{
					
					logger.info("Phone Number validation : ");
					logger.info("Enter Phone number : " );
					String PhoneNo = scanner.nextLine();
					
					boolean ans = regHelper.validatePhoneNo(PhoneNo);
					if(ans) {
					logger.info("Valid phoneNo !");}
					else {

						logger.info("Invalid phoneNo !");
					}
					break;
					
				}
				case 2:{
					
					logger.info("AlphaNumeric validation : ");
					logger.info("Enter string : " );
					String input = scanner.nextLine();
					
					boolean ans = regHelper.isAlphaNumeric(input);
					
					if(ans) {
					logger.info("Valid !");}
					else {

						logger.info("Invalid !");
					}
					break;
					
				}
				case 3:{
					
					logger.info("Starts with && Ends with && contains : ");
					logger.info("Enter string : " );
					String input = scanner.nextLine();

					logger.info("Enter regex : " );
					String regex = scanner.nextLine();
					
					
					boolean result1 = regHelper.startsWith(input, regex);
					boolean result2 = regHelper.endsWith(input, regex);
					boolean result3 = regHelper.contains(input, regex);
					
					if (result1) {
						logger.info("The given string starts with the given regex ");
						
					}else {
						logger.info("The given string does not starts with the given regex ");
						
					}				
					
					if (result2) {
						logger.info("The given string ends with the given regex ");
						
					}else {
						logger.info("The given string does not ends with the given regex ");
						
					}				
					
					if (result3) {
						logger.info("The given string contains the given regex ");
						
					}else {
						logger.info("The given string does not contains the given regex ");
						
					}
					
					break;
					
				}
				case 4:{
					
					logger.info("Case insensitive comparing : ");
					logger.info("Enter No of strings : ");
					boolean ans = true;
					int count  = scanner.nextInt();
					scanner.nextLine();
					
					ArrayListHelper listHelper = new ArrayListHelper();
					
					List<String> strList = listHelper.getList();
					
					for(int i=0; i<count; i++) {
						
						logger.info("Enter String "+i+" : ");
						String input = scanner.nextLine();
						strList.add(input);
						
					}

					logger.info("Enter regex : " );
					String regex = scanner.nextLine();
					
					for(String i : strList) {
						
						ans = regHelper.caseInsensitiveCompare(i, regex);
						if (!ans) {
							break;
						}
						
					}
					
					
					if(ans) {
					logger.info("All Strings are Valid !");}
					else {

						logger.info("Invalid !");
					}
					break;
					
				}
				case 5:{
					
					logger.info("Email Validation :");
					logger.info("Enter Email");
					
					String email = scanner.nextLine();
					
					boolean ans = regHelper.validateEmail(email);
					if(ans) {
						logger.info("Valid !");}
						else {

							logger.info("Invalid !");
						}
					break;
					
				}
				case 6:{
					
					logger.info("Checking Length : ");
					logger.info("Enter No of strings : ");
					boolean ans = true;
					int count  = scanner.nextInt();
					scanner.nextLine();
					
					ArrayListHelper listHelper = new ArrayListHelper();
					
					List<String> strList = listHelper.getList();
					
					for(int i=0; i<count; i++) {
						
						logger.info("Enter String "+i+" : ");
						String input = scanner.nextLine();
						strList.add(input);
						
					}

					
					for(String i : strList) {
						
						ans = regHelper.checkLength(i,2,6);
						if (!ans) {
							break;
						}
						
					}
					
					
					if(ans) {
					logger.info("All Strings are Valid !");}
					else {

						logger.info("Invalid !");
					}
					break;
					
				}
				
				case 7:{
					
					logger.info("Regex Mapping : ");
					logger.info("Enter No of strings : ");
					int count  = scanner.nextInt();
					scanner.nextLine();
					
					ArrayListHelper listHelper = new ArrayListHelper();
					
					List<String> strList = listHelper.getList();
					
					for(int i=0; i<count; i++) {
						
						logger.info("Enter String "+i+" : ");
						String input = scanner.nextLine();
						strList.add(input);
						
					}
					logger.info("Enter No of Matching strings : ");
					count  = scanner.nextInt();
					scanner.nextLine();
					
					
					List<String> regList = listHelper.getList();
					
					for(int i=0; i<count; i++) {
						
						logger.info("Enter Matching String "+i+" : ");
						String input = scanner.nextLine();
						regList.add(input);
						
					}
					
					System.out.println(regHelper.regexMapping(strList, regList));
					break;
				}
				
				case 8 :{
					
					logger.info("Take html tags out of a string");
					
					logger.info("Enter the string : ");
					
					String input = scanner.nextLine();
					
					logger.info(""+regHelper.getAllMatchers(input, "<[^>]*>"));
				
					break;
				}
				
				case 0: {
					
					ArrayList<String> regList = new ArrayList<String>();
					
					regList.add("a bc");
					regList.add("g ,fd");
					regList.add("d|dd");
					
					ArrayList<String> stringList = new ArrayList<String>();
					
					stringList.add("a bc");
					stringList.add("d|dd");
					stringList.add("Sadsf");
					stringList.add("g ,fd");
					
					
					
					Map<Integer, String> map = regHelper.regexMapping(regList, stringList);

					
					logger.info(map.toString());

					break;
				}

				default: {
					logger.info("Invalid case number.");
					scanner.close();
					break;
				}
				}

				logger.info("--------------------------------------------------");
			}

			catch (Exception e) {
				logger.warning("Enter Correct Input : ");
				e.printStackTrace();
				scanner.nextLine();

			}
		}

	}

	
}
