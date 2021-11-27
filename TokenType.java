import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Token {

	ADDITION ("\\+"),
    SUBTRACTION ("-"),
    MULTIPLICATION ("\\*"),
    DIVISION ("/"),
    MODULUS ("%"),
    NUMBER ("\\d+(\\.\\d+)?");

	private final Pattern pattern;

    Token(String regex) {
        pattern = Pattern.compile("^" + regex);
    }

    int endOfMatch(String s) {
        Matcher m = pattern.matcher(s);

        if (m.find()) {
            return m.end();
        }

        return -1;
    }
}
