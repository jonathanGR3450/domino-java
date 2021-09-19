package p_domino;

/**
 * @author @version 1.00 2015/10/15
 */

public class NodoF {

    private NodoF sig, ant;
    private String info;

    public NodoF(String dato) {
        this.info = dato;
        this.ant = null;
        this.sig = null;
    }

    public NodoF getSig() {
        return this.sig;
    }

    public NodoF getAnt() {
        return ant;
    }

    public String getInfo() {
        return this.info;
    }

    public void setSig(NodoF dato) {
        this.sig = dato;
    }

    public void setAnt(NodoF dato) {
        this.ant = dato;
    }

    public void setInfo(String dato) {
        this.info = dato;
    }
}
