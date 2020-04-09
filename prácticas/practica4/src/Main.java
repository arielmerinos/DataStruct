public class Main {
    public static void main(String[] args) {
        Pila<String> pila = new Pila();
        pila.agrega("uno");
        pila.agrega("dos");
        pila.agrega("tres");
        System.out.println(pila);

        String[] elem = new String[3];
        elem[0] = "Hola";
        elem[1] = "Mundo";
        elem[2] = "gege";

        Pila<String> arreglo = new Pila<>(elem);
        Pila<String> regresiva = new Pila<>((Coleccionable<String>) pila);
        System.out.println(arreglo);
        System.out.println(regresiva);

        Cola<String> cola = new Cola<>();

        cola.agrega("Un elemento");
        cola.agrega("Segundo elemento");
        cola.agrega("Tercer elemento");
        System.out.println("Aqui comienza la cola\n" + cola);
        cola.elimina("Segundo elemento");
        System.out.println(cola);
    }
}
