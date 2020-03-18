import java.util.Iterator;

public class ProblemaJosephus {
    private ListaCircular<Integer> personasCirculo = new ListaCircular();
    private ListaCircular<Integer> ordenMuerte = new ListaCircular();
    private int personas;
    private int salto;
    public ProblemaJosephus(int personas, int salto){
        this.personas = personas;
        this.salto = salto;
        for (int i = 1; i < personas + 1; i++) {
            personasCirculo.agrega(i);
        }
    }
    public ListaCircular ordenEliminacion() {
        Iterator it = personasCirculo.iterator();
        while (it.hasNext() && personasCirculo.getTamanio() != 1) {
            for (int i = 0; i < salto - 1; i++) {
                if (i == salto - 2) {
                    ordenMuerte.agrega((Integer) it.next());
                } else {
                    it.next();
                }
            }
            it.remove();
        }
        return ordenMuerte;
    }

    public void mirarPermutacion(){
        ListaCircular<Integer> personasCirculo = new ListaCircular();
        ListaCircular<Integer> ordenMuerte = new ListaCircular();
        for (int i = 1; i < personas + 1; i++) {
            personasCirculo.agrega(i);
        }
        Iterator it = personasCirculo.iterator();
        while (it.hasNext() && personasCirculo.getTamanio() != 1) {
            for (int i = 0; i < salto - 1; i++) {
                if (i == salto - 2) {
                    ordenMuerte.agrega((Integer) it.next());
                } else {
                    it.next();
                }
            }
            it.remove();
            System.out.println(personasCirculo);
        }
    }

    public String posicionSegura() throws NoSuchMethodException{
        if (personasCirculo.getTamanio() > 1){
            throw new NoSuchMethodException("Primero debes haber ejecutado el metodo ordenEliminacion");
        }
        Iterator it = personasCirculo.iterator();
        return it.next().toString();
    }

    public int jose(int personas, int salto){
        if (personas == 1){
            return 0;
        }
        return (jose(personas-1, salto) + salto) % personas;
    }
}
