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
                .get(urlBase + ConstantesPath.USERS_PATH)
                .then().log().all();
        return response;
    }

    public ValidatableResponse doListarSingleUser(Integer idCLient) {

        ValidatableResponse response = RestAssured.given()
                .when()
                .get(urlBase + ConstantesPath.SINGLE_USER_PATH + idCLient)
                .then().log().all();
        return response;
    }

    public ValidatableResponse doListarAllResources() {

        ValidatableResponse response = RestAssured.given()
                .when()
                .get(urlBase + ConstantesPath.LIST_RESOURCE_PATH)
                .then().log().all();
        return response;
    }

    public ValidatableResponse doListarSingleResources(Integer idCLient) {

        ValidatableResponse response = RestAssured.given()
                .when()
                .get(urlBase + ConstantesPath.SINGLE_RESOURCE_PATH + idCLient)
                .then().log().all();
        return response;
    }
}
