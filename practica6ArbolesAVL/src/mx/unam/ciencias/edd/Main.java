package mx.unam.ciencias.edd;

import mx.unam.ciencias.edd.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello wordl!");
        ArbolAVL<Integer> arbolBinario = new ArbolAVL<>();
        arbolBinario.agrega(5);
        System.out.println(arbolBinario.altura());
        arbolBinario.agrega(3);
        System.out.println(arbolBinario.altura());
        arbolBinario.agrega(7);
        arbolBinario.agrega(8);
        arbolBinario.agrega(9);
        System.out.println(arbolBinario);
        System.out.println(" la altura del arbol es: " + arbolBinario.altura());
        System.out.println(arbolBinario.inOrden());
        System.out.println(arbolBinario.contiene(19));

    }
}
