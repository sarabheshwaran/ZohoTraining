package training.task3.helper;

import java.util.ArrayList;
import training.exceptions.CustomException;
import training.utilities.HelperUtils;

public class StringHelper {

	
	public char[] toCharacterArray(String input) throws CustomException {
		HelperUtils.nullCheck(input);
		return input.toCharArray();
	}

	public String lastButX(String input, int position) throws CustomException {

		int length = HelperUtils.lengthOfString(input);
		HelperUtils.sizeCheck(length, position);

		return String.valueOf(input.charAt(length - position));

	}

	public int countChar(String input, char character) throws CustomException {

		int count = 0;
		int length = HelperUtils.lengthOfString(input);

		for (int i = 0; i < length; i++) {
			if (input.charAt(i) == character) {
				count++;
			}
		}
		return count;
	}

	public int greatestPosition(String input, char character) throws CustomException {

		HelperUtils.nullCheck(input);
		int result = input.lastIndexOf(character);

		HelperUtils.charCheck(result);
		return result;
	}

	public String specificFirst(String input, int size) throws CustomException {

		int length = HelperUtils.lengthOfString(input);
		HelperUtils.sizeCheck(length, size);

		return input.substring(0, size);

	}

	public String specificLast(String input, int size) throws CustomException {

		int length = HelperUtils.lengthOfString(input);

		HelperUtils.sizeCheck(length, size);

		return input.substring(length - size, length);

	}

	public String addSubstringFront(String input, String subString) throws CustomException {

		int inputLength = HelperUtils.lengthOfString(input);
		int subLength = HelperUtils.lengthOfString(subString);

		return subString.concat(specificLast(input, inputLength - subLength));

	}

	public boolean prefixFinder(String input, String subString) throws CustomException {

		HelperUtils.nullCheck(input);

		return input.startsWith(subString);
	}

	public boolean suffixFinder(String input, String subString) throws CustomException {

		HelperUtils.nullCheck(input);

		return input.endsWith(subString);
	}

	public String upperCase(String input) throws CustomException {

		HelperUtils.nullCheck(input);

		return input.toUpperCase();
	}

	public String lowerCase(String input) throws CustomException {
		HelperUtils.nullCheck(input);

		return input.toLowerCase();
	}

	public String reverseString(String input) throws CustomException {

		int length = HelperUtils.lengthOfString(input);

		char[] charArray = toCharacterArray(input);

		int start = 0;
		int end = length - 1;
		while (start < end) {
			char temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;

			start++;
			end--;
		}
		return new String(charArray);
	}

	public String[] stringArray(String input, String point) throws CustomException {

		HelperUtils.nullCheck(input);
		HelperUtils.nullCheck(point);
		return input.split(point);

	}

	public String stringReplace(String input, String target, String element) throws CustomException {

		HelperUtils.nullCheck(input);
		HelperUtils.nullCheck(target);
		HelperUtils.nullCheck(element);

		String output = input.replace(target, element);

		return output;

	}

	public String stringChaining(ArrayList<String> input, String link) throws CustomException {

		HelperUtils.nullCheck(input);
		HelperUtils.nullCheck(link);

		String output = String.join(link, input);

		return output;
	}

	public boolean equalsWithCase(String input1, String input2) throws CustomException {

		HelperUtils.nullCheck(input1);
		HelperUtils.nullCheck(input2);
		return input1.equals(input2);
	}

	public boolean equalsWithoutCase(String input1, String input2) throws CustomException {
		HelperUtils.nullCheck(input1);
		HelperUtils.nullCheck(input2);

		return input1.equalsIgnoreCase(input2);
	}

	public String removePadding(String input) throws CustomException {
		HelperUtils.nullCheck(input);
		return input.trim();
	}

}