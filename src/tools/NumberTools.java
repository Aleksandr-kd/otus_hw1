package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NumberTools {

    public boolean isNumberAgeAndWeight(String numberStr) {
        Pattern pattern = Pattern.compile("^[1-9]\\d?$");
        Matcher matcher = pattern.matcher(numberStr.trim());

        return matcher.find();
    }

    public boolean isNumberId(String inputId) {
        Pattern pattern = Pattern.compile("^[1-9]\\d*$");
        Matcher matcher = pattern.matcher(inputId.trim());

        return matcher.find();
    }
}
