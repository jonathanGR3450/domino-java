package p_domino;

/**
 * @author @version 1.00 2015/10/15
 */
public class ListaTodos {

    private NodoT raiz;
    private int tam;

    public ListaTodos() {
        this.raiz = null;
        tam = 0;
    }

    public boolean vacia() {
        return (this.tam == 0);
    }

    //metodos alta
    public void insertarPrimero(ListaJugador dato) {
        NodoT nuevo = new NodoT(dato);
        if (vacia()) {
            this.raiz = nuevo;
            this.raiz.setSig(this.raiz);
            this.raiz.setAnt(this.raiz);
            this.tam++;
        } else {
            NodoT reco = this.raiz.getAnt();
            reco.setSig(nuevo);
            nuevo.setAnt(reco);
            raiz.setAnt(nuevo);
            nuevo.setSig(this.raiz);
            this.raiz = nuevo;
            tam++;
        }

    }

    public void insertarUltimo(ListaJugador dato) {
        NodoT nuevo = new NodoT(dato);
        if (vacia()) {
            this.raiz = nuevo;
            this.raiz.setSig(this.raiz);
            this.raiz.setAnt(this.raiz);
            tam++;
        } else {
            NodoT reco = this.raiz.getAnt();
            reco.setSig(nuevo);
            nuevo.setAnt(reco);
            raiz.setAnt(nuevo);
            nuevo.setSig(this.raiz);
            tam++;
        }
    }

    public void insertar(int pos, ListaJugador dato) {
        if (pos > 0 && pos <= (tam + 1)) {
            if (pos == 1) {
                insertarPrimero(dato);
            } else {
                if (pos == (tam + 1)) {
                    insertarUltimo(dato);
                } else {
                    NodoT nuevo = new NodoT(dato);
                    NodoT antes = raiz;
                    for (int i = 1; i < pos - 1; i++) {
                        antes = antes.getSig();
                    }
                    antes.getSig().setAnt(nuevo);
                    nuevo.setSig(antes.getSig());
                    antes.setSig(nuevo);
                    nuevo.setAnt(antes);
                    tam++;
                }
            }
        }
    }

    //metodos de baja
    public ListaJugador extraerPrimero() {
        ListaJugador dato = null;
        if (!vacia()) {
            dato = this.raiz.getInfo();
            this.raiz.setInfo(null);
            this.raiz.getAnt().setSig(this.raiz.getSig());
            this.raiz.getSig().setAnt(raiz.getAnt());
            this.raiz = this.raiz.getSig();
            tam--;
        }
        return dato;
    }

    public ListaJugador extraerUltimo() {
        ListaJugador dato = null;
        if (!vacia()) {
            dato = this.raiz.getAnt().getInfo();
            this.raiz.getAnt().setInfo(null);
            this.raiz.getAnt().getAnt().setSig(this.raiz);
            this.raiz.setAnt(this.raiz.getAnt().getAnt());
            tam--;
        }
        return dato;
    }

    public ListaJugador extraer(int pos) {
        ListaJugador dato = null;
        if (pos > 0 && pos <= tam) {
            if (pos == 1) {
                dato = extraerPrimero();
            } else {
                if (pos == tam) {
                    dato = extraerUltimo();
                } else {
                    NodoT antes = raiz;
                    for (int i = 1; i < pos - 1; i++) {
                        antes = antes.getSig();
                    }
                    dato = antes.getSig().getInfo();
                    antes.getSig().setInfo(null);
                    antes.setSig(antes.getSig().getSig());
                    antes.getSig().setAnt(antes);
                    tam--;
                }
            }
        }
        return dato;
    }

    public void mostrar() {
        if (!vacia()) {
            NodoT reco = this.raiz;
            System.out.println();
            do {
                reco.getInfo().mostrar();
                reco = reco.getSig();
            } while (reco != raiz);
            System.out.println("");
        } else {
            System.out.println("La lista está vacía");
        }
    }

    public NodoT getRaiz() {
        return raiz;
    }

    public int getTam() {
        return tam;
    }

}
