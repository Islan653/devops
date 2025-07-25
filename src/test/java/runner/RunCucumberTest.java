package runner;

import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features") // Confirme que os .feature estão em src/test/resources/features
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepdefinitions") // Ou o nome completo do pacote
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@regressivos") // Só se a tag existir
@ConfigurationParameter(key = "cucumber.execution.dry-run", value = "false") // Execute os testes de verdade
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, html:target/cucumber-report.html")
@ConfigurationParameter(key = "cucumber.publish.quiet", value = "true")
public class RunCucumberTest {}
