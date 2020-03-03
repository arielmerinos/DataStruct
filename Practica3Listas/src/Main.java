public class Main {
    public static void main(String[] args) {
        Lista<String> list = new Lista<>();

        list.agregar("Hola");
        list.agregar("Mundo");
        list.agregar("undo");
        list.agregar("bjork");
        list.agregar("ariel");
        list.agregar("nice");

        System.out.println(list);

    }
}
