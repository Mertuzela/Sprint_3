import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountNameWithSpaceTest {
    String nameWithSpace;
    boolean expected;

    public AccountNameWithSpaceTest(String nameWithSpace, boolean expected) {
        this.nameWithSpace = nameWithSpace;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Пробел в имени: {0} {1} ")
    public static Object[][] getSpaceInName() {
        return new Object[][] {
                {" Дин ", false}, // пробел в начале и в конце
                {"Сэм ", false}, // пробел в конце
                {"", false}, // пустая строка
                {"     ", false}, // строка из пробелов
                {"Два  Пробела", false} // два пробела в центре
        };
    }

    @Test
    public void checkSpaceInName() {
        Account account = new Account(nameWithSpace);
        Assert.assertEquals(expected, account.checkNameToEmboss());
    }
}