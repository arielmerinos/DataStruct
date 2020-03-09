import java.util.List;

public class Main {
    public static void main(String[] args) {
        Lista<String> list = new Lista<>();

        list.agregar("hola");
        list.agregar("mundo");
        list.agregar("undo");
        list.agregar("bjork");
        list.agregar("ariel");
        list.agregar("nice");

        System.out.println(list);
        list = list.mergesort(list);
        System.out.println(list);

        Lista<Integer> numeritos = new Lista<>();
        numeritos.agregar(23);
        numeritos.agregar(2);
        numeritos.agregar(1);
        numeritos.agregar(3);
        numeritos.agregar(3);
        numeritos.agregar(323);
        numeritos.agregar(43);
        System.out.println(numeritos);
        numeritos = numeritos.mergesort(numeritos);
        System.out.println(numeritos);
    }
}
