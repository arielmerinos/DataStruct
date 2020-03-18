
import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException, NoSuchMethodException {
        System.out.println("::BIENVENIDX AL RALLY::");
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        while (continuar){
            System.out.println("Ingresa la opcion deseada\n[1] Problema de Josephus\n[2] Calendarizando Cafe\n[0] Salir");
            int respuesta = sc.nextInt();
            switch (respuesta){
                case 1:
                    josephusPrint();
                    break;
                case 2:
                    cafeterosTodes();
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion ilegal, intenta de nuevo");
            }
        }

    }
    private static void josephusPrint() throws NoSuchMethodException {
        ProblemaJosephus inciso1 = new ProblemaJosephus(41,4);
        System.out.println("Esta respuesta pertenece al inciso 1");
        System.out.println(inciso1.ordenEliminacion());
        System.out.println(inciso1.posicionSegura());

        System.out.print("Ingrese el numero total de personas en el ejercito: ");
        Scanner sc = new Scanner(System.in);
        int answ = sc.nextInt();
        Random random = new Random();
        int saltos = random.nextInt(answ) +1;
        System.out.println("Esto son los pasos antes de matar: " + saltos);
        ProblemaJosephus inciso2 = new ProblemaJosephus(answ, saltos);
        inciso2.ordenEliminacion();
        boolean conti = true;
        while (conti){
            System.out.println(">:: Menu de Josephus ::<\n[1] Ver la posicion segura\n[2] Mirar la permutacion de Josephus" +
                    "\n[3] Ver como fueron muriendo los soldados\n[0] Salir");
            int opc = getInt("Seleccione la opcion deseada", "Error intente ingresando un valor numerico");
            switch (opc){
                case 1:
                    System.out.println("La posicion donde no moriras es: " + inciso2.posicionSegura());
                    break;
                case 2:
                    System.out.println(inciso2.ordenEliminacion());
                    break;
                case 3:
                    inciso2.mirarPermutacion();
                    break;
                case 0:
                    conti = false;
                    System.out.println(":: Saliendo ::");
                    break;
                default:
                    System.out.println("Intente con una opcion valida");
            }
        }

    }

    public static void cafeterosTodes(){
        System.out.println(":: Calendarios de Cafeteras ::");
        int dia = getInt("Ingrese el dia", "Error, ingrese un valor numerico");
        int mes = getInt("Ingrese el mes","Error, ingrese un valor numerico");
        int anio = getInt("Ingrese el año","Error, ingrese un valor numerico");
        CalendarioCafetera cal = new CalendarioCafetera(dia,mes,anio);
        boolean conti = true;
        while (conti){
            System.out.println("[1] Respuesta al inciso a)\n[2] Añadir un nuevo participante y ver la lista nueva\n[0] Regresar");
            int respuesta = getInt("Seleccione una opcion", "Error, ingrese un valor numerico");
            switch (respuesta){
                case 1:
                    System.out.println(cal.fechas());
                    break;
                case 2:
                    System.out.print("Ingrese el nombre: ");
                    Scanner sc = new Scanner(System.in);
                    String name = sc.nextLine();
                    cal.setNamesCoffe(name);
                    System.out.println(cal.fechas());
                    break;
                case 0:
                    conti = false;
                default:
                    System.out.println("Intente con una opcion valida");
            }
        }
    }

    /**
     * Este método sirve para controlar que en las entradas de enteros
     * lo único que se pueda ingresar sean justo sólo valores numéricos y nada de cadenas
     *
     * @param msg mensaje de instrucciones al usuario o indicaciones
     * @param error mensaje de error al detectar que la entrada no es un valor nummérico
     * @return entero que validó y ahora puede ser utilizado
     */
    public static int getInt(String msg, String error){
        int entero = 0;
        Scanner scan = new Scanner(System.in);
        String librearBuffer;
        boolean conti = true;
        do{
            System.out.println(msg);
            if(scan.hasNextInt())
            {
                entero = scan.nextInt();
                conti = false;
            }else{
                librearBuffer = scan.next();
                System.out.println(error);
            }
        }while(conti);
        return entero;
    }
}
