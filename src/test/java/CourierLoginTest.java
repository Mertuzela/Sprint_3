//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import courier.RestAssuredClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Test;

public class CourierLoginTest extends RestAssuredClient {
    public CourierLoginTest() {
    }

    @Test
    @DisplayName("Login courier")
    @Description("Check for login courier in system with valid data")
    public void loginCourier() {
        CourierCreate courierCreate = new CourierCreate("ninja", "1234");
        ((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((Response)this.reqSpec.body(courierCreate).when().post("/courier/login", new Object[0])).then()).log().all()).assertThat()).body("id", CoreMatchers.notNullValue(), new Object[0])).and()).statusCode(200);
    }

    @Test
    @DisplayName("Login courier with incorrect login")
    @Description("Check for login courier in system with incorrect login")
    public void loginCourierIncorrectLogin() {
        CourierCreate courierCreate = new CourierCreate("ninj1a", "1234");
        ((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((Response)this.reqSpec.body(courierCreate).when().post("/courier/login", new Object[0])).then()).log().all()).assertThat()).statusCode(404)).body(CoreMatchers.equalTo("{\"code\":404,\"message\":\"Учетная запись не найдена\"}"), new Matcher[0]);
    }

    @Test
    @DisplayName("Login courier with incorrect/empty password")
    @Description("Check for login courier in system with incorrect/empty password")
    public void loginCourierIncorrectPassword() {
        CourierCreate courierCreate = new CourierCreate("ninja", "");
        ((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((Response)this.reqSpec.body(courierCreate).when().post("/courier/login", new Object[0])).then()).log().all()).assertThat()).statusCode(400)).body(CoreMatchers.equalTo("{\"code\":400,\"message\":\"Недостаточно данных для входа\"}"), new Matcher[0]);
    }
}
