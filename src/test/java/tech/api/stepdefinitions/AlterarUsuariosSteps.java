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

public class AlterarUsuariosSteps {

    @Autowired
    ServiceApiTests segurosService;
    @Autowired
    ConstantesStep constantesStep;

    @Dado("que possua {string} e {string} validos para alteracao PUT")
    public void quePossuaEValidosParaAlteracaoPUT(String name, String job) {
        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setName(name);
        userRequest.setJob(job);

        constantesStep.setCreateUserRequest(userRequest);
    }

    @Dado("que possua {string} e {string} validos para alteracao PATCH")
    public void quePossuaEValidosParaAlteracaoPATCH(String name_patch, String job_patch) {
        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setName(name_patch);
        userRequest.setJob(job_patch);

        constantesStep.setCreateUserRequest(userRequest);
    }

    @Quando("eu executo alterar PUT um user")
    public void euExecutoAlterarPUTUmUser() {
        constantesStep.setResponse(segurosService.doUpdatePutUser(constantesStep.getCreateUserRequest()));
    }

    @Quando("eu executo alterar um user")
    public void euExecutoAlterarUmUser() {
        constantesStep.setResponse(segurosService.doUpdatePatchUser(constantesStep.getCreateUserRequest()));

    }

    @E("alterar PUT usuario com sucesso")
    public void alterarPUTOUsuarioComSucesso() {
        constantesStep.getResponse().assertThat().body(ConstantesCampos.NAME, is(ConstantesCampos.NAME_MORPHEUS));
        constantesStep.getResponse().assertThat().body(ConstantesCampos.JOB, is(ConstantesCampos.JOB_BDA));

    }

    @E("alterar PATCH usuario com sucesso")
    public void alterarPATCHUsuarioComSucesso() {
        constantesStep.getResponse().assertThat().body(ConstantesCampos.NAME, is(ConstantesCampos.NAME_PRISCILA));
        constantesStep.getResponse().assertThat().body(ConstantesCampos.JOB, is(ConstantesCampos.JOB_ANALIST));
    }

}
