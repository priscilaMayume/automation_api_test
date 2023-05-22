package tech.api.stepdefinitions;

import io.cucumber.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;
import tech.api.rest.ServiceApiTests;
import tech.api.utils.ConstantesCampos;
import tech.api.utils.ConstantesStep;

public class CreateLoginSteps {

    @Autowired
    ServiceApiTests serviceApiTests;
    @Autowired
    ConstantesStep constantesStep;

    @Quando("eu faco login")
    public void euFacoLogin() {
        constantesStep.setResponse(serviceApiTests.doCreateLogin(constantesStep.getCreateEmailRequest()));

    }

    @Quando("eu executo a criacao de um login sem password")
    public void euExecutoACriacaoDeUmLoginSemPassword() {
        constantesStep.setResponse(serviceApiTests.doCreateLoginInvalid(ConstantesCampos.EMAIL));
    }
}
