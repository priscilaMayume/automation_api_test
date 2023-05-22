package tech.api.stepdefinitions;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import tech.api.rest.ServiceApiTests;
import tech.api.utils.ConstantesCampos;
import tech.api.utils.ConstantesStep;
import tech.api.utils.Schemas;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;

public class GenericSteps {

    @Autowired
    ServiceApiTests serviceApiTests;

    @Autowired
    ConstantesStep constantesStep;

    @Entao("devo receber HttpStatus {int}")
    public void devoReceberHttpStatus(Integer httpStatus) {
        constantesStep.getResponse().assertThat().statusCode(HttpStatus.valueOf(httpStatus).value());
    }

    @E("a resposta da requisicao deve estar de acordo com o schema {string}")
    public void aRespostaDaRequisicaoDeveEstarDeAcordoComOSchema(String schema) {
        constantesStep.getResponse().body(matchesJsonSchemaInClasspath(Schemas.valueOf(schema).getPath()));
    }

    @E("a mensagem deve ser {string}")
    public void aMensagemDeveSer(String mensagem) {
        constantesStep.getResponse().assertThat().log().all().body("message", containsString(mensagem));
    }

    @E("a errorDetail deve apresentar mensagem {string}")
    public void aErrorDetailDeveApresentarMensagem(String mensagem) {
        constantesStep.getResponse().assertThat().log().all().body(ConstantesCampos.ERROR_DETAIL_MENSSAGE, containsString(mensagem));
    }

    @E("devo receber o response vazio")
    public void devoReceberOResponseVazio() {
        constantesStep.getResponse().equals(null);

    }

    @E("deve apresentar msg da ausencia do password")
    public void deveApresentarMsgDaAusenciaDoPassword() {
        constantesStep.getResponse().assertThat().log().all().body(ConstantesCampos.ERROR, containsString(ConstantesCampos.MSG_ERROR_MISSING_PASSWORD));

    }
}
