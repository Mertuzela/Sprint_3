import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;
    private final String regex = "((?=([[а-яА-Я][a-zA-Z]]+\\s[[а-яА-Я][a-zA-Z]]+$))(?=(^.{3,19}$)))";
    Pattern pattern = Pattern.compile(regex);

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }
}