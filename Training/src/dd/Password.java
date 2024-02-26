package dd;

import org.junit.Test;

import training.exceptions.CustomException;
import training.task10.helper.RegexHelper;

import static org.junit.Assert.*;

public class Password {

    @Test
    public void testValidPassword()throws CustomException{
        RegexHelper regHelper = new RegexHelper();

        // Valid password with uppercase, lowercase, digit, and special character
        assertTrue(regHelper.passwordValidate("SecureP@ss1"));
        assertFalse(regHelper.passwordValidate("Abc123"));
        assertFalse(regHelper.passwordValidate("password1@"));
        assertFalse(regHelper.passwordValidate("PASSWORD1@"));
        assertFalse(regHelper.passwordValidate("SecurePass@"));
    }



    @Test
    public void testInvalidNoSpecialCharacter()throws CustomException{
        RegexHelper regHelper = new RegexHelper();

        // Invalid: Missing special character
        assertFalse(regHelper.passwordValidate("SecurePass1"));
    }


    @Test
    public void testInvalidEmptyPassword()throws CustomException{
        RegexHelper regHelper = new RegexHelper();

        // Invalid: Empty password
        assertFalse(regHelper.passwordValidate(""));
    }

    @Test
    public void testValidComplexPassword()throws CustomException{
        RegexHelper regHelper = new RegexHelper();

        // Valid password with various characters
        assertTrue(regHelper.passwordValidate("Comp!exP@ssw0rd"));
    }

    @Test
    public void testInvalidNoSpecialCharacter2()throws CustomException{
        RegexHelper regHelper = new RegexHelper();

        // Invalid: Missing special character
        assertFalse(regHelper.passwordValidate("Abcdefg123"));
    }

    @Test
    public void testValidLongPassword()throws CustomException{
        RegexHelper regHelper = new RegexHelper();

        // Valid long password
        assertTrue(regHelper.passwordValidate("LongPassword1234567@"));
    }
}

