import java.util.Iterator;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Hello wordl!");
        ArbolBinarioBusqueda<Integer> arbolBinario = new ArbolBinarioBusqueda<>();
        arbolBinario.agrega(4);
        arbolBinario.agrega(7);
        arbolBinario.agrega(3);
        arbolBinario.agrega(6);
        arbolBinario.agrega(8);
        arbolBinario.agrega(9);
        arbolBinario.agrega(0);
        arbolBinario.agrega(2);
        arbolBinario.agrega(5);
        arbolBinario.agrega(8);
        arbolBinario.agrega(1);

        System.out.println(arbolBinario);
        System.out.println(" la altura del arbol es: " + arbolBinario.altura());
        System.out.println(arbolBinario.inOrden());
        arbolBinario.elimina(3);
        System.out.println(arbolBinario);

    }
}
