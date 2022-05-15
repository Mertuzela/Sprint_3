//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package courier;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;

public class CourierClient extends RestAssuredClient {
    public CourierClient() {
    }

    public boolean create(Courier courier) {
        return (Boolean)((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((Response)this.reqSpec.body(courier).when().post("/courier", new Object[0])).then()).log().all()).assertThat()).statusCode(201)).and()).body(CoreMatchers.equalTo("{\"ok\":true}"), new Matcher[0])).extract().path("ok", new String[0]);
    }

    public boolean createSameCourier(Courier courier) {
        this.reqSpec.body(courier).when().post("/courier", new Object[0]);
        ((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((Response)this.reqSpec.body(courier).when().post("/courier", new Object[0])).then()).log().all()).assertThat()).statusCode(409)).and()).body(CoreMatchers.equalTo("{\"code\":409,\"message\":\"Этот логин уже используется. Попробуйте другой.\"}"), new Matcher[0]);
        return true;
    }

    public boolean createWithEmptyBody() {
        ((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((Response)this.reqSpec.body("").when().post("/courier", new Object[0])).then()).log().all()).assertThat()).statusCode(400)).body(CoreMatchers.equalTo("{\"code\":400,\"message\":\"Недостаточно данных для создания учетной записи\"}"), new Matcher[0]);
        return true;
    }

    public boolean createWithoutPassword(Courier courier) {
        ((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((Response)this.reqSpec.body(courier).when().post("/courier", new Object[0])).then()).log().all()).assertThat()).statusCode(400)).body(CoreMatchers.equalTo("{\"code\":400,\"message\":\"Недостаточно данных для создания учетной записи\"}"), new Matcher[0]);
        return true;
    }

    public int login(CourierCredentials creds) {
        return (Integer)((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((Response)this.reqSpec.body(creds).when().post("/courier/login", new Object[0])).then()).assertThat()).statusCode(200)).extract().path("id", new String[0]);
    }

    public void delete(int courierId) {
        ((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((Response)this.reqSpec.pathParam("courierId", courierId).when().delete("/courier/{courierId}", new Object[0])).then()).log().all()).assertThat()).statusCode(200);
    }
}
