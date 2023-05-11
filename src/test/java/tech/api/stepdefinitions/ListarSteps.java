package tech.api.stepdefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;
import tech.api.rest.ServiceApiTests;
import tech.api.utils.ConstantesStep;

public class ListarSteps {

    @Autowired
    ServiceApiTests segurosService;
    @Autowired
    ConstantesStep constStep;

    @Quando("eu executo a listagem de todos users")
    public void euExecutoAListagemDeTodosUsers() {
        constStep.setResponse(segurosService.doListarAllUsers());


    }
}
