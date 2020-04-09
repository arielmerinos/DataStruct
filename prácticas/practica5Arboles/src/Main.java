public class Main {
    public static void main(String[] args) {
        System.out.println("Hello wordl!");
        ArbolBinario<Integer> arbolBinario = new ArbolBinarioBusqueda<>();
        arbolBinario.agrega(9);
        arbolBinario.agrega(7);
        System.out.println(arbolBinario);
        System.out.println(" la altura del arbol es: " + arbolBinario.altura());
        System.out.println(arbolBinario.preOrden());
    }
}
