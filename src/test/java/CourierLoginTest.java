import courier.RestAssuredClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CourierLoginTest extends RestAssuredClient {

    @Test
    @DisplayName("Login courier")
    @Description("Check for login courier in system with valid data")
    public void loginCourier() {
        CourierCreate courierCreate = new CourierCreate("ninja","1234");
        reqSpec
                        .body(courierCreate)
                        .when()
                        .post(LOGIN_URL)
                        .then().log().all()
                        .assertThat().body("id", notNullValue())
                        .and()
                        .statusCode(200);
    }

    @Test
    @DisplayName("Login courier with incorrect login")
    @Description("Check for login courier in system with incorrect login")
    public void loginCourierIncorrectLogin() {
        CourierCreate courierCreate = new CourierCreate("ninj1a","1234");
        reqSpec
                        .body(courierCreate)
                        .when()
                        .post(LOGIN_URL)
                        .then().log().all()
                        .assertThat()
                        .statusCode(404)
                        .body(equalTo(login_error_404));
    }

    @Test
    @DisplayName("Login courier with incorrect/empty password")
    @Description("Check for login courier in system with incorrect/empty password")
    public void loginCourierIncorrectPassword() {
        CourierCreate courierCreate = new CourierCreate("ninja","");
        reqSpec
                        .body(courierCreate)
                        .when()
                        .post(LOGIN_URL)
                        .then().log().all()
                        .assertThat().statusCode(400)
                        .body(equalTo(login_error_400));
    }
}
