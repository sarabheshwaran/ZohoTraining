package training.task10.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import training.exceptions.CustomException;
import training.task6.helper.ArrayListHelper;
import training.utilities.HelperUtils;

public class RegexHelper {

	public boolean validatePhoneNo(String phoneNo) throws CustomException {

		HelperUtils.nullCheck(phoneNo);
		return Pattern.matches("[789]{1}\\d{9}", phoneNo);

	}

	public boolean validateEmail(String email) throws CustomException {

		HelperUtils.nullCheck(email);
		return Pattern.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,5}$", email);

	}
	
	public boolean passwordValidate(String password) throws CustomException{
		
		HelperUtils.nullCheck(password);
		
		String regex = "^(?=.*[A-Z])"
				+ "(?=.*[a-z])"
				+ "(?=.*\\d)"
				+ "(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\\\"\\\\|,.<>/?])"
				+ "(?=.*[0-9])"
				+ ".{8,}$";
		
		return Pattern.matches(regex, password);
		
	}

	public boolean isAlphaNumeric(String input) throws CustomException {

		HelperUtils.nullCheck(input);
		return Pattern.matches("^(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]+$", input);

	}

	public boolean startsWith(String input, String regex) throws CustomException {
		try {

			HelperUtils.nullCheck(input);
			HelperUtils.nullCheck(regex);
			return Pattern.matches("\\A" + regex + ".*", input);
		} catch (PatternSyntaxException e) {
			throw new CustomException("Regex pattern not valid : ", e);
		}
	}

	public boolean endsWith(String input, String regex) throws CustomException {
		try {

			HelperUtils.nullCheck(input);
			HelperUtils.nullCheck(regex);

			return Pattern.matches("\\A.*" + regex + "\\Z", input);

		} catch (PatternSyntaxException e) {
			throw new CustomException("Regex pattern not valid : ", e);
		}

	}

	public boolean contains(String input, String regex) throws CustomException {
		try {

			HelperUtils.nullCheck(input);
			HelperUtils.nullCheck(regex);
			return Pattern.matches("\\A.*" + regex + "+.*\\Z", input);

		} catch (PatternSyntaxException e) {
			throw new CustomException("Regex pattern not valid : ", e);
		}

	}

	public boolean caseInsensitiveCompare(String input, String regex) throws CustomException {

		try {

			HelperUtils.nullCheck(input);
			HelperUtils.nullCheck(regex);
			Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

			return pattern.matcher(input).find();

		} catch (PatternSyntaxException e) {
			throw new CustomException("Regex pattern not valid : ", e);
		}

	}

	public boolean checkLength(String input, int lowerLimit, int upperLimit) throws CustomException {

		HelperUtils.nullCheck(input);
		return Pattern.matches("^.{" + lowerLimit + "," + upperLimit + "}$", input);

	}

	public Map<Integer, String> regexMapping(List<String> regList, List<String> stringList) throws CustomException {
		try {

			HelperUtils.nullCheck(regList);
			HelperUtils.nullCheck(stringList);

			Map<Integer, String> map = new HashMap<Integer, String>();

			String regString = regList.toString();

			String strString = String.join(" ", stringList);
			
			
			regString = String.join("|", regList);

			regString = "\\b(" + regString + ")\\b";

			Pattern pattern = Pattern.compile(regString);

			Matcher matcher = pattern.matcher(strString);

			matcher.replaceAll(matchResult -> {
				String out = matchResult.group();
				map.put(stringList.indexOf(out), out);

				return "";
			});

			return map;
		} catch (PatternSyntaxException e) {
			throw new CustomException("Regex pattern not valid : ", e);
		}

	}
	


	public List<String> getAllMatchers(String input, String regex) throws CustomException {

		try {
			HelperUtils.nullCheck(input);
			HelperUtils.nullCheck(regex);

			ArrayListHelper listHelper = new ArrayListHelper();

			Pattern pattern = Pattern.compile(regex);

			Matcher matcher = pattern.matcher(input);

			List<String> strList = listHelper.getList();

			while (matcher.find()) {
				listHelper.add(strList, matcher.group());

			}

			return strList;
		} catch (PatternSyntaxException e) {
			throw new CustomException("Regex pattern not valid : ", e);
		}

	}

}
