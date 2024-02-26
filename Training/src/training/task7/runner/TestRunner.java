package training.task7.runner;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import training.task5.objects.carobjects.Car;
import training.task7.helper.MapHelper;
import training.utilities.HelperUtils;
import training.exceptions.CustomException;

public class TestRunner {

	public static void main(String[] args) {
		Logger logger = Logger.getGlobal();
		try {
			HelperUtils.formatLogger("7");
		} catch (SecurityException | IOException | CustomException e) {
			// TODO Auto-generated catch block
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
				MapHelper mapHelper = new MapHelper();

				Map<Object, Object> map;
				Map<Integer, Integer> intMap;

				switch (choice) {
				case 1: {
					logger.info("1. Create a HashMap. Print the HashMap & its size.");

					map = mapHelper.getMap();

					logger.info("HashMap : " + map);
					logger.info("Size of HashMap : " + mapHelper.mapLength(map));

					break;
				}

				case 2: {
					logger.info("2. Create a HashMap & add 3 pairs of keys(String) & values(String). "
							+ "Print the HashMap & its size.");

					Map<String, String> stringMap = mapHelper.getMap();

					logger.info("Enter the Strings :");
					for (int i = 0; i < 3; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(stringMap, key, value);

					}

					logger.info("HashMap : " + stringMap);
					logger.info("Size of HashMap : " + mapHelper.mapLength(stringMap));

					break;
				}

				case 3: {
					logger.info("3. Create a HashMap & add 3 pairs of keys(Integer) & values(Integer). "
							+ "Print the HashMap & its size.");

					intMap = mapHelper.getMap();

					logger.info("Enter the Strings :");
					for (int i = 0; i < 3; i++) {

						int key = scanner.nextInt();
						int value = scanner.nextInt();
						scanner.nextLine();
						mapHelper.put(intMap, key, value);

					}

					logger.info("HashMap : " + intMap);
					logger.info("Size of HashMap : " + mapHelper.mapLength(intMap));

					break;
				}

				case 4: {
					logger.info("4. Create a HashMap & add 3 pairs of keys(String) & values(Integer). "
							+ "Print the HashMap & its size.");

					Map<String, Integer> strIntMap = mapHelper.getMap();

					logger.info("Enter the String and Integer Pairs :");
					for (int i = 0; i < 3; i++) {

						String key = scanner.next();
						int value = scanner.nextInt();
						scanner.nextLine();
						mapHelper.put(strIntMap, key, value);

					}

					logger.info("HashMap : " + strIntMap);
					logger.info("Size of HashMap : " + mapHelper.mapLength(strIntMap));

					break;
				}
				case 5: {
					logger.info("5. Create a HashMap & add 3 pairs of keys(String) & value(your own object). "
							+ "Print the HashMap & its size.");

					Map<String, Car> carMap = mapHelper.getMap();

					logger.info("Enter the Keys to store Car Objects :");

					for (int i = 0; i < 3; i++) {

						String key = scanner.next();
						scanner.nextLine();
						mapHelper.put(carMap, key, new Car(i));

					}

					logger.info("HashMap : " + carMap);
					logger.info("Size of HashMap : " + mapHelper.mapLength(carMap));

					break;
				}
				case 6: {
					logger.info("6. Create a HashMap & add 3 keys(String) with a null value to one of the keys. "
							+ "Print the HashMap & its size.");

					Map<String, String> strIntMap = mapHelper.getMap();

					logger.info("Enter the String Pairs :");
					for (int i = 0; i < 2; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(strIntMap, key, value);

					}
					mapHelper.put(strIntMap, "key", null);
					logger.info("HashMap : " + strIntMap);
					logger.info("Size of HashMap : " + mapHelper.mapLength(strIntMap));

					break;
				}
				case 7: {
					logger.info("7. Create a HashMap & add a null key & non-null value to it. "
							+ "Print the HashMap & its size.");

					Map<String, String> strIntMap = mapHelper.getMap();

					logger.info("Enter the String Pairs :");
					for (int i = 0; i < 2; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(strIntMap, key, value);

					}
					mapHelper.put(strIntMap, null, "value");
					logger.info("HashMap : " + strIntMap);
					logger.info("Size of HashMap : " + mapHelper.mapLength(strIntMap));

					break;

				}
				case 8: {
					logger.info("8. Check if a key exists in a HashMap.");

					Map<String, String> stringMap = mapHelper.getMap();

					logger.info("Enter number of pairs :");
					int count = scanner.nextInt();
					scanner.nextLine();

					logger.info("Enter the Pairs :");
					for (int i = 0; i < count; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(stringMap, key, value);

					}

					logger.info("Enter key to check :");
					String key = scanner.nextLine();

					boolean flag = mapHelper.containsKey(stringMap, key);

					if (flag) {
						logger.info("Key is present");
					} else {
						logger.info("Given Key is not present !");
					}

					break;
				}
				case 9: {
					logger.info("9. Check if a value exists in a HashMap.");
					Map<String, String> stringMap = mapHelper.getMap();

					logger.info("Enter number of pairs :");
					int count = scanner.nextInt();
					scanner.nextLine();

					logger.info("Enter the Pairs :");
					for (int i = 0; i < count; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(stringMap, key, value);

					}

					logger.info("Enter value to check :");
					String value = scanner.nextLine();

					boolean flag = mapHelper.containsValue(stringMap, value);

					if (flag) {
						logger.info("Value is present");
					} else {
						logger.info("Given Value is not present !");
					}

					break;
				}
				case 10: {
					logger.info("10. Create a HashMap & add 3 pairs of keys(String) & values(String). "
							+ "Change the values for all the 3 keys. Print the HashMap & its size before & after the change.");

					Map<String, String> stringMap = mapHelper.getMap();

					logger.info("Enter the Pairs :");
					for (int i = 0; i < 3; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(stringMap, key, value);

					}

					logger.info("HashMap : " + stringMap);
					logger.info("Size of HashMap : " + mapHelper.mapLength(stringMap));

					logger.info("Enter the Values to update :");
					Iterator<String> iterator = mapHelper.getKeyItr(stringMap);

					while (iterator.hasNext()) {

						String key = iterator.next();
						logger.info(key + " : ");
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(stringMap, key, value);

					}
					logger.info("HashMap : " + stringMap);
					logger.info("Size of HashMap : " + mapHelper.mapLength(stringMap));

					break;
				}
				case 11: {
					logger.info("11. Get the value of an existing key in a HashMap.");

					Map<String, String> stringMap = mapHelper.getMap();

					logger.info("Enter number of pairs :");
					int count = scanner.nextInt();
					scanner.nextLine();

					logger.info("Enter the Pairs :");
					for (int i = 0; i < count; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(stringMap, key, value);

					}

					logger.info("Enter the key to get value :");
					String key = scanner.nextLine();

					logger.info("The value is :");
					logger.info(mapHelper.get(stringMap, key));

					break;
				}
				case 12: {
					logger.info("12. Get the value of a non-existing key in a HashMap.");

					Map<String, String> stringMap = mapHelper.getMap();

					logger.info("Enter number of pairs :");
					int count = scanner.nextInt();
					scanner.nextLine();

					logger.info("Enter the Pairs :");
					for (int i = 0; i < count; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(stringMap, key, value);

					}

					logger.info("Enter the key to get value :");
					String key = scanner.nextLine();

					logger.info("The value is :");
					logger.info(mapHelper.get(stringMap, key));

					break;
				}
				case 13: {
					logger.info("13. Return 'Zoho' as a value for a given non-existing key in a HashMap. "
							+ "Print the HashMap & its size before & after the change.");

					Map<String, String> stringMap = mapHelper.getMap();

					logger.info("Enter number of pairs :");
					int count = scanner.nextInt();
					scanner.nextLine();

					logger.info("Enter the Pairs :");
					for (int i = 0; i < count; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(stringMap, key, value);

					}
					logger.info("HashMap : " + stringMap);
					logger.info("Size of HashMap : " + mapHelper.mapLength(stringMap));

					logger.info("Enter the key to get value :");
					String key = scanner.nextLine();

					logger.info("The value is :");
					logger.info(mapHelper.getOrDefault(stringMap, key, "ZOHO"));

					logger.info("HashMap : " + stringMap);
					logger.info("Size of HashMap : " + mapHelper.mapLength(stringMap));

					break;
				}
				case 14: {
					logger.info("14. Remove an existing key in a HashMap. "
							+ "Print the HashMap & its size before & after the change.");

					Map<String, String> stringMap = mapHelper.getMap();

					logger.info("Enter number of pairs :");
					int count = scanner.nextInt();
					scanner.nextLine();

					logger.info("Enter the Pairs :");
					for (int i = 0; i < count; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(stringMap, key, value);

					}

					logger.info("Enter the key to remove :");
					String key = scanner.nextLine();
					mapHelper.remove(stringMap, key);

					logger.info("HashMap : " + stringMap);
					logger.info("Size of HashMap : " + mapHelper.mapLength(stringMap));
					break;
				}
				case 15: {
					logger.info(
							"15. Remove an existing key only if its value matches with the given value in a HashMap. "
									+ "Print the HashMap & its size before & after the change.");

					Map<String, String> stringMap = mapHelper.getMap();

					logger.info("Enter number of pairs :");
					int count = scanner.nextInt();
					scanner.nextLine();

					logger.info("Enter the Pairs :");
					for (int i = 0; i < count; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(stringMap, key, value);

					}

					logger.info("Enter the key-value pair to remove :");
					logger.info("Key : ");
					String key = scanner.nextLine();
					logger.info("Value : ");
					String value = scanner.nextLine();
					mapHelper.remove(stringMap, key, value);

					logger.info("HashMap : " + stringMap);
					logger.info("Size of HashMap : " + mapHelper.mapLength(stringMap));

					break;
				}
				case 16: {
					logger.info("16. Replace the value of an existing key in a HashMap. "
							+ "Print the HashMap & its size before & after the change.");

					Map<String, String> stringMap = mapHelper.getMap();

					logger.info("Enter number of pairs :");
					int count = scanner.nextInt();
					scanner.nextLine();

					logger.info("Enter the Pairs :");
					for (int i = 0; i < count; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(stringMap, key, value);

					}

					logger.info("Enter the key to replace : ");
					String key = scanner.nextLine();
					logger.info("Replacing value :  ");
					String value = scanner.nextLine();
					mapHelper.replace(stringMap, key, value);

					logger.info("HashMap : " + stringMap);
					logger.info("Size of HashMap : " + mapHelper.mapLength(stringMap));

					break;
				}
				case 17: {
					logger.info(
							"17. Replace the value of an existing key only if its value matches with the given value in a HashMap. "
									+ "Print the HashMap & its size before & after the change.");
					Map<String, String> stringMap = mapHelper.getMap();

					logger.info("Enter number of pairs :");
					int count = scanner.nextInt();
					scanner.nextLine();

					logger.info("Enter the Pairs :");
					for (int i = 0; i < count; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(stringMap, key, value);

					}

					logger.info("Enter the key to replace : ");
					logger.info("Key : ");
					String key = scanner.nextLine();
					logger.info("Value : ");
					String oldValue = scanner.nextLine();
					logger.info("New Value : ");
					String newValue = scanner.nextLine();
					mapHelper.replace(stringMap, key, oldValue, newValue);

					logger.info("HashMap : " + stringMap);
					logger.info("Size of HashMap : " + mapHelper.mapLength(stringMap));

					break;
				}
				case 18: {
					logger.info("18. Transfer all the keys & values of a HashMap to another HashMap "
							+ "which has 3 pairs of keys & values already. "
							+ "Print both the HashMaps & their size before & after the change.");
					Map<String, String> stringMap1 = mapHelper.getMap();

					logger.info("First Map : ");
					logger.info("Enter number of pairs :");
					int count = scanner.nextInt();
					scanner.nextLine();

					logger.info("Enter the Pairs :");
					for (int i = 0; i < count; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(stringMap1, key, value);

					}

					logger.info("HashMap : " + stringMap1);
					logger.info("Size of HashMap : " + mapHelper.mapLength(stringMap1));

					Map<String, String> stringMap2 = mapHelper.getMap();

					logger.info("Second Map : ");
					logger.info("Enter 3 Pairs for map2 :");
					for (int i = 0; i < 3; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(stringMap2, key, value);

					}
					logger.info("Before adding : ");
					logger.info("HashMap : " + stringMap2);
					logger.info("Size of HashMap : " + mapHelper.mapLength(stringMap2));
					logger.info("\n");
					mapHelper.putAll(stringMap2, stringMap1);
					logger.info("HashMap : " + stringMap2);
					logger.info("Size of HashMap : " + mapHelper.mapLength(stringMap2));
					logger.info("After adding : ");

					break;
				}
				case 19: {
					logger.info("19. Iterate over a HashMap & print all its key & its corresponding value.");

					Map<String, String> stringMap = mapHelper.getMap();

					logger.info("Enter number of pairs :");
					int count = scanner.nextInt();
					scanner.nextLine();

					logger.info("Enter the Pairs :");
					for (int i = 0; i < count; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(stringMap, key, value);

					}

					Iterator<String> iterator = mapHelper.getKeyItr(stringMap);

					while (iterator.hasNext()) {
						String key = iterator.next();
						logger.info(key + " - " + mapHelper.get(stringMap, key));

					}

					break;
				}
				case 20: {
					logger.info("20. Remove all entries in a HashMap. "
							+ "Print both the HashMaps & their size before & after the change.");

					Map<String, String> stringMap = mapHelper.getMap();

					logger.info("Enter number of pairs :");
					int count = scanner.nextInt();
					scanner.nextLine();

					logger.info("Enter the Pairs :");
					for (int i = 0; i < count; i++) {

						String key = scanner.next();
						String value = scanner.next();
						scanner.nextLine();
						mapHelper.put(stringMap, key, value);

					}
					logger.info("Before removing : ");
					logger.info("HashMap : " + stringMap);
					logger.info("Size of HashMap : " + mapHelper.mapLength(stringMap));

					logger.info("\n");
					mapHelper.clear(stringMap);

					logger.info("After removing : ");
					logger.info("HashMap : " + stringMap);
					logger.info("Size of HashMap : " + mapHelper.mapLength(stringMap));

					break;
				}
				case 0: {
					loop = false;
					scanner.close();

					break;
				}
				
				default: {
					logger.info("Invalid case number.");

					break;
				}
				}

				logger.info("--------------------------------------------------");
			}

			catch (CustomException e) {
				logger.severe(e.getMessage() + "\n");

			} catch (Exception e) {
				logger.warning("Enter Correct Input : ");
				scanner.nextLine();

			}
		}

	}

}
