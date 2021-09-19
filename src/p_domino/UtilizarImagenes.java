package p_domino;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import static javafx.scene.paint.Color.color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ingsistemas
 */
public class UtilizarImagenes extends JPanel {

    private int x1 = 250 + 0 * 80;
    private int y1 = 628;
    private int x2 = 250 + 1 * 80;
    private int y2 = 628;
    private int x3 = 250 + 2 * 80;
    private int y3 = 628;
    private int x4 = 250 + 3 * 80;
    private int y4 = 628;
    private int x5 = 250 + 4 * 80;
    private int y5 = 628;
    private int x6 = 250 + 5 * 80;
    private int y6 = 628;
    private int x7 = 250 + 6 * 80;
    private int y7 = 628;

    private boolean Derecha = true;

    private boolean existe = false;
    private boolean existeDe = false;

    private boolean aV1 = true;

    private String fichaM;
    private int JAlta = 0;

    private char Valor;
    private char ValorDerecha;

    private String jugador1 = "";
    private String jugador2 = "";
    private String jugador3 = "";
    private String jugador4 = "";

    private int tamano = 0;

    private ListaJugador dealer = new ListaJugador();
    private ListaJugador j1 = new ListaJugador();
    private ListaJugador j2 = new ListaJugador();
    private ListaJugador j3 = new ListaJugador();
    private ListaJugador j4 = new ListaJugador();

    private ListaFichas ficha = new ListaFichas();

    private ListaFichas NFicha = new ListaFichas();
    private ListaFichas NCarpeta = new ListaFichas();
    private ListaFichas posX = new ListaFichas();
    private ListaFichas posY = new ListaFichas();

    private int faltantes = 0;
    private int NDealer = 0;
    private int CJ = 0;

    private int JActual = 0;

    public UtilizarImagenes(ListaTodos jugadores, ListaFichas ficha, int JAlta, String j1, String j2, String j3, String j4, int CJ) {
        this.setBackground(new Color(39, 119, 20));
        this.CJ = CJ;
        this.JAlta = JAlta;
        System.out.println("jugador con ficha alta: " + JAlta);
        fichaM = ficha.extraer(1);
        Valor = fichaM.charAt(0);
        ValorDerecha = fichaM.charAt(0);

        this.ficha = ficha;
        this.jugador1 = "Jugador: " + j1;
        this.jugador2 = "Jugador: " + j2;
        this.jugador3 = "Jugador: " + j3;
        this.jugador4 = "Jugador: " + j4;
        //System.out.println("jugador 4:");
        this.j4 = jugadores.extraer(1);

        //System.out.println("jugador 3:");
        this.j3 = jugadores.extraer(1);

        //System.out.println("jugador 2:");
        this.j2 = jugadores.extraer(1);

        //System.out.println("jugador 1:");
        this.j1 = jugadores.extraer(1);

        //System.out.println("dealer:");
        this.dealer = jugadores.extraer(1);

        this.faltantes = dealer.getTam();
        this.NDealer = dealer.getTam();

        System.out.println("jugador1");
        this.j1.mostrar();
        System.out.println("jugador2");
        this.j2.mostrar();
        System.out.println("jugador3");
        this.j3.mostrar();
        System.out.println("jugador4");
        this.j4.mostrar();
        System.out.println("dealer");
        this.dealer.mostrar();

    }

    public void eliminarF(int pos, int j) {
        if (j == 1) {
            j1.extraer(pos);
        } else if (j == 2) {
            j2.extraer(pos);
        } else if (j == 3) {
            j3.extraer(pos);
        } else if (j == 4) {
            j4.extraer(pos);
        }

    }
    public void insertarF(ListaFichas dato, int j){
        if (j == 1) {
            j1.insertarUltimo(dato);
        } else if (j == 2) {
            j2.insertarUltimo(dato);
        } else if (j == 3) {
            j3.insertarUltimo(dato);
        } else if (j == 4) {
            j4.insertarUltimo(dato);
        }
    }

