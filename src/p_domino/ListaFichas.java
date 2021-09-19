package p_domino;


public class ListaFichas {

    private NodoF raiz;
    private int tam;

    public ListaFichas() {
        this.raiz = null;
        tam = 0;
    }

    public boolean vacia() {
        return (this.tam == 0);
    }

    //metodos alta
    public void insertarPrimero(String dato) {
        NodoF nuevo = new NodoF(dato);
        if (vacia()) {
            this.raiz = nuevo;
            this.raiz.setSig(this.raiz);
            this.raiz.setAnt(this.raiz);
            this.tam++;
        } else {
            NodoF reco = this.raiz.getAnt();
            reco.setSig(nuevo);
            nuevo.setAnt(reco);
            raiz.setAnt(nuevo);
            nuevo.setSig(this.raiz);
            this.raiz = nuevo;
            tam++;
        }

    }

    public void insertarUltimo(String dato) {
        NodoF nuevo = new NodoF(dato);
        if (vacia()) {
            this.raiz = nuevo;
            this.raiz.setSig(this.raiz);
            this.raiz.setAnt(this.raiz);
            tam++;
        } else {
            NodoF reco = this.raiz.getAnt();
            reco.setSig(nuevo);
            nuevo.setAnt(reco);
            raiz.setAnt(nuevo);
            nuevo.setSig(this.raiz);
            tam++;
        }
    }

    public void insertar(int pos, String dato) {
        if (pos > 0 && pos <= (tam + 1)) {
            if (pos == 1) {
                insertarPrimero(dato);
            } else {
                if (pos == (tam + 1)) {
                    insertarUltimo(dato);
                } else {
                    NodoF nuevo = new NodoF(dato);
                    NodoF antes = raiz;
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
    public String extraerPrimero() {
        String dato = null;
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

    public String extraerUltimo() {
        String dato = null;
        if (!vacia()) {
            dato = this.raiz.getAnt().getInfo();
            this.raiz.getAnt().setInfo(null);
            this.raiz.getAnt().getAnt().setSig(this.raiz);
            this.raiz.setAnt(this.raiz.getAnt().getAnt());
            tam--;
        }
        return dato;
    }

    public String extraer(int pos) {
        String dato = null;
        if (pos > 0 && pos <= tam) {
            if (pos == 1) {
                dato = extraerPrimero();
            } else {
                if (pos == tam) {
                    dato = extraerUltimo();
                } else {
                    NodoF antes = raiz;
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
            NodoF reco = this.raiz;
            System.out.println();
            do {
                System.out.print(reco.getInfo());
                reco = reco.getSig();
            } while (reco != raiz);
            System.out.println("");
        } else {
            System.out.println("La lista está vacía");
        }
    }
    public String BValores(int dato) {
        NodoF reco = this.raiz;
        String ficha = null;
        for (int i = 0; i < dato; i++) {
            ficha=reco.getInfo();
            reco = reco.getSig();
        }
        return ficha;
    }

    public NodoF getRaiz() {
        return raiz;
    }

    public int getTam() {
        return tam;
    }

}
