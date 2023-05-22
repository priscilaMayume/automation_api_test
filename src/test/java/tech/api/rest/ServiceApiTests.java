package tech.api.rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tech.api.entities.request.ValidationEmailRequest;
import tech.api.entities.request.CreateUserRequest;
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

    public ValidatableResponse doCreateUser(CreateUserRequest createUserRequest) {

        ValidatableResponse response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(createUserRequest)
                .when()
                .post(urlBase + ConstantesPath.USERS_PATH)
                .then().log().all();
        return response;
    }

    public ValidatableResponse doUpdatePutUser(CreateUserRequest createUserRequest) {

        ValidatableResponse response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(createUserRequest)
                .when()
                .put(urlBase + ConstantesPath.SINGLE_USER_PATH)
                .then().log().all();
        return response;
    }

    public ValidatableResponse doUpdatePatchUser(CreateUserRequest createUserRequest) {

        ValidatableResponse response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(createUserRequest)
                .when()
                .patch(urlBase + ConstantesPath.SINGLE_USER_PATH)
                .then().log().all();
        return response;
    }

    public ValidatableResponse doDeleteSingleUser(Integer idCLient) {

        ValidatableResponse response = RestAssured.given()
                .when()
                .delete(urlBase + ConstantesPath.SINGLE_USER_PATH + idCLient)
                .then().log().all();
        return response;
    }

    public ValidatableResponse doValidationEmail(ValidationEmailRequest createEmailRequest) {

        ValidatableResponse response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(createEmailRequest)
                .when()
                .post(urlBase + ConstantesPath.REGISTER_PATH)
                .then().log().all();
        return response;
    }

    public ValidatableResponse doValidationEmailInvalid(String createEmailRequest) {

        ValidatableResponse response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(createEmailRequest)
                .when()
                .post(urlBase + ConstantesPath.REGISTER_PATH)
                .then().log().all();
        return response;
    }

    public ValidatableResponse doCreateLogin(ValidationEmailRequest createEmailRequest) {

        ValidatableResponse response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(createEmailRequest).log().all()
                .when()
                .post(urlBase  + ConstantesPath.LOGIN_PATH)
                .then().log().all();
        return response;
    }

    public ValidatableResponse doCreateLoginInvalid(String createEmailRequest) {

        ValidatableResponse response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"" + createEmailRequest + "\"}").log().all()
                .when()
                .post(urlBase + ConstantesPath.LOGIN_PATH)
                .then().log().all();
        return response;
    }

}
