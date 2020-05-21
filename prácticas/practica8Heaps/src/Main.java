public class Main {
    static Integer[] arreglo = new Integer[8];


    public static void main(String[] args) {
        MinHeap<Integer> integers = new MinHeap<>();
        integers.agrega(650);
        System.out.println(integers);
        integers.agrega(87);
        System.out.println(integers);
        integers.agrega(3);
        System.out.println(integers);
        integers.agrega(1);
        integers.agrega(9);
        integers.agrega(8);
        System.out.println(integers);

        System.out.println(integers.elimina());
        System.out.println(integers);
        System.out.println(integers.elimina());
        System.out.println(integers);
    }
}
