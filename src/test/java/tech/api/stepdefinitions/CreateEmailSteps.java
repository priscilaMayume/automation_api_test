package tech.api.stepdefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;
import tech.api.entities.request.CreateEmailRequest;
import tech.api.rest.ServiceApiTests;
import tech.api.utils.ConstantesCampos;
import tech.api.utils.ConstantesStep;

public class CreateEmailSteps {

    @Autowired
    ServiceApiTests serviceApiTests;
    @Autowired
    ConstantesStep constantesStep;

    @Dado("que possua {string} e {string}")
    public void quePossuaE(String email, String password) {
        CreateEmailRequest createEmailRequest = new CreateEmailRequest();
        createEmailRequest.setEmail(email);
        createEmailRequest.setPassword(password);

        constantesStep.setCreateEmailRequest(createEmailRequest);

    }

    @Quando("eu executo a criacao de um email")
    public void euExecutoACriacaoDeUmEmail() {
        constantesStep.setResponse(serviceApiTests.doCreateEmail(constantesStep.getCreateEmailRequest()));
    }

    @Quando("eu executo a criacao de um email sem password")
    public void euExecutoACriacaoDeUmEmailSemPassword() {
        constantesStep.setResponse(serviceApiTests.doCreateEmailInvalid(ConstantesCampos.EMAIL));
    }

}
