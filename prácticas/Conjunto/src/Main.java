public class Main {
    public static void main(String[] args) {
        Conjunto<String> A = new Conjunto<>();

        A.addItem("a");
        A.addItem("b");
        A.addItem("c");
        A.addItem("d");
        A.addItem("e");
        A.addItem("f");

        Conjunto<String> B = new Conjunto<>();

        B.addItem("a");
        B.addItem("c");
        B.addItem("e");
        B.addItem("h");

        Conjunto<String> C = new Conjunto<>();
        C.addItem("a");
        C.addItem("c");

        System.out.println("Este es el conjunto A " +A);
        System.out.println("Este es el conjunto B " + B);
        System.out.println("Este es el conjunto C " + C);
        System.out.println("Esta es la interseccion"+A.intersection(B));
        System.out.println("Esta es la diferencia " + A.diff(B));
        System.out.println("Esto es la diferencia simetrica "+ A.simetricDiff(B));
        System.out.println("C es subconjunto de A " + A.subSet(C) );
        A.throwAll();

        System.out.println(A);
        A.addItem("H");
        System.out.println(A);




    }
}
