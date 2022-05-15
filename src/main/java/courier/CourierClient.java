package courier;

import static org.hamcrest.CoreMatchers.equalTo;

public class CourierClient extends RestAssuredClient{

public boolean create(Courier courier) {
   return reqSpec
            .body(courier)
            .when()
            .post(REGISTRATION)
            .then().log().all()
            .assertThat()
            .statusCode(201)
           .and()
           .body(equalTo(createCourier_ok_201))
            .extract()
            .path("ok");
}
    public boolean createSameCourier(Courier courier) {
      reqSpec
                .body(courier)
                .when()
                .post(REGISTRATION);
         reqSpec
                 .body(courier)
                 .when()
                 .post(REGISTRATION)
                 .then().log().all()
                 .assertThat().statusCode(409)
                .and()
                .body(equalTo(createCourier_error_409));
         return true;
    }

public boolean createWithEmptyBody() {
         reqSpec
            .body("")
            .when()
            .post(REGISTRATION)
            .then().log().all()
            .assertThat().statusCode(400)
            .body(equalTo(createCourier_error_400));
        return true;
    }

    public boolean createWithoutPassword(Courier courier) {
        reqSpec
                .body(courier)
                .when()
                .post(REGISTRATION)
                .then().log().all()
                .assertThat().statusCode(400)
                .body(equalTo(createCourier_error_400));
        return true;
    }

public int login(CourierCredentials creds) {
  return reqSpec
           .body(creds)
           .when()
           .post(LOGIN_URL)
           .then()
           .assertThat()
           .statusCode(200)
           .extract()
           .path("id");
}

public void delete(int courierId) {
    reqSpec.pathParam("courierId", courierId)
            .when()
            .delete(COURIER)
            .then().log().all()
            .assertThat()
            .statusCode(200);
    }
}