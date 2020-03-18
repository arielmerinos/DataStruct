import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Iterator;

public class CalendarioCafetera {
    private int day;
    private int mes;
    private int iear;
    ListaCircular<String> limpiadores = new ListaCircular<>();


    public CalendarioCafetera(int day, int mes, int iear){
        this.day = day;
        this.mes = mes;
        this.iear = iear;
        limpiadores.agrega("Ricardo");
        limpiadores.agrega("Alejandro");
        limpiadores.agrega("Nestaly");
        limpiadores.agrega("Alma");
    }
    public ListaCircular fechas(){
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat ftSalida = new SimpleDateFormat("EEEEE dd ' de ' MMMMM");
        ListaCircular<String> fechas = new ListaCircular<>();
        Calendar ahora = Calendar.getInstance();
        ahora.setTime(ahora.getTime());
        Calendar fin = Calendar.getInstance();
        try {
            fin.setTime(ft.parse(day+"/"+mes+"/" + iear));
        } catch (
                ParseException e){
            System.out.println(e);
        }
        Iterator it = limpiadores.iterator();
        while (!fin.before(ahora)){
            if (ahora.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
                fechas.agrega( ftSalida.format(ahora.getTime()) + ": " + it.next() + "\n");
            }
            ahora.add(Calendar.DATE, 1);
        }
        return fechas;
    }
    public void setNamesCoffe(String namesCoffe) throws NullPointerException{
        if (namesCoffe == null){
            throw new NullPointerException("Pasa un nombre valido amixe");
        }
        limpiadores.agrega(namesCoffe);
    }
}
