package courier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Courier {
    private String login;
    private String password;
    private String firstName;


public static Courier getRandom() {
    String login = RandomStringUtils.randomAlphanumeric(10);
    String password = RandomStringUtils.randomAlphanumeric(4);
    String firstName = RandomStringUtils.randomAlphabetic(10);

    return new Courier(login,password,firstName);
    }
}
