package mx.unam.ciencias.edd;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello wordl!");
        ArbolBinarioBusqueda<Integer> arbolBinario = new ArbolBinarioBusqueda<>();
        arbolBinario.agrega(15);
        arbolBinario.agrega(16);
        arbolBinario.agrega(7);
        arbolBinario.agrega(17);
        arbolBinario.agrega(9);
        arbolBinario.agrega(13);
        arbolBinario.agrega(10);
        arbolBinario.agrega(12);
        arbolBinario.agrega(9);
        arbolBinario.elimina(9);
        System.out.println(arbolBinario);
        System.out.println(" la altura del arbol es: " + arbolBinario.altura());
        System.out.println(arbolBinario.inOrden());
        System.out.println(arbolBinario.contiene(19));

        Iterator iterator = arbolBinario.iterator();
        System.out.println("Iterador");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
