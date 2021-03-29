package com.greyd.app.steps;

import org.junit.Assert;

public class Validacion {

    public void confirmacionPrecio(int pIni,int pFinal) throws InterruptedException {
        //Comparo el precio seleccionado de la lista de vuelos con el precio final para verificar que la prueba fue exitosa
        System.out.print("\n");
        System.out.print(pIni);
        System.out.print("\n");
        System.out.print(pFinal);
        Assert.assertEquals(pIni, pFinal);
        Thread.sleep(3000);
    }
}
