package p_domino;

/**
 * @author @version 1.00 2015/10/15
 */

public class NodoJ {

    private NodoJ sig, ant;
    private ListaFichas info;

    public NodoJ(ListaFichas dato) {
        this.info = dato;
        this.ant = null;
        this.sig = null;
    }

    public NodoJ getSig() {
        return this.sig;
    }

    public NodoJ getAnt() {
        return ant;
    }

    public ListaFichas getInfo() {
        return this.info;
    }

    public void setSig(NodoJ dato) {
        this.sig = dato;
    }

    public void setAnt(NodoJ dato) {
        this.ant = dato;
    }

    public void setInfo(ListaFichas dato) {
        this.info = dato;
    }
}
