package training.task8.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import training.exceptions.CustomException;
import training.utilities.HelperUtils;

public class FileHelper {

	public void fileCreation(String fileName, String filePath, List<String> list) throws CustomException{

		HelperUtils.nullCheck(list);
		HelperUtils.nullCheck(fileName);
		HelperUtils.nullCheck(filePath);

		try (Writer writer = getBufferedWriter(getFileWriter(filePath + fileName, false))) {
			File folders = getFile(filePath);

			makeDirs(folders);

			for (String line : list) {

				writer.write(line);

			}
		} catch (IOException e) {
			throw new CustomException("Exception in writing : ", e);

		}
	}

	public void writeProp(String fileName, String filePath, Properties properties) throws CustomException {

		HelperUtils.nullCheck(properties);
		HelperUtils.nullCheck(fileName);
		HelperUtils.nullCheck(filePath);

		try (Writer writer = getBufferedWriter(getFileWriter(filePath + fileName, false))) {
			File folders = getFile(filePath);

			makeDirs(folders);

			store(properties, writer);

		} catch (IOException e) {
			throw new CustomException("Exception in writing : ", e);

		}
	}

	public void readProp(String fileName, String filePath, Properties properties) throws CustomException {

		HelperUtils.nullCheck(properties);
		HelperUtils.nullCheck(fileName);
		HelperUtils.nullCheck(filePath);

		try (Reader reader = getBufferedReader(getFileReader(filePath + fileName))) {
			File folders = getFile(filePath);

			makeDirs(folders);

			load(properties, reader);

		} catch (IOException e) {
			throw new CustomException("Exception in reading : ",e);

		}
	}

	public File getFile(String path) throws CustomException {

		HelperUtils.nullCheck(path);
		return new File(path);

	}

	public void makeDirs(File file) throws CustomException {

		HelperUtils.nullCheck(file);

		if (!file.exists()) {
			if (file.mkdirs()) {
				throw new CustomException("Directory Creation Failed !");
			}
		}

	}

	public Writer getFileWriter(String filePath, boolean append) throws IOException, CustomException {

		HelperUtils.nullCheck(filePath);
		return new FileWriter(filePath, append);

	}

	public Writer getBufferedWriter(Writer writer) throws IOException, CustomException {

		HelperUtils.nullCheck(writer);
		return new BufferedWriter(writer);

	}

	public Reader getFileReader(String filePath) throws IOException, CustomException {

		HelperUtils.nullCheck(filePath);
		return new FileReader(filePath);

	}

	public Reader getBufferedReader(Reader fileReader) throws CustomException {

		HelperUtils.nullCheck(fileReader);
		return new BufferedReader(fileReader);
	}

	public Properties getProp() {
		return new Properties();
	}

	public void addProperty(Properties properties, String key, String value) throws CustomException {

		HelperUtils.nullCheck(key);
		HelperUtils.nullCheck(value);

		properties.setProperty(key, value);
	}

	public String getProperty(Properties properties, String key) throws CustomException {
		HelperUtils.nullCheck(properties);
		HelperUtils.nullCheck(key);

		return properties.getProperty(key);
	}

	public Set<String> keySet(Properties properties) throws CustomException {
		HelperUtils.nullCheck(properties);

		return properties.stringPropertyNames();
	}

	public void store(Properties properties, Writer writer) throws IOException, CustomException {

		HelperUtils.nullCheck(writer);
		HelperUtils.nullCheck(properties);
		properties.store(writer, "Storing Properties");

	}

	public void load(Properties properties, Reader reader) throws IOException, CustomException {

		HelperUtils.nullCheck(reader);
		HelperUtils.nullCheck(properties);
		properties.load(reader);

	}

}
