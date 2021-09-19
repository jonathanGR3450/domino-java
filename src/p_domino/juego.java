/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_domino;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author PERSONAL
 */
public class juego {
    private ListaFichas f1=new ListaFichas();
    private ListaFichas f2=new ListaFichas();
    private ListaFichas f3=new ListaFichas();
    private ListaFichas f4=new ListaFichas();
    private ListaFichas f5=new ListaFichas();
    private ListaFichas f6=new ListaFichas();
    private ListaFichas f7=new ListaFichas();
    private ListaFichas f8=new ListaFichas();
    private ListaFichas f9=new ListaFichas();
    private ListaFichas f10=new ListaFichas();
    private ListaFichas f11=new ListaFichas();
    private ListaFichas f12=new ListaFichas();
    private ListaFichas f13=new ListaFichas();
    private ListaFichas f14=new ListaFichas();
    private ListaFichas f15=new ListaFichas();
    private ListaFichas f16=new ListaFichas();
    private ListaFichas f17=new ListaFichas();
    private ListaFichas f18=new ListaFichas();
    private ListaFichas f19=new ListaFichas();
    private ListaFichas f20=new ListaFichas();
    private ListaFichas f21=new ListaFichas();
    private ListaFichas f22=new ListaFichas();
    private ListaFichas f23=new ListaFichas();
    private ListaFichas f24=new ListaFichas();
    private ListaFichas f25=new ListaFichas();
    private ListaFichas f26=new ListaFichas();
    private ListaFichas f27=new ListaFichas();
    private ListaFichas f28=new ListaFichas();
    
    
    private ListaFichas faux=new ListaFichas();
    
    private ListaJugador dealer=new ListaJugador();
    
    private ListaJugador j1=new ListaJugador();
    private ListaJugador j2=new ListaJugador();
    private ListaJugador j3=new ListaJugador();
    private ListaJugador j4=new ListaJugador();
    
    private ListaTodos jugadores=new ListaTodos();
    
    private int FichaAlta=-1;
    
    private int NJugadores=0;
    private Random rm= new Random();
    
    private int NJAlta=0;
    
    public juego(){
        f1.insertarPrimero("00");
        f2.insertarPrimero("01");f3.insertarPrimero("11");
        f4.insertarPrimero("02");f5.insertarPrimero("12");f6.insertarPrimero("22");
        f7.insertarPrimero("03");f8.insertarPrimero("13");f9.insertarPrimero("23");f10.insertarPrimero("33");
        f11.insertarPrimero("04");f12.insertarPrimero("14");f13.insertarPrimero("24");f14.insertarPrimero("34");f15.insertarPrimero("44");
        f16.insertarPrimero("05");f17.insertarPrimero("15");f18.insertarPrimero("25");f19.insertarPrimero("35");f20.insertarPrimero("45");f21.insertarPrimero("55");
        f22.insertarPrimero("06");f23.insertarPrimero("16");f24.insertarPrimero("26");f25.insertarPrimero("36");f26.insertarPrimero("46");f27.insertarPrimero("56");f28.insertarPrimero("66");
        
        this.dealer.insertarPrimero(f1);
        this.dealer.insertarPrimero(f2);
        this.dealer.insertarPrimero(f3);
        this.dealer.insertarPrimero(f4);
        this.dealer.insertarPrimero(f5);
        this.dealer.insertarPrimero(f6);
        this.dealer.insertarPrimero(f7);
        this.dealer.insertarPrimero(f8);
        this.dealer.insertarPrimero(f9);
        this.dealer.insertarPrimero(f10);
        this.dealer.insertarPrimero(f11);
        this.dealer.insertarPrimero(f12);
        this.dealer.insertarPrimero(f13);
        this.dealer.insertarPrimero(f14);
        this.dealer.insertarPrimero(f15);
        this.dealer.insertarPrimero(f16);
        this.dealer.insertarPrimero(f17);
        this.dealer.insertarPrimero(f18);
        this.dealer.insertarPrimero(f19);
        this.dealer.insertarPrimero(f20);
        this.dealer.insertarPrimero(f21);
        this.dealer.insertarPrimero(f22);
        this.dealer.insertarPrimero(f23);
        this.dealer.insertarPrimero(f24);
        this.dealer.insertarPrimero(f25);
        this.dealer.insertarPrimero(f26);
        this.dealer.insertarPrimero(f27);
        this.dealer.insertarPrimero(f28);
        
        this.jugadores.insertarPrimero(dealer);
        
    }
    
