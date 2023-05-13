package tech.api.stepdefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;
import tech.api.entities.request.CreateUserRequest;
import tech.api.rest.ServiceApiTests;
import tech.api.utils.ConstantesCampos;
import tech.api.utils.ConstantesStep;

import static org.hamcrest.Matchers.is;

public class CriarUsuariosSteps {

    @Autowired
    ServiceApiTests segurosService;
    @Autowired
    ConstantesStep constantesStep;

    @Dado("que possua {string} e {string} validos")
    public void quePossuaEValidos(String name, String job) {
        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setName(name);
        userRequest.setJob(job);

        constantesStep.setCreateUserRequest(userRequest);
    }

    @Quando("eu executo a criacao de um user")
    public void euExecutoACriacaoDeUmUser() {
        constantesStep.setResponse(segurosService.doCreateUser(constantesStep.getCreateUserRequest()));
    }

    @E("criar o usuario com sucesso")
    public void criarOUsuarioComSucesso() {
        constantesStep.getResponse().assertThat().body(ConstantesCampos.NAME, is(ConstantesCampos.NAME_MORPHEUS));
        constantesStep.getResponse().assertThat().body(ConstantesCampos.JOB, is(ConstantesCampos.JOB_LEADER));

    }

}
