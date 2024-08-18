package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {
    public static String randomString() {
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        return generatedString;
    }
}
