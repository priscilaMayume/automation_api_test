package tech.api.stepdefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;
import tech.api.entities.request.ValidationEmailRequest;
import tech.api.rest.ServiceApiTests;
import tech.api.utils.ConstantesCampos;
import tech.api.utils.ConstantesStep;

public class ValidationEmailSteps {

    @Autowired
    ServiceApiTests serviceApiTests;
    @Autowired
    ConstantesStep constantesStep;

    @Dado("que possua {string} e {string}")
    public void quePossuaE(String email, String password) {
        ValidationEmailRequest validationEmailRequest = new ValidationEmailRequest();
        validationEmailRequest.setEmail(email);
        validationEmailRequest.setPassword(password);

        constantesStep.setValidationEmailRequest(validationEmailRequest);

    }

    @Quando("eu executo a validacao de um email")
    public void euExecutoAValidacaoDeUmEmail() {
        constantesStep.setResponse(serviceApiTests.doValidationEmail(constantesStep.getValidationEmailRequest()));
    }

    @Quando("eu executo a validacao de um email sem password")
    public void euExecutoAValidacaoDeUmEmailSemPassword() {
        constantesStep.setResponse(serviceApiTests.doValidationEmailInvalid(ConstantesCampos.EMAIL));
    }

}
