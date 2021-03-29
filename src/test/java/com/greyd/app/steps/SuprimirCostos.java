package com.greyd.app.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SuprimirCostos {

    public void cancelarServicios(WebDriver driver) throws InterruptedException {
        //Cancelo los servicios que generan costos adicionales
        driver.findElement(By.xpath("//span[contains(text(), 'No, gracias')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(), 'S')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(), 'No, gracias')]")).click();
        Thread.sleep(2000);
        List<WebElement> switches = driver.findElements(By.xpath("//div[@class='service-toggle-switch']"));
        Thread.sleep(2000);
        for (int i = 0; i < switches.size(); i++) {
            switches.get(i).click();
        }
        driver.findElement(By.xpath("//span[@class='text' and contains(text(), 'P')]")).click();
    }
    public int transformacion(WebDriver driver, int pfinal)
    {
        //Obtengo el precio total de la compra del tickete
        WebElement preciofinal = driver.findElement(By.xpath("//span[@class='price']"));

        //Transformo el precio a Integer
        String pre = preciofinal.getText();
        System.out.print(pre);
        pre= pre.replace("Total: COP ","");
        System.out.print("\n");
        pre= pre.replace(",","");
        System.out.print(pre);
        pfinal = Integer.parseInt(pre);
        return pfinal;
    }
}
