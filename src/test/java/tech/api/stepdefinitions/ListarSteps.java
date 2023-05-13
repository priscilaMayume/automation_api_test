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
    Integer codClient;

    @Dado("que envie request com user valido")
    public void queEnvieRequestComUserValido() {
        codClient = ConstantesCampos.CODIGO_CLIENT_2;
    }

    @Dado("que envie request com user invalido")
    public void queEnvieRequestComUserInvalido() {
        codClient = ConstantesCampos.CODIGO_NEXISTENTE;
    }

    @Quando("eu executo a listagem de todos users")
    public void euExecutoAListagemDeTodosUsers() {
        constantesStep.setResponse(segurosService.doListarAllUsers());

    }

    @Quando("eu executo a listagem dos users por IdCliente")
    public void euExecutoAListagemDosUsersPorIdCliente() {
        constantesStep.setResponse(segurosService.doListarSingleUser(codClient));
    }

    @Quando("eu executo a listagem dos recursos")
    public void euExecutoAListagemDosRecursos() {
        constantesStep.setResponse(segurosService.doListarAllResources());
    }

    @Quando("eu executo a listagem dos recursos por IdCliente")
    public void euExecutoAListagemDosRecursosPorIdCliente() {
        constantesStep.setResponse(segurosService.doListarSingleResources(codClient));
    }

    @E("listar os dados do usuario com sucesso")
    public void listarOsDadosDoUsuarioComSucesso() {
        constantesStep.getResponse().assertThat().body(ConstantesCampos.DATA_ID, is(ConstantesCampos.CODIGO_CLIENT_2));

    }

    @E("listar todos os recursos com sucesso")
    public void listarTodosOsRecursosComSucesso() {
        constantesStep.getResponse().assertThat().body(ConstantesCampos.DATA_ID_0, is(ConstantesCampos.CODIGO_CLIENT_1));
        constantesStep.getResponse().assertThat().body(ConstantesCampos.DATA_ID_1, is(ConstantesCampos.CODIGO_CLIENT_2));

        constantesStep.getResponse().assertThat().body(ConstantesCampos.DATA_NAME_0, is(ConstantesCampos.NAME_CERULEAN));
        constantesStep.getResponse().assertThat().body(ConstantesCampos.DATA_NAME_1, is(ConstantesCampos.NAME_FUCHSIA));
    }

    @E("listar todos os recursos do usuario com sucesso")
    public void listarTodosOsRecursosDoUsuarioComSucesso() {
        constantesStep.getResponse().assertThat().body(ConstantesCampos.DATA_ID, is(ConstantesCampos.CODIGO_CLIENT_2));
        constantesStep.getResponse().assertThat().body(ConstantesCampos.DATA_NAME, is(ConstantesCampos.NAME_FUCHSIA));
    }

}
