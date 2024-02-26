package training.task4.helper;

import training.utilities.HelperUtils;
import training.exceptions.CustomException ;

public class BuilderHelper{
	
	
	
	public StringBuilder createBuilder(CharSequence  input) throws CustomException{
	
		HelperUtils.nullCheck(input);
		return new StringBuilder(input);
	
	}
	public StringBuilder createBuilder(){
	
		
		return new StringBuilder();
	
	}
	
	public int lengthOfBuilder(StringBuilder input) throws CustomException {

		HelperUtils.nullCheck(input);

		return input.length();
	}

	public int capacityOfBuilder(StringBuilder input) throws CustomException {

		HelperUtils.nullCheck(input);

		return input.capacity();
	}

	public StringBuilder appendBuilder(StringBuilder input, Object element) throws CustomException{

		HelperUtils.nullCheck(input);
		HelperUtils.nullCheck(element);

		return input.append(element);

	}

	public StringBuilder insertBuilder(StringBuilder input, String element, int position) throws CustomException{

		HelperUtils.nullCheck(input);
		HelperUtils.nullCheck(element);
		HelperUtils.sizeCheck(capacityOfBuilder(input), position);
		return input.insert(position,element);

	}

	public int greatestPosition(StringBuilder input, String element, int end) throws CustomException {

		HelperUtils.nullCheck(input);
		HelperUtils.nullCheck(element);
		return input.lastIndexOf(element,end);

	}

	public int firstPosition(StringBuilder input, String element, int start) throws CustomException {

		HelperUtils.nullCheck(input);
		HelperUtils.nullCheck(element);
		return input.indexOf(element,start);

	}

	public int findNthPlace(StringBuilder input, String target, int n)  throws CustomException  {
	
		
		int count = 0;
		int index = firstPosition(input,target,0);
		int length = HelperUtils.lengthOfString(target);
		while (index != -1 && count!=n) {
			index = firstPosition(input,target,index + length);
			count ++;
		
		}
		return index;
	}


	public StringBuilder reverseBuilder(StringBuilder input) throws CustomException {

		HelperUtils.nullCheck(input);

		return input.reverse();
	}


	public StringBuilder builderReplace(StringBuilder input, String target, String element) throws CustomException {

		int index = firstPosition(input,target,0);
		int targetLength = HelperUtils.lengthOfString(target);
		int elementLength = HelperUtils.lengthOfString(element);
		while (index != -1) {
			input.replace(index, index + targetLength, element);
			index = firstPosition(input,target, index + elementLength);
		}
		return input;
	}

	

	public void deleteLast(StringBuilder input, String delimeter) throws CustomException {

		int length = lengthOfBuilder(input);
		HelperUtils.nullCheck(delimeter);
		input.delete(greatestPosition(input,delimeter,length),length);
	}

	public void deleteSubstring(StringBuilder input, int start, int end) throws CustomException {


		int length = lengthOfBuilder(input);
		
		HelperUtils.sizeCheck(length,end);
		HelperUtils.sizeCheck(end,start);
		
		input.delete(start,end);
	}

	public void deleteFirst(StringBuilder input, String delimeter) throws CustomException {


		input.delete(0,firstPosition(input,delimeter,0));
	}


	
}