    public ListaTodos repartir(int NJugadores){
        this.NJugadores=NJugadores;
        for (int i = 0; i < this.NJugadores; i++) {
            for (int j = 0; j < 7; j++) {
                int n=rm.nextInt(dealer.getTam())+1;
                switch(i){
                    case 0:
                        j1.insertarPrimero(dealer.extraer(n));
                        
                    break;
                    case 1:
                        j2.insertarPrimero(dealer.extraer(n));
                    break;
                    case 2:
                        j3.insertarPrimero(dealer.extraer(n));;
                    break;
                    case 3:
                        j4.insertarPrimero(dealer.extraer(n));
                    break;
                }
            }
            
        }
        jugadores.insertarPrimero(j1);
        jugadores.insertarPrimero(j2);
        jugadores.insertarPrimero(j3);
        jugadores.insertarPrimero(j4);
        
        /*System.out.println("jugador1");
        this.j1.mostrar();
        System.out.println("jugador2");
        this.j2.mostrar();
        System.out.println("jugador3");
        this.j3.mostrar();
        System.out.println("jugador4");
        this.j4.mostrar();
        System.out.println("dealer");
        this.dealer.mostrar();*/
        
        return jugadores;
        
    }
    public ListaJugador getDealer(){
        return this.dealer;
    }
    public int getFuchaAlta(){
        return this.FichaAlta;
    }
    public ListaFichas comenzar(){
        //int c=-1;
        boolean encontro=false;
        for (int k = 0; k < 7; k++) {
            switch(k){
                case 0:
                    this.faux=f28;
                break;
                case 1:
                    this.faux=f21;
                break;
                case 2:
                    this.faux=f15;
                break;
                case 3:
                    this.faux=f10;
                break;
                case 4:
                    this.faux=f6;
                break;
                case 5:
                    this.faux=f3;
                break;
                case 6:
                    this.faux=f1;
                break;
                
            }
            
            for (int i = 0; i < this.NJugadores+1; i++) {
                switch(i){
                    case 0:
                        if (dealer.buscarFicha(faux)) {
                            FichaAlta=0;
                            //System.out.println("el dealer tiene el "+faux.extraer(1));
                            encontro=false;
                            break;
                        }
                    break;
                    case 1:
                        if (j1.buscarFicha(faux)) {
                            FichaAlta=1;
                            this.NJAlta=j1.buscarPos(faux);
                            j1.extraer(this.NJAlta);
                            //System.out.println("el j1 tiene el "+faux.extraer(1));
                            encontro=true;
                            break;
                        }
                    break;
                    case 2:
                        if (j2.buscarFicha(faux)) {
                            FichaAlta=2;
                            this.NJAlta=j2.buscarPos(faux);
                            j2.extraer(this.NJAlta);
                            //System.out.println("el j2 tiene el "+faux.extraer(1));
                            encontro=true;
                            break;
                        }
                    break;
                    case 3:
                        if (j3.buscarFicha(faux)) {
                            FichaAlta=3;
                            this.NJAlta=j3.buscarPos(faux);
                            j3.extraer(this.NJAlta);
                           // System.out.println("el j3 tiene el "+faux.extraer(1));
                            encontro=true;
                            break;
                        }
                    break;
                    case 4:
                        if (j4.buscarFicha(faux)) {
                            FichaAlta=4;
                            this.NJAlta=j4.buscarPos(faux);
                            j4.extraer(this.NJAlta);
                            //System.out.println("el j4 tiene el ");
                            encontro=true;
                            break;
                        }
                    break;
                }
        }
            if (encontro==true) {
                break;
            }
        }
        return faux;
    }
    public int getNJAlta(){
        return this.NJAlta;
    }
    
}
