package model.validator;

public class StringValidator extends Validator<String> {
    public static final String SMALL = "Your string is too small";
    public static final String LARGE = "Your string is too large";
    public static final String INVALID_CHARS = "Your string contains invalid characters";

    int min;
    int max;
    String allowedCharacters;

    public StringValidator(int min, int max, String allowedCharacters) {
        this.min = min;
        this.max = max;
        this.allowedCharacters = allowedCharacters;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean isValid(String value) {
        if (value.length() < min) {
            message = SMALL;
            return false;
        } else if (value.length() > max) {
            message = LARGE;
            return false;
        } else if (!containsAllowedCharacters(value)) {
            message = INVALID_CHARS;
            return false;
        }
        return true;
    }

    private boolean containsAllowedCharacters(String value) {
        for (char c : value.toCharArray()) {
            if (allowedCharacters.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }
}