    public void setJAlta(int JAlta) {
        this.JAlta = JAlta;
    }

    public int getJAlta() {
        return this.JAlta;
    }

    public boolean getExiste() {
        return this.existe;
    }

    public void setValor(char Valor) {
        this.Valor = Valor;
    }

    public void setValorDerecha(char Valor) {
        this.ValorDerecha = Valor;
    }

    public void setDerecha(boolean derecha) {
        this.Derecha = derecha;
    }

    public boolean getDerecha() {
        return this.Derecha;
    }

    public void llenar(String NCarpeta, String NFicha, String posX, String posY) {
        this.NCarpeta.insertarPrimero(NCarpeta);
        this.NFicha.insertarPrimero(NFicha);
        this.posX.insertarPrimero(posX);
        this.posY.insertarPrimero(posY);
    }

    public boolean Existe(String f) {

        if (f.charAt(0) == Valor) {
            this.existe = true;
            System.out.println(f.charAt(0) + " , " + Valor);
            this.Derecha = true;
        } else if (f.charAt(1) == Valor) {
            this.existe = true;
            System.out.println(f.charAt(1) + " , " + Valor);
            this.Derecha = false;
        } else {
            this.existe = false;
        }

        return this.existe;
    }

    public boolean ExisteDe(String f) {

        if (f.charAt(0) == ValorDerecha) {
            this.existeDe = true;
            System.out.println(f.charAt(0) + " , " + ValorDerecha);
            this.Derecha = false;
        } else if (f.charAt(1) == ValorDerecha) {
            this.existeDe = true;
            System.out.println(f.charAt(1) + " , " + ValorDerecha);
            this.Derecha = true;
        } else {
            this.existeDe = false;
        }

        return this.existeDe;
    }

    public int getNDealer() {
        return this.NDealer;
    }

    public void setFaltantes(int faltantes) {
        this.faltantes = faltantes;
    }

    public int getFaltantes() {
        return this.faltantes;
    }

    public String getIMG(int valor, int j) {
        String img = "";
        if (j == 1) {
            img = j1.BFichas(valor).BValores(1);
        } else if (j == 2) {
            img = j2.BFichas(valor).BValores(1);
        } else if (j == 3) {
            img = j3.BFichas(valor).BValores(1);
        } else if (j == 4) {
            img = j4.BFichas(valor).BValores(1);
        }
        return img;

    }

