package tech.api.stepdefinitions;

import io.cucumber.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;
import tech.api.rest.ServiceApiTests;
import tech.api.utils.ConstantesStep;

import static org.hamcrest.Matchers.is;

public class DeletarUsuariosSteps {

    @Autowired
    ServiceApiTests segurosService;
    @Autowired
    ConstantesStep constantesStep;
    Integer codClient;

    @Quando("eu executo a delecao de um users por IdCliente")
    public void euExecutoADelecaoDeUmUsersPorIdCliente() {
        constantesStep.setResponse(segurosService.doDeleteSingleUser(codClient));
    }

}
