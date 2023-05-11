package tech.api.stepdefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;
import tech.api.rest.ServiceApiTests;
import tech.api.utils.ConstantesCampos;
import tech.api.utils.ConstantesStep;

import static org.hamcrest.Matchers.is;

public class ListarSteps {

    @Autowired
    ServiceApiTests segurosService;
    @Autowired
    ConstantesStep constantesStep;
    Integer codClient_2;
    @Dado("que envie request com user valido")
    public void queEnvieRequestComUserValido() {
       codClient_2 = ConstantesCampos.CODIGO_CLIENT_2;
    }

    @Quando("eu executo a listagem de todos users")
    public void euExecutoAListagemDeTodosUsers() {
        constantesStep.setResponse(segurosService.doListarAllUsers());

    }

    @Quando("eu executo a listagem dos users por IdCliente")
    public void euExecutoAListagemDosUsersPorIdCliente() {
        constantesStep.setResponse(segurosService.doListarSingleUser(codClient_2));
    }

    @E("listar os dados do usuario com sucesso")
    public void listarOsDadosDoUsuarioComSucesso() {
        constantesStep.getResponse().assertThat().body(ConstantesCampos.DATA_ID,
        is(ConstantesCampos.CODIGO_CLIENT_2));

    }

}