    public boolean vertical(String im1) {
        if (im1.equals("00") || im1.equals("11") || im1.equals("22") || im1.equals("33") || im1.equals("44") || im1.equals("55") || im1.equals("66")) {
            this.aV1 = true;
        } else {
            this.aV1 = false;
        }
        return this.aV1;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        ImageIcon Img = new ImageIcon(getClass().getResource("/imagenesdePie/" + fichaM + ".png"));

        ImageIcon siguiente = new ImageIcon(getClass().getResource("/imagenesdePie/paso.png"));
        g2d.drawImage(siguiente.getImage(), (1400 - 160), (800 - 120), siguiente.getImageObserver());

        //mostrar nombre 
        g.setFont(new Font("Serif", Font.BOLD, 35));
        switch (this.CJ) {
            case 2:
                if (this.JAlta == 1) {
                    g.drawString(this.jugador2, 650, 50);
                    this.JActual = 2;
                } else if (this.JAlta == 2) {
                    g.drawString(this.jugador1, 650, 50);
                    this.JActual = 1;
                }
                break;
            case 3:
                switch (this.JAlta) {
                    case 1:
                        g.drawString(this.jugador2, 650, 50);
                        this.JActual = 2;
                        break;
                    case 2:
                        g.drawString(this.jugador3, 650, 50);
                        this.JActual = 3;
                        break;
                    case 3:
                        g.drawString(this.jugador1, 650, 50);
                        this.JActual = 1;
                        break;
                    default:
                        break;
                }
                break;
            case 4:
                switch (this.JAlta) {
                    case 1:
                        g.drawString(this.jugador2, 650, 50);
                        this.JActual = 2;
                        break;
                    case 2:
                        g.drawString(this.jugador3, 650, 50);
                        this.JActual = 3;
                        break;
                    case 3:
                        g.drawString(this.jugador4, 650, 50);
                        this.JActual = 4;
                        break;
                    case 4:
                        g.drawString(this.jugador1, 650, 50);
                        this.JActual = 1;
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }

        switch (this.JActual) {
            case 1: {
                this.tamano = j1.getTam();
                break;
            }
            case 2: {
                this.tamano = j2.getTam();
                break;
            }
            case 3: {
                this.tamano = j3.getTam();
                break;
            }
            case 4: {
                this.tamano = j4.getTam();
                break;
            }
            default:
                break;
        }
        if (tamano == 0) {
            ImageIcon Img0 = new ImageIcon(getClass().getResource("/imagenesdePie/ganador.png"));
            g2d.drawImage(Img0.getImage(), 450, 150, Img0.getImageObserver());
            repaint();
        } else {
            //fichas puestas
            for (int i = 0; i < this.NFicha.getTam(); i++) {
                ImageIcon Img1 = new ImageIcon(getClass().getResource("/" + this.NCarpeta.BValores(i + 1) + "/" + this.NFicha.BValores(i + 1) + ".png"));
                g2d.drawImage(Img1.getImage(), Integer.parseInt(this.posX.BValores(i + 1)), Integer.parseInt(this.posY.BValores(i + 1)), Img1.getImageObserver());
            }

            ImageIcon ImgAtras = new ImageIcon(getClass().getResource("/imagenesdePie/atras.png"));

            //fichas para comer
            for (int i = 0; i < this.faltantes; i++) {
                g2d.drawImage(ImgAtras.getImage(), 4 * i, i * 42, ImgAtras.getImageObserver());
            }

            ImageIcon boton = new ImageIcon(getClass().getResource("/imagenesdePie/boton.png"));
            g2d.drawImage(boton.getImage(), 20, 650, boton.getImageObserver());

            for (int i = 0; i < this.tamano; i++) {
                switch (this.JActual) {
                    case 1: {
                        ImageIcon Img1 = new ImageIcon(getClass().getResource("/imagenesdePie/" + j1.BFichas(i + 1).BValores(1) + ".png"));
                        g2d.drawImage(Img1.getImage(), 250 + i * 80, 628, Img1.getImageObserver());
                        break;
                    }
                    case 2: {
                        ImageIcon Img1 = new ImageIcon(getClass().getResource("/imagenesdePie/" + j2.BFichas(i + 1).BValores(1) + ".png"));
                        g2d.drawImage(Img1.getImage(), 250 + i * 80, 628, Img1.getImageObserver());
                        break;
                    }
                    case 3: {
                        ImageIcon Img1 = new ImageIcon(getClass().getResource("/imagenesdePie/" + j3.BFichas(i + 1).BValores(1) + ".png"));
                        g2d.drawImage(Img1.getImage(), 250 + i * 80, 628, Img1.getImageObserver());
                        break;
                    }
                    case 4: {
                        ImageIcon Img1 = new ImageIcon(getClass().getResource("/imagenesdePie/" + j4.BFichas(i + 1).BValores(1) + ".png"));
                        g2d.drawImage(Img1.getImage(), 250 + i * 80, 628, Img1.getImageObserver());
                        break;
                    }
                    default:
                        break;
                }

            }
            g2d.drawImage(Img.getImage(), (700 - 25), (400 - 51), Img.getImageObserver());
        }

    }

    public int getJActual() {
        return this.JActual;
    }

    public int getTamano() {
        return this.tamano;
    }

}
