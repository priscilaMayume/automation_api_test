package tech.api.rest;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tech.api.utils.ConstantesPath;

@Component
public class ServiceApiTests {

    @Getter
    @Value("${header.url.base}")
    private String urlBase;

    public ValidatableResponse doListarAllUsers() {

        ValidatableResponse response = RestAssured.given()
                .when()
                .get(urlBase + ConstantesPath.USER_ALL_PATH)
                .then().log().all();
        return response;
    }
}
