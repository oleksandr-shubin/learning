import model.validator.RegexValidator;
import model.validator.StringValidator;
import model.validator.Validator;

public class Main {
    public static void main(String[] args) {
        String userName = "john_smith";

        String pattern = "\\w{4,16}";
        Validator<String> regexValidator = new RegexValidator(pattern);
        System.out.print("Regex model.validator: ");
        if (regexValidator.isValid(userName)) {
            System.out.println("valid");
        } else {
            System.out.println(regexValidator.getMessage());
        }

        Validator<String> stringValidator = new StringValidator(4, 16,
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "abcdefghijklmnopqrstuvwxyz" +
                "123456789_");
        System.out.print("String model.validator: ");
        if (stringValidator.isValid(userName)) {
            System.out.println("valid");
        } else {
            System.out.println(stringValidator.getMessage());
        }
    }
}
