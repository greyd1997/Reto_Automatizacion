package com.greyd.app.steps;

import com.greyd.app.funcionesgenericas.Funcion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Busqueda {
    Funcion fun = new Funcion();
    public void BusquedaBarata(WebDriver driver)
    {
        //Agarro los de precios y los ingreso a una Lista
        List<WebElement> listaPrecios = driver.findElements(By.xpath("//div[@class='from-price']"));

        //Imprimo los precios obtenidos en consola
        fun.imprimirArreglo(listaPrecios);

        //Transformo los precios a enteros y los pongo en un arreglo de enteros, luego los imprimo en consola
        ArrayList<Integer> precios = new ArrayList<>();
        fun.StringAInt(listaPrecios,precios);
        fun.imprimirArregloInt(precios);
        int precioMasBarato = precios.get(0);
        int posicion = 0;

        //obtengo la posicion del precio entero mas barato que sera la misma posicion que Lista de WebElement
        posicion= fun.obtenerPos(precios,precioMasBarato);
        System.out.print("mas barato: " + precioMasBarato);
        System.out.print("\n");
        System.out.print(listaPrecios.get(posicion).getText());
        System.out.print("\n");
        String precio = listaPrecios.get(posicion).getText();

        //Identifico el elemento de la pagina con el mismo precio y doy click
        driver.findElement(By.xpath("//div[@class='from-price' and contains(text(), '" + precio + "')]")).click();
    }

    public int BoldBarato(WebDriver driver, int precioini) throws InterruptedException {
        //Selecciono la opcion mas barata referente a paquetes de viaje
        List<WebElement> listaPreciosBold = driver.findElements(By.xpath("//div[@class='price bold']"));
        fun.imprimirArreglo(listaPreciosBold);
        ArrayList<Integer> preciosBold = new ArrayList<>();
        fun.StringAInt(listaPreciosBold,preciosBold);
        fun.imprimirArregloInt(preciosBold);
        int precioMasBaratoBold = preciosBold.get(0);
        precioini=precioMasBaratoBold;
        int posicionBold = 0;
        posicionBold = fun.obtenerPos(preciosBold,precioMasBaratoBold);
        System.out.print("mas barato Bold: " + precioMasBaratoBold);
        System.out.print("\n");
        System.out.print(listaPreciosBold.get(posicionBold).getText());
        String precioBold = listaPreciosBold.get(posicionBold).getText();
        driver.findElement(By.xpath("//div[@class='price bold' and contains(text(), '" + precioBold + "')]")).click();
        Thread.sleep(8000);
        return precioini;
    }
    public void continuar(WebDriver driver) throws InterruptedException {
        //Doy click en continuar y selecciono que no al resto de paquetes
        driver.findElement(By.xpath("//span[contains(text(), 'Continuar')]")).click();
        Thread.sleep(8000);
    }


}
