package com.greyd.app.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Home {

    public void abrirSitio(String url, WebDriver driver)
    {
        driver.get(url);
    }

    public void IngresoDatos(WebDriver driver) throws InterruptedException {
        //Quito Publicidad
        driver.findElement(By.id("onesignal-slidedown-cancel-button")).click();

        //Selecciono vuelo IDA
        driver.findElement(By.xpath("//span[@class='box']")).click();
        Thread.sleep(1000);

        //Ingreso los datos de Salida y LLegada
        driver.findElement(By.id("criteria-airport-select-departure-input")).clear();
        driver.findElement(By.id("criteria-airport-select-departure-input")).sendKeys("MDE" + Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.id("criteria-airport-select-destination-input")).sendKeys("BOG" + Keys.ENTER);
        Thread.sleep(1000);

        //Instancio la fecha actual
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ldt);
        driver.findElement(By.id("criteria-dates-from")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='cookie-container-content__button']")).click();

        //Sumo un dia mas al dia actual
        int dia = ldt.getDayOfMonth() + 1;
        int mes = ldt.getMonthValue();
        int anio = ldt.getYear();

        //Busco en la pagina el lugar que corresponda a la fecha obtenida
        driver.findElement(By.xpath("//td[@data-date='" + anio + "-0" + mes + "-" + dia + "']")).click();
        Thread.sleep(5000);

        //Busco vuelos una vez ingresado datos
        driver.findElement(By.id("criteria-search-button-desktop")).click();
        Thread.sleep(15000);
    }
    public void finalizar(WebDriver driver)
    {
        driver.quit();
    }


}
