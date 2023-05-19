package tech.api.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tech.api.entities.request.CreateEmailRequest;
import tech.api.entities.request.CreateUserRequest;
import tech.api.entities.response.ListUserResponse;

@Data
@Component
@Scope("cucumber-glue")
public class ConstantesStep {

    private ValidatableResponse response;
    public void setResponse(ValidatableResponse response) {
        this.response = response;
    }
    public ValidatableResponse getResponse() {
        return response;
    }

    private ValidatableResponse responseTokenInvalido;
    private JsonPath responseJsonPath;
    private ListUserResponse listUserResponse;
    private CreateUserRequest createUserRequest;
    private CreateEmailRequest createEmailRequest;


}

