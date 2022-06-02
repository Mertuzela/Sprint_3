import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountNameTest {
     String name;
    boolean expected;

    public AccountNameTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Длина имени = {0} {1}")
    public static Object[][] checkAccountName() {
        return new Object[][] {
                {"S W",true}, //3
                {"Crowley Markshepard",true},//19
                {"Ли Ю",true},//4
                {"Святослав Антоновв",true},//18
                {"Пр",false},//2
                {"Crowley Marksheppard",false}, //20
                {"Кирилл Смирнов",true} //14
        };
    }

    @Test
    public void checkNameLength() {
        Account account = new Account(name);
        Assert.assertEquals(expected, account.checkNameToEmboss());
    }
}