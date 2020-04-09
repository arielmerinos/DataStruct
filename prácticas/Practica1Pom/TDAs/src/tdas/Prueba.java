/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdas;

/**
 *
 * @author kamerinop
 */
public class Prueba {

    int[] arreglo;
    int tamano;
    
    int resultado;
    
    public Prueba(int tamanio){
        this.tamano = tamanio;
        arreglo = new int[tamanio];
        arreglo = llenar(arreglo);
    }
    
    public int[] llenar(int[] arrreglo){
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = i;
        }
    return arreglo;
    }
}
