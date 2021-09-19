package p_domino;

/**
 * @author @version 1.00 2015/10/15
 */

public class NodoT {

    private NodoT sig, ant;
    private ListaJugador info;

    public NodoT(ListaJugador dato) {
        this.info = dato;
        this.ant = null;
        this.sig = null;
    }

    public NodoT getSig() {
        return this.sig;
    }

    public NodoT getAnt() {
        return ant;
    }

    public ListaJugador getInfo() {
        return this.info;
    }

    public void setSig(NodoT dato) {
        this.sig = dato;
    }

    public void setAnt(NodoT dato) {
        this.ant = dato;
    }

    public void setInfo(ListaJugador dato) {
        this.info = dato;
    }
}
