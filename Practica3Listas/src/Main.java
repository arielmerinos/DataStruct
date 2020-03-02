public class Main {
    public static void main(String[] args) {
        Lista<String> list = new Lista<>();

        list.agregar("Hola");
        list.agregar("Mundo");
        list.agregar("Mundo");
        list.agregar("Mundo");
        list.agregar("Mundo");
        list.agregar("Mundo");
        System.out.println(list);
        list.eliminar("Hola");
        System.out.println(list);
    }

}
