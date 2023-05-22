package tech.api.stepdefinitions;


import io.cucumber.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;
import tech.api.rest.ServiceApiTests;
import tech.api.utils.ConstantesStep;

public class ListUserDelaySteps {

    @Autowired
    ServiceApiTests serviceApiTests;
    @Autowired
    ConstantesStep constantesStep;

    @Quando("eu executo a listagem com delay de todos users")
    public void euExecutoAListagemComDelayDeTodosUsers() {
        constantesStep.setResponse(serviceApiTests.doListarAllDelay());
    }

}
