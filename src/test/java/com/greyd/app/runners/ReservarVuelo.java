package com.greyd.app.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features ={"src/test/resources/features/reservar_vuelo.feature"},
glue = {"com.greyd.app.stepdefinitions"},
snippets = SnippetType.CAMELCASE
)
public class ReservarVuelo {

}
