package training.task6.helper;

import training.utilities.HelperUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import training.exceptions.CustomException;


//Coding to the interface java...

public class ArrayListHelper {

	@SuppressWarnings("unchecked")
	public <E> List<E> getList() throws CustomException {
		
		try {
			Class<?> ArrayList = Class.forName("java.util.ArrayList");
			Constructor<?> arrayList = ArrayList.getDeclaredConstructor();
			
			
			return (List<E>) arrayList.newInstance();
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException 
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			
			throw new CustomException("Map cant be initialised ! ", e);
		}
	}

	@SuppressWarnings("unchecked")
	public <E> List<E> getList(List<E> list) throws CustomException {

		HelperUtils.nullCheck(list);
		
		try {
			Class<?> ArrayList = Class.forName("java.util.ArrayList");
			Constructor<?> arrayList = ArrayList.getDeclaredConstructor();
			
			
			return (List<E>) arrayList.newInstance(list);
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException 
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			
			throw new CustomException("Map cant be initialised ! ", e);
		}
		
	}

	public <E> int listLength(List<E> input) throws CustomException {

		HelperUtils.nullCheck(input);

		return input.size();
	}

	public <E> void add(List<E> input, E element) throws CustomException {

		HelperUtils.nullCheck(input);
		HelperUtils.nullCheck(element);

		input.add(element);
	}

	public <E> boolean contains(List<E> input, E element) throws CustomException {

		HelperUtils.nullCheck(input);
		HelperUtils.nullCheck(element);

		return input.contains(element);
	}

	public <E> E getElement(List<E> input, int index) throws CustomException {

		int length = listLength(input);
		HelperUtils.sizeCheck(length, index);

		return input.get(index);
	}

	public <E> void add(List<E> input, E element, int index) throws CustomException {

		int length = listLength(input);
		HelperUtils.sizeCheck(length, index);
		HelperUtils.nullCheck(element);

		input.add(index, element);
	}

	public <E> void addAll(int index, List<E> input, List<E> elements) throws CustomException {

		int length = listLength(input);
		HelperUtils.sizeCheck(length, index);
		HelperUtils.nullCheck(elements);

		input.addAll(index, elements);
	}

	public <E> void addAll(List<E> input, List<E> elements) throws CustomException {

		HelperUtils.nullCheck(input);
		HelperUtils.nullCheck(elements);

		input.addAll(elements);
	}

	public <E> void remove(List<E> input, E element) throws CustomException {

		HelperUtils.nullCheck(input);
		HelperUtils.nullCheck(element);

		input.remove(element);
	}

	public <E> void remove(List<E> input, int index) throws CustomException {

		int length = listLength(input);
		HelperUtils.sizeCheck(length, index);

		input.remove(index);
	}

	public <E> void removeAll(List<E> input, List<E> elements) throws CustomException {

		HelperUtils.nullCheck(input);
		HelperUtils.nullCheck(elements);

		input.removeAll(elements);
	}

	public <E> void clear(List<E> input) throws CustomException {

		HelperUtils.nullCheck(input);

		input.clear();
	}

	public <E> void retainAll(List<E> input, List<E> elements) throws CustomException {

		HelperUtils.nullCheck(input);
		HelperUtils.nullCheck(elements);

		input.retainAll(elements);
	}

	public <E> int indexOf(List<E> input, E element) throws CustomException {

		HelperUtils.nullCheck(input);
		HelperUtils.nullCheck(element);

		return input.indexOf(element);
	}

	public <E> int lastIndexOf(List<E> input, E element) throws CustomException {

		HelperUtils.nullCheck(input);
		HelperUtils.nullCheck(element);

		return input.lastIndexOf(element);
	}

	public <E> List<E> subList(List<E> input, int start, int end) throws CustomException {

		int length = listLength(input);

		HelperUtils.sizeCheck(length, end);
		HelperUtils.sizeCheck(end, start);

		return input.subList(start, end);
	}

	public <E> Iterator<E> getItr(List<E> input) throws CustomException {

		HelperUtils.nullCheck(input);

		return input.iterator();
	}

}
