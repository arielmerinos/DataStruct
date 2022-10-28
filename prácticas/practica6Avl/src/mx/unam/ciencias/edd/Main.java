package mx.unam.ciencias.edd;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello wordl!");
        ArbolAVL<Integer> arbolBinario = new ArbolAVL<>();
        arbolBinario.agrega(8);
        arbolBinario.agrega(1);
        arbolBinario.agrega(3);
        arbolBinario.agrega(7);
        arbolBinario.agrega(6);
        System.out.println(arbolBinario);

    }
}
