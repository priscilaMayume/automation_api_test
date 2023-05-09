package tech.api.runner;

import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ActiveProfiles;
import org.testng.annotations.DataProvider;
import tech.api.ServiceApplication;

@Primary
@CucumberContextConfiguration
@ActiveProfiles(profiles = "test")
@SpringBootTest(classes = {ServiceApplication.class, ServiceApplicationTests.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberOptions(
        plugin = {"pretty","html:reportes/cucumber-reports.html"},
        features = {"src/test/resources/features"},
        glue = {"tech.api.stepdefinitions", "tech.api.runner"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
//        tags = "@Pri",
        dryRun = false
)

public class ServiceApplicationTests extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }

}