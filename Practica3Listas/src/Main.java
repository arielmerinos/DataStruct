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
        System.out.println("Cabeza: " +list.getCabeza());
        System.out.println("Cola de la lista: " +list.getCola());
        //list.eliminar("undo");
        //list.eliminar("nice");
        System.out.println(list);
        System.out.println(list.indiceDe("nice"));
        System.out.println( "Este es el get elemento" + list.getElemento(2));


        list = list.reversa();
        System.out.println("Esta es la reversa");
        System.out.println(list);
    }

}
