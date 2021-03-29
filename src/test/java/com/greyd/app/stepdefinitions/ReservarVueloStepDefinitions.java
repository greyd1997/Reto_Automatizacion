package com.greyd.app.stepdefinitions;

import com.greyd.app.steps.Busqueda;
import com.greyd.app.steps.Home;
import com.greyd.app.steps.SuprimirCostos;
import com.greyd.app.steps.Validacion;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class ReservarVueloStepDefinitions {
    //Instancio WebDriver
    ChromeOptions op = new ChromeOptions();
    WebDriver driver = new ChromeDriver(op);
    Home home = new Home();
    Busqueda bus = new Busqueda();
    SuprimirCostos costos = new SuprimirCostos();
    Validacion val = new Validacion();
    int precioini;
    int finalPrice;

    @Given("^quiero ingresar a la pagina para buscar un vuelo$")
    //Ingreso al sitio Web
    public void ingresarAPagina() {

        home.abrirSitio("https://www.vivaair.com/co/es", driver);
    }


    @When("^ingreso los datos para buscar y selecciono el mas barato$")
    public void ingresarDatosBusqueda() throws InterruptedException {

        home.IngresoDatos(driver);


        bus.BusquedaBarata(driver);


        precioini=bus.BoldBarato(driver, precioini);


        bus.continuar(driver);


        costos.cancelarServicios(driver);

        finalPrice = costos.transformacion(driver, finalPrice);




    }

    @Then("^deberia poder continuar con el vuelo mas barato$")
    public void continuarVueloMasBarato() throws InterruptedException {

        val.confirmacionPrecio(precioini,finalPrice);
        home.finalizar(driver);
    }


}
