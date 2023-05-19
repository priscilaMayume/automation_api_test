package tech.api.stepdefinitions;

import io.cucumber.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;
import tech.api.rest.ServiceApiTests;
import tech.api.utils.ConstantesStep;

public class DeleteUserSteps {

    @Autowired
    ServiceApiTests serviceApiTests;
    @Autowired
    ConstantesStep constantesStep;
    Integer codClient;

    @Quando("eu executo a delecao de um users por IdCliente")
    public void euExecutoADelecaoDeUmUsersPorIdCliente() {
        constantesStep.setResponse(serviceApiTests.doDeleteSingleUser(codClient));
    }

}
