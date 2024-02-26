package training.task8.helper;

//public class Configuration {

//
//	private static Configuration configuration;
//	
//	private int iconSize;
//
//	@Override
//	public String toString() {
//		return "Configuration [iconSize=" + iconSize + "]";
//	}
//
//	private Configuration() {
//	}
//
//	public static Configuration getConfiguration() {
//		
//		if(configuration == null) {
//		
//		configuration = new Configuration();
//		
//		}
//		
//		return configuration;
//	}
//
//	public int getIconSize() {
//		return iconSize;
//	}
//
//	public void setIconSize(int iconSize) {
//		this.iconSize = iconSize;
//	}
//		
//}
//
//public class Configuration {
//
//	private static volatile Configuration configuration;
//
//	private Configuration() {
//	}
//
//	public static Configuration getConfiguration() {
//
//		if (configuration == null) {
//
//			synchronized (Configuration.class) {
//
//			if(configuration==null) {
//				configuration = new Configuration();}
//			}
//
//		}
//
//		return configuration;
//	}
//
//}

public class Configuration {

	private String specs;

	private Configuration() {

		System.out.println("Class initialized !");
	}

	private static class ConfHolder {

		private static final Configuration instance = new Configuration();

	}

	public static Configuration getConfiguration() {

		return ConfHolder.instance;

	}

	public void printConfiguration() {

		System.out.println("Configuration : " + specs);

	}

	public void setConfiguration(String specs) {

		this.specs = specs;

	}

}
