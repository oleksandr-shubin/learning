package model.validator;

import java.util.regex.Pattern;

public class RegexValidator extends Validator<String> {
    public static final String INVALID_STRING = "Your string is invalid";
    private Pattern pattern;

    public RegexValidator(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    @Override
    public boolean isValid(String value) {
        if (pattern.matcher(value).matches()) {
            return true;
        } else {
            message = INVALID_STRING;
            return false;
        }
    }
}

