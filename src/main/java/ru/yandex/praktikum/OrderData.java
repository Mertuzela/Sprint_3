package ru.yandex.praktikum;

import courier.RestAssuredClient;
import io.restassured.response.ValidatableResponse;

public class OrderData extends RestAssuredClient {


    public ValidatableResponse orderCreate(String[] color) {
        return reqSpec
                .body(color)
                .when()
                .post(ORDERS_URL)
                .then().log().all();
    }
}
