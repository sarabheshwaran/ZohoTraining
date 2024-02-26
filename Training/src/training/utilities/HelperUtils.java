package training.utilities;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import training.exceptions.CustomException;

public class HelperUtils {
	private static final String nullErrorMessage = "Input is null !";
	private static final String sizeErrorMessage = "Bound size violated !";
	private static final String elementNotFound = "element not found";

	public static void nullCheck(Object input) throws CustomException {

		if (input == null) {
			throw new CustomException(nullErrorMessage);
		}

	}

	public static void sizeCheck(int collectionSize, int index) throws CustomException {

		if (collectionSize < index || index < 0) {
			throw new CustomException(sizeErrorMessage);
		}

	}

	public static void charCheck(int index) throws CustomException {
		if (index < 0) {
			throw new CustomException(elementNotFound);
		}
	}
	
	public static int lengthOfString(String input) throws CustomException {

		nullCheck(input);

		return input.length();
	}
	
	public static void formatLogger(String fileName) throws SecurityException, IOException, CustomException {
		
		nullCheck(fileName);
		
		Logger logger = Logger.getGlobal();
   	 
        ConsoleHandler console = new ConsoleHandler();
        
        
        FileHandler file = new FileHandler(fileName+".log",true);
        
        console.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + ":    " + record.getMessage() + "\n";
            }});
        
        
        file.setFormatter(new SimpleFormatter());
        logger.setUseParentHandlers(false);

        logger.addHandler(console);
        logger.addHandler(file);
    	
		
	}

}