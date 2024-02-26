package training.task8.helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import training.exceptions.CustomException;
import training.utilities.HelperUtils;

public class ReflectionHelper {

	public Class<?> getClass(String name) throws ClassNotFoundException, CustomException {

		HelperUtils.nullCheck(name);

		return Class.forName(name);
	}

	public Constructor<?> getConstructor(Class<?> clazz, Class<?>... types)
			throws NoSuchMethodException, SecurityException {

		return clazz.getConstructor(types);

	}
	
	public Method getMethod(Class<?> clazz,String name, Class<?>... types)
			throws NoSuchMethodException, SecurityException {

		return clazz.getMethod(name, types);

	}

	public Object getInstance(Constructor<?> constructor, Object... types) throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		return constructor.newInstance(types);

	}
	
	public Object invokeMethod(Method method, Object myObj, Object... types) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		return method.invoke(myObj,types);
		
	}
	
	

}
