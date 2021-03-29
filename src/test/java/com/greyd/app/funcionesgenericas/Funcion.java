package com.greyd.app.funcionesgenericas;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Funcion {

    public int obtenerPos(ArrayList<Integer> arreglo, int precioBarato)
    {
        int pos=0;
        for (int i = 0; i < arreglo.size(); i++) {
            if (precioBarato > arreglo.get(i)) {
                precioBarato = arreglo.get(i);
                System.out.print("precio a comparar: " + arreglo.get(i));
                System.out.print("\n");
                pos = i;
            }
        }
        return pos;
    }
    public void imprimirArreglo(List<WebElement> arreglo)
    {
        for (int i = 0; i < arreglo.size(); i++) {
            System.out.print(arreglo.get(i).getText());
            System.out.print("\n");
        }
    }
    public void imprimirArregloInt(List<Integer> arreglo)
    {
        for (int i = 0; i < arreglo.size(); i++) {
            System.out.print(arreglo.get(i));
            System.out.print("\n");
        }
    }
    public void StringAInt(List<WebElement> arregloWeb, ArrayList<Integer> arregloInt)
    {
        for (int i = 0; i < arregloWeb.size(); i++) {
            String pr = arregloWeb.get(i).getText().replace("COP ", "");
            String pr2 = pr.replace(",", "");
            int pr3 = Integer.parseInt(pr2);
            arregloInt.add(pr3);
        }
    }
}
