package training.task6.runner;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

import training.task5.objects.carobjects.Car;
import training.task6.helper.*;
import training.utilities.HelperUtils;
import training.exceptions.*;

public class TestRunner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Logger logger = Logger.getGlobal();
		try {
			HelperUtils.formatLogger("6");
		} catch (SecurityException | IOException | CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			try {
				logger.info("Enter Option :");

				int choice = scanner.nextInt();

				scanner.nextLine();

				logger.info("-------------------------------------------------");

				List<Object> arrList;
				List<String> stringList1, stringList2, stringList3;
				List<Double> decimalList;
				List<Long> longList;
				List<Integer> intList1 ;

				Iterator<String> iterator;

				ArrayListHelper listHelper = new ArrayListHelper();
				switch (choice) {
				case 1:
					logger.info("1. Write a program to create an ArrayList & print the size of it");
					arrList = listHelper.getList();

					logger.info(""+listHelper.listLength(arrList));

					break;
				case 2:
					logger.info(
							"2. Write a program to create an ArrayList & add 5 Strings from the command line to it. "
									+ "Print the ArrayList & the size of it");

					stringList1 = listHelper.getList();

					logger.info("Enter 5 Strings :");

					for (int i = 0; i < 5; i++) {
						String input = scanner.nextLine();
						listHelper.add(stringList1, input);

					}

					logger.info("ArrayList : " + stringList1);
					logger.info("Length of ArrayList : " + listHelper.listLength(stringList1));

					break;
				case 3:
					logger.info(
							"3. Write a program to create an ArrayList & add 5 integers from the command line to it. "
									+ "Print the ArrayList & the size of it");

					intList1 = listHelper.getList();

					logger.info("Enter 5 Integers :");
					for (int i = 0; i < 5; i++) {
						int input = scanner.nextInt();
						listHelper.add(intList1, input);

					}
					scanner.nextLine();
					logger.info("ArrayList : " + intList1);
					logger.info("Length of ArrayList : " + listHelper.listLength(intList1));

					break;
				case 4:
					logger.info("4. Write a program to create an ArrayList & add your custom objects to it. "
							+ "Print the ArrayList & the size of it");

					arrList = listHelper.getList();

					Car car1 = new Car();
					Car car2 = new Car();
					Car car3 = new Car();

					listHelper.add(arrList, car1, 0);
					listHelper.add(arrList, car2, 0);
					listHelper.add(arrList, car3, 0);

					logger.info("ArrayList : " + arrList);

					logger.info("Length of ArrayList : " + listHelper.listLength(arrList));

					break;
				case 5:
					logger.info("5. Write a program to create an ArrayList & add 2 integers, add 3 Strings from "
							+ "command line & 2 custom objects. Print the ArrayList & the size of it");

					arrList = listHelper.getList();

					logger.info("Enter 2 integers :");
					for (int i = 0; i < 2; i++) {
						int integer = scanner.nextInt();
						listHelper.add(arrList, integer);
					}
					scanner.nextLine();

					logger.info("Enter 3 Strings :");
					for (int i = 0; i < 3; i++) {
						String string = scanner.nextLine();
						listHelper.add(arrList, string);
					}

					car1 = new Car();
					car2 = new Car();

					listHelper.add(arrList, car1, 0);
					listHelper.add(arrList, car2, 0);

					logger.info("ArrayList : " + arrList);

					logger.info("Length of ArrayList : " + listHelper.listLength(arrList));

					break;

				case 6:
					logger.info(
							"6. Write a program to create an ArrayList & add 4 Strings from the command line to it. "
									+ "Then find the index of any one of the already added String. Print the ArrayList & the "
									+ "size of it as well");

					stringList1 = listHelper.getList();

					logger.info("Enter 4 Strings :");
					for (int i = 0; i < 4; i++) {
						String string = scanner.nextLine();
						listHelper.add(stringList1, string);
					}
					logger.info("Enter the string to find the index : ");
					String getString = scanner.nextLine();

					logger.info("Index of the given String is :" + listHelper.indexOf(stringList1, getString));

					logger.info("ArrayList : " + stringList1);
					logger.info("Length of ArrayList : " + listHelper.listLength(stringList1));

					break;
				case 7:
					logger.info(
							"7. Write a program to create an ArrayList & add 5 Strings from the command line to it. "
									+ "Use the iterator method & for loop to print each element in the ArrayList");

					stringList1 = listHelper.getList();

					logger.info("Enter 5 Strings :");
					for (int i = 0; i < 5; i++) {
						String string = scanner.nextLine();
						listHelper.add(stringList1, string);
					}

					iterator = listHelper.getItr(stringList1);

					logger.info("The Elements are : ");
					while (iterator.hasNext()) {

						logger.info(iterator.next());

					}

					break;
				case 8:
					logger.info(
							"8. Write a program to create an ArrayList & add Strings from the command line to it. "
									+ "Print the String at a given index in the ArrayList & the size of it");
					stringList1 = listHelper.getList();

					logger.info("Enter Number of Strings : ");
					int count = scanner.nextInt();
					scanner.nextLine();

					logger.info("Enter " + count + "  Strings :");
					for (int i = 0; i < count; i++) {
						String string = scanner.nextLine();
						listHelper.add(stringList1, string);
					}

					logger.info("Give the index : ");
					int index = scanner.nextInt();
					scanner.nextLine();

					logger.info(listHelper.getElement(stringList1, index));
					logger.info("ArrayList : " + stringList1);
					logger.info("Length of ArrayList : " + listHelper.listLength(stringList1));

					break;
				case 9:
					logger.info(
							"9. Write a program to create an ArrayList & add 5 Strings(with duplicates) from the "
									+ "command line to it. Find the first & last position(index) of a duplicate string.");

					stringList1 = listHelper.getList();

					logger.info("Enter 5 Strings :");
					for (int i = 0; i < 5; i++) {
						String string = scanner.nextLine();
						listHelper.add(stringList1, string);
					}
					logger.info("Enter the string to find the index : ");
					getString = scanner.nextLine();

					logger.info(
							"First Index of the given String is :" + listHelper.indexOf(stringList1, getString));
					logger.info(
							"Last Index of the given String is :" + listHelper.lastIndexOf(stringList1, getString));

					break;

				case 10:
					logger.info(
							"10. Write a program to create an ArrayList & add 5 Strings from the command line to it. "
									+ "After that add a given String at the 2nd position of the ArrayList. Print the ArrayList & "
									+ "the size of it as well");

					stringList1 = listHelper.getList();

					logger.info("Enter 5 Strings :");
					for (int i = 0; i < 5; i++) {
						String string = scanner.nextLine();
						listHelper.add(stringList1, string);
					}

					logger.info("Enter the string to add : ");
					getString = scanner.nextLine();

					listHelper.add(stringList1, getString, 1);

					logger.info("ArrayList : " + stringList1);
					logger.info("Length of ArrayList : " + listHelper.listLength(stringList1));

					break;
				case 11:
					logger.info(
							"11. Write a program to create an ArrayList(first ArrayList) & add 10 Strings from the "
									+ "command line to it. Using that ArrayList create a new ArrayList(second ArrayList) with "
									+ "elements from 3 to 8 positions of the first ArrayList");

					stringList1 = listHelper.getList();

					logger.info("Enter 10 Strings :");
					for (int i = 0; i < 10; i++) {
						String string = scanner.nextLine();
						listHelper.add(stringList1, string);
					}

					stringList2 = listHelper.getList(listHelper.subList(stringList1, 2, 8));

					logger.info("The second array list is : " + stringList2);

					break;
				case 12:
					logger.info(
							"12. Write a program to create an ArrayList(first ArrayList) & add 3 Strings from the "
									+ "command line to it. Create another ArrayList(second ArrayList) with 5 more Strings from "
									+ "the Command line. Now create another ArrayList (third ArrayList) using the above two "
									+ "ArrayLists. Print the third ArrayList & size of it. Note: You should not use a loop to "
									+ "create a 3rd ArrayList");

					stringList1 = listHelper.getList();
					stringList2 = listHelper.getList();

					logger.info("Enter 5 Strings :");
					for (int i = 0; i < 5; i++) {
						String string = scanner.nextLine();
						listHelper.add(stringList1, string);
					}

					logger.info("Enter 3 Strings :");
					for (int i = 0; i < 3; i++) {
						String string = scanner.nextLine();
						listHelper.add(stringList2, string);
					}

					stringList3 = listHelper.getList();
					listHelper.addAll(stringList3, stringList1);
					listHelper.addAll(stringList3, stringList2);

					logger.info("ArrayList : " + stringList3);
					logger.info("Length of ArrayList : " + listHelper.listLength(stringList3));

					break;
				case 13:
					logger.info(
							"13. Write a program to create an ArrayList(first ArrayList) & add 5 Strings from the "
									+ "command line to it. Create another ArrayList(second ArrayList) with 3 more Strings from "
									+ "the Command line. Now create another ArrayList (third ArrayList) using the above two "
									+ "ArrayLists. But all the elements of secondArrayList should be ahead of the first ArrayList "
									+ "elements. Print the third ArrayList & size of it. Note: You should not use a loop to create "
									+ "a 3rd ArrayList");

					stringList1 = listHelper.getList();
					stringList2 = listHelper.getList();

					logger.info("Enter 5 Strings :");
					for (int i = 0; i < 5; i++) {
						String string = scanner.nextLine();
						listHelper.add(stringList1, string);
					}

					logger.info("Enter 3 Strings :");
					for (int i = 0; i < 3; i++) {
						String string = scanner.nextLine();
						listHelper.add(stringList2, string);
					}

					stringList3 = listHelper.getList();
					listHelper.addAll(stringList3, stringList2);
					listHelper.addAll(stringList3, stringList1);

					logger.info("ArrayList : " + stringList3);
					logger.info("Length of ArrayList : " + listHelper.listLength(stringList3));

					break;
				case 14:
					logger.info(
							"14. Write a program to create an ArrayList & add 5 decimal values from the command "
									+ "line to it. Remove a decimal value at position 4 from the ArrayList. Print the ArrayList & "
									+ "the size of it as well");

					decimalList = listHelper.getList();

					logger.info("Enter 5 decimal numbers :");
					for (int i = 0; i < 5; i++) {
						Double number = scanner.nextDouble();
						listHelper.add(decimalList, number);
					}
					scanner.nextLine();

					logger.info(
							"Element at position 4 : \"" + listHelper.getElement(decimalList, 3) + "\"is removed !");
					listHelper.remove(decimalList, 3);
					logger.info("ArrayList : " + decimalList);
					logger.info("Length of ArrayList : " + listHelper.listLength(decimalList));

					break;
				case 15:
					logger.info(
							"15. Write a program to create an ArrayList(first ArrayList) & add 5 Strings from the "
									+ "command line to it. Create another ArrayList(second ArrayList) with the same 3 Strings in "
									+ "the previous 5 Strings. Now remove the elements from the first ArrayList which are present "
									+ "in the second ArrayList. Note: You should not use a loop to remove the elements. Print the "
									+ "ArrayList & the size of it as well");

					stringList1 = listHelper.getList();
					stringList2 = listHelper.getList();

					logger.info("Enter 5 Strings :");
					for (int i = 0; i < 5; i++) {
						String string = scanner.nextLine();
						listHelper.add(stringList1, string);
					}

					logger.info("Enter 3 Strings :");
					for (int i = 0; i < 3; i++) {
						String string = scanner.nextLine();
						listHelper.add(stringList2, string);
					}

					listHelper.removeAll(stringList1, stringList2);
					logger.info("ArrayList : " + stringList1);
					logger.info("Length of ArrayList : " + listHelper.listLength(stringList1));

					break;
				case 16:
					logger.info(
							"16. Write a program to create an ArrayList(first ArrayList) & add 5 Strings from the "
									+ "command line to it. Create another ArrayList(second ArrayList) with the same 3 Strings in "
									+ "the previous 5 Strings. Now remove the elements from the first ArrayList which are not "
									+ "present in the second ArrayList. Note: You should not use a loop to remove the elements. "
									+ "Print the ArrayList & the size of it as well");

					stringList1 = listHelper.getList();
					stringList2 = listHelper.getList();

					logger.info("Enter 5 Strings :");
					for (int i = 0; i < 5; i++) {
						String string = scanner.nextLine();
						listHelper.add(stringList1, string);
					}

					logger.info("Enter 3 Strings :");
					for (int i = 0; i < 3; i++) {
						String string = scanner.nextLine();
						listHelper.add(stringList2, string);
					}

					listHelper.retainAll(stringList1, stringList2);
					logger.info("ArrayList : " + stringList1);
					logger.info("Length of ArrayList : " + listHelper.listLength(stringList1));

					break;
				case 17:
					logger.info(
							"17. Write a program to create an ArrayList & add 10 long values from the command line "
									+ "to it. Remove all the long values from the ArrayList. Print the ArrayList & the size of it as well");

					longList = listHelper.getList();

					logger.info("Enter 10 Long numbers :");
					for (int i = 0; i < 10; i++) {
						Long number = scanner.nextLong();
						listHelper.add(longList, number);
					}
					scanner.nextLine();

					listHelper.clear(longList);
					logger.info("ArrayList : " + longList);
					logger.info("Length of ArrayList : " + listHelper.listLength(longList));

					break;
				case 18:
					logger.info(
							"18. Write a program to create an ArrayList & add 5 String values from the command line "
									+ "to it. Check whether a given String is present in the ArrayList. Print the ArrayList & the "
									+ "size of it as well");

					stringList1 = listHelper.getList();

					logger.info("Enter 5 Strings :");
					for (int i = 0; i < 5; i++) {
						String string = scanner.nextLine();
						listHelper.add(stringList1, string);
					}
					logger.info("Enter the string to find : ");
					getString = scanner.nextLine();

					boolean flag = listHelper.contains(stringList1, getString);

					if (flag) {
						logger.info("Element Present");
					} else {

						logger.info("Element Not Present");
					}

					break;
				case 19:
					listHelper.getList(null);
					break;
				default:
					logger.info("Invalid choice");
					scanner.close();
					break;
				}

				logger.info("--------------------------------------------------");
			}

			catch (CustomException e) {
				logger.severe(e.getMessage() + "\n");

			} catch (Exception e) {
				logger.warning("Enter Correct Input : ");
				e.printStackTrace();
				scanner.nextLine();

			}
		}

	}

}
