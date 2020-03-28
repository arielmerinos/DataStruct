package sample;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(algoritmoEcuclides(30,42));
    }
    public static int algoritmoEcuclides(int a, int b){
        if (a == 0){
            return b;
        }
        return algoritmoEcuclides(  b%a, a);
    }
}

