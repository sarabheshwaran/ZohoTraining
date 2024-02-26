package training.task7.helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import training.exceptions.CustomException;
import training.utilities.HelperUtils;

public class MapHelper {

	@SuppressWarnings("unchecked")
	public <K, V> Map<K, V> getMap() throws CustomException  {
		
		
		
		try {
			Class<?> HashMap = Class.forName("java.util.HashMap");
			Constructor<?> hashMap = HashMap.getDeclaredConstructor();
			
			
			return (Map<K, V>) hashMap.newInstance();
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException 
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			
			throw new CustomException("Map cant be initialised ! ", e);
		}
		
	}

	public <K, V> int mapLength(Map<K, V> map) throws CustomException {

		HelperUtils.nullCheck(map);

		return map.size();
	}

	public <K, V> V put(Map<K, V> map, K key, V value) throws CustomException {

		HelperUtils.nullCheck(map);

		return map.put(key, value);
	}

	public <K, V> V get(Map<K, V> map, K key) throws CustomException {

		HelperUtils.nullCheck(map);

		return map.get(key);
	}

	public <K, V> V getOrDefault(Map<K, V> map, K key, V defaultValue) throws CustomException {

		HelperUtils.nullCheck(map);

		return map.getOrDefault(key, defaultValue);
	}

	public <K, V> boolean containsKey(Map<K, V> map, K key) throws CustomException {

		HelperUtils.nullCheck(map);

		return map.containsKey(key);
	}

	public <K, V> boolean containsValue(Map<K, V> map, V value) throws CustomException {

		HelperUtils.nullCheck(map);

		return map.containsValue(value);
	}

	public <K, V> void putAll(Map<K, V> map1, Map<K, V> map2) throws CustomException {

		HelperUtils.nullCheck(map1);
		HelperUtils.nullCheck(map2);

		map1.putAll(map2);

	}

	public <K, V> Set<K> keySet(Map<K, V> map) throws CustomException {

		HelperUtils.nullCheck(map);

		return map.keySet();

	}

	public <K, V> V remove(Map<K, V> map, K key) throws CustomException {

		HelperUtils.nullCheck(map);

		return map.remove(key);
	}

	public <K, V> boolean remove(Map<K, V> map, K key, V value) throws CustomException {

		HelperUtils.nullCheck(map);

		return map.remove(key, value);
	}

	public <K, V> V replace(Map<K, V> map, K key, V value) throws CustomException {

		HelperUtils.nullCheck(map);

		return map.replace(key, value);
	}

	public <K, V> boolean replace(Map<K, V> map, K key, V oldvalue, V newValue) throws CustomException {

		HelperUtils.nullCheck(map);

		return map.replace(key, oldvalue, newValue);
	}

	public <K, V> Iterator<K> getKeyItr(Map<K, V> map) throws CustomException {

		return keySet(map).iterator();
	}

	public <K, V> void clear(Map<K, V> map) throws CustomException {

		HelperUtils.nullCheck(map);
		map.clear();

	}

}
