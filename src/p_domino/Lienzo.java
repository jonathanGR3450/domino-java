/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_domino;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ingsistemas
 */
public class Lienzo {

    private JFrame ventana;
    private UtilizarImagenes fig;
    private int cont = 1;
    private int i = 0;
    private int j = 0;
    private int a = -1;
    private boolean izquierda = true;

    private int xDe = 625;
    private int xiz = 675;
    
    private int nf=0;
    
    ListaJugador dealer=new ListaJugador();

    public Lienzo(ListaTodos jugadores, ListaFichas ficha, int JAlta, String j1, String j2, String j3, String j4, int CJ, ListaJugador dealer) {
        ventana = new JFrame("Domino");
        //ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setSize(1400, 800);
        ventana.setResizable(false);
        fig = new UtilizarImagenes(jugadores, ficha, JAlta, j1, j2, j3, j4, CJ);
        ventana.add(this.fig);
        this.dealer=dealer;
        ventana.addKeyListener(
                new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println("" + e.getKeyCode());
                if (e.getKeyCode() == 39) {
                    izquierda = false;
                } else if (e.getKeyCode() == 37) {
                    izquierda = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }
        );
        ventana.addMouseMotionListener(
                new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }

        });
        ventana.addMouseListener(
                new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getX() > 1240 && e.getX() < 1391 && e.getY() > 700 && e.getY() < 800) {
                    if (fig.getJAlta() == CJ) {
                        fig.setJAlta(1);
                        fig.repaint();
                    } else {
                        fig.setJAlta(fig.getJAlta() + 1);
                        fig.repaint();
                    }

                }

                //boton de comer fichas
                if (fig.getNDealer() != 0) {
                    if (cont < fig.getNDealer() + 1) {
                        if (e.getX() > 35 && e.getX() < 190 && e.getY() > 700 && e.getY() < 750) {
                            fig.setFaltantes(fig.getNDealer() - cont);
                            fig.insertarF(dealer.BFichas(cont), fig.getJActual());
                            //fig.eliminarF(1, fig.getJActual());
                            
                            fig.repaint();
                            cont++;
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "No hay mas fichas!");
                    }
                }

                if (izquierda) {
                    a = -1;
                } else {
                    a = 1;
                }
                try {
                    if (e.getX() > 251 && e.getX() < 301 && e.getY() > 629 && e.getY() < 731) {
                        if (izquierda) {
                            if (fig.Existe(fig.getIMG(1, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(1, fig.getJActual()))) {
                                    xiz = xiz + a * 50;
                                    fig.llenar("imagenesdePie", fig.getIMG(1, fig.getJActual()), "" + xiz, "349");
                                    fig.setValor(fig.getIMG(1, fig.getJActual()).charAt(0));
                                    fig.eliminarF(1, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xiz = xiz + a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValor(fig.getIMG(1, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(1, fig.getJActual()), "" + xiz, "374");
                                    } else {
                                        fig.setValor(fig.getIMG(1, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(1, fig.getJActual()), "" + xiz, "374");
                                    }
                                    fig.eliminarF(1, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        System.out.println("e " + (fig.getJAlta() + 1));
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        } else {
                            if (fig.ExisteDe(fig.getIMG(1, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(1, fig.getJActual()))) {
                                    xDe += a * 50;
                                    fig.setValorDerecha(fig.getIMG(1, fig.getJActual()).charAt(0));
                                    fig.llenar("imagenesdePie", fig.getIMG(1, fig.getJActual()), "" + (xDe + 51), "349");
                                    fig.eliminarF(1, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xDe += a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValorDerecha(fig.getIMG(1, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(1, fig.getJActual()), "" + xDe, "374");
                                    } else {
                                        fig.setValorDerecha(fig.getIMG(1, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(1, fig.getJActual()), "" + xDe, "374");
                                    }
                                    fig.eliminarF(1, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        }

                    } else if (e.getX() > 330 && e.getX() < 380 && e.getY() > 629 && e.getY() < 731) {
                        if (izquierda) {
                            if (fig.Existe(fig.getIMG(2, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(2, fig.getJActual()))) {
                                    xiz = xiz + a * 50;
                                    fig.llenar("imagenesdePie", fig.getIMG(2, fig.getJActual()), "" + xiz, "349");
                                    fig.setValor(fig.getIMG(2, fig.getJActual()).charAt(0));
                                    fig.eliminarF(2, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xiz = xiz + a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValor(fig.getIMG(2, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(2, fig.getJActual()), "" + xiz, "374");
                                    } else {
                                        fig.setValor(fig.getIMG(2, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(2, fig.getJActual()), "" + xiz, "374");
                                    }
                                    fig.eliminarF(2, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        } else {
                            if (fig.ExisteDe(fig.getIMG(2, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(2, fig.getJActual()))) {
                                    xDe += a * 50;
                                    fig.setValorDerecha(fig.getIMG(2, fig.getJActual()).charAt(0));
                                    fig.llenar("imagenesdePie", fig.getIMG(2, fig.getJActual()), "" + (xDe + 51), "349");
                                    fig.eliminarF(2, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xDe += a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValorDerecha(fig.getIMG(2, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(2, fig.getJActual()), "" + xDe, "374");
                                    } else {
                                        fig.setValorDerecha(fig.getIMG(2, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(2, fig.getJActual()), "" + xDe, "374");
                                    }
                                    fig.eliminarF(1, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        }
                    } else if (e.getX() > 410 && e.getX() < 460 && e.getY() > 629 && e.getY() < 731) {
                        if (izquierda) {
                            if (fig.Existe(fig.getIMG(3, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(3, fig.getJActual()))) {
                                    xiz = xiz + a * 50;
                                    fig.llenar("imagenesdePie", fig.getIMG(3, fig.getJActual()), "" + xiz, "349");
                                    fig.setValor(fig.getIMG(3, fig.getJActual()).charAt(0));
                                    fig.eliminarF(3, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xiz = xiz + a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValor(fig.getIMG(3, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(3, fig.getJActual()), "" + xiz, "374");
                                    } else {
                                        fig.setValor(fig.getIMG(3, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(3, fig.getJActual()), "" + xiz, "374");
                                    }
                                    fig.eliminarF(3, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        } else {
                            if (fig.ExisteDe(fig.getIMG(3, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(3, fig.getJActual()))) {
                                    xDe += a * 50;
                                    fig.setValorDerecha(fig.getIMG(3, fig.getJActual()).charAt(0));
                                    fig.llenar("imagenesdePie", fig.getIMG(3, fig.getJActual()), "" + (xDe + 51), "349");
                                    fig.eliminarF(3, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xDe += a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValorDerecha(fig.getIMG(3, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(3, fig.getJActual()), "" + xDe, "374");
                                    } else {
                                        fig.setValorDerecha(fig.getIMG(3, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(3, fig.getJActual()), "" + xDe, "374");
                                    }
                                    fig.eliminarF(3, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        }

                    } else if (e.getX() > 490 && e.getX() < 540 && e.getY() > 629 && e.getY() < 731) {
                        if (izquierda) {
                            if (fig.Existe(fig.getIMG(4, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(4, fig.getJActual()))) {
                                    xiz = xiz + a * 50;
                                    fig.llenar("imagenesdePie", fig.getIMG(4, fig.getJActual()), "" + xiz, "349");
                                    fig.setValor(fig.getIMG(4, fig.getJActual()).charAt(0));
                                    fig.eliminarF(4, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xiz = xiz + a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValor(fig.getIMG(4, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(4, fig.getJActual()), "" + xiz, "374");
                                    } else {
                                        fig.setValor(fig.getIMG(4, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(4, fig.getJActual()), "" + xiz, "374");
                                    }
                                    fig.eliminarF(4, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        } else {
                            if (fig.ExisteDe(fig.getIMG(4, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(4, fig.getJActual()))) {
                                    xDe += a * 50;
                                    fig.setValorDerecha(fig.getIMG(4, fig.getJActual()).charAt(0));
                                    fig.llenar("imagenesdePie", fig.getIMG(4, fig.getJActual()), "" + (xDe + 51), "349");
                                    fig.eliminarF(4, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xDe += a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValorDerecha(fig.getIMG(4, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(4, fig.getJActual()), "" + xDe, "374");
                                    } else {
                                        fig.setValorDerecha(fig.getIMG(4, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(4, fig.getJActual()), "" + xDe, "374");
                                    }
                                    fig.eliminarF(4, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        }

                    } else if (e.getX() > 570 && e.getX() < 620 && e.getY() > 629 && e.getY() < 731) {
                        if (izquierda) {
                            if (fig.Existe(fig.getIMG(5, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(5, fig.getJActual()))) {
                                    xiz = xiz + a * 50;
                                    fig.llenar("imagenesdePie", fig.getIMG(5, fig.getJActual()), "" + xiz, "349");
                                    fig.setValor(fig.getIMG(5, fig.getJActual()).charAt(0));
                                    fig.eliminarF(5, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xiz = xiz + a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValor(fig.getIMG(5, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(5, fig.getJActual()), "" + xiz, "374");
                                    } else {
                                        fig.setValor(fig.getIMG(5, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(5, fig.getJActual()), "" + xiz, "374");
                                    }
                                    fig.eliminarF(5, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        } else {
                            if (fig.ExisteDe(fig.getIMG(5, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(5, fig.getJActual()))) {
                                    xDe += a * 50;
                                    fig.setValorDerecha(fig.getIMG(5, fig.getJActual()).charAt(0));
                                    fig.llenar("imagenesdePie", fig.getIMG(5, fig.getJActual()), "" + (xDe + 51), "349");
                                    fig.eliminarF(5, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xDe += a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValorDerecha(fig.getIMG(5, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(5, fig.getJActual()), "" + xDe, "374");
                                    } else {
                                        fig.setValorDerecha(fig.getIMG(5, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(5, fig.getJActual()), "" + xDe, "374");
                                    }
                                    fig.eliminarF(5, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        }

                    } else if (e.getX() > 650 && e.getX() < 700 && e.getY() > 629 && e.getY() < 731) {
                        if (izquierda) {
                            if (fig.Existe(fig.getIMG(6, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(6, fig.getJActual()))) {
                                    xiz = xiz + a * 50;
                                    fig.llenar("imagenesdePie", fig.getIMG(6, fig.getJActual()), "" + xiz, "349");
                                    fig.setValor(fig.getIMG(6, fig.getJActual()).charAt(0));
                                    fig.eliminarF(6, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xiz = xiz + a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValor(fig.getIMG(6, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(6, fig.getJActual()), "" + xiz, "374");
                                    } else {
                                        fig.setValor(fig.getIMG(6, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(6, fig.getJActual()), "" + xiz, "374");
                                    }
                                    fig.eliminarF(6, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        } else {
                            if (fig.ExisteDe(fig.getIMG(6, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(6, fig.getJActual()))) {
                                    xDe += a * 50;
                                    fig.setValorDerecha(fig.getIMG(6, fig.getJActual()).charAt(0));
                                    fig.llenar("imagenesdePie", fig.getIMG(6, fig.getJActual()), "" + (xDe + 51), "349");
                                    fig.eliminarF(6, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xDe += a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValorDerecha(fig.getIMG(6, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(6, fig.getJActual()), "" + xDe, "374");
                                    } else {
                                        fig.setValorDerecha(fig.getIMG(6, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(6, fig.getJActual()), "" + xDe, "374");
                                    }
                                    fig.eliminarF(6, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        }
                    } else if (e.getX() > 730 && e.getX() < 780 && e.getY() > 629 && e.getY() < 731) {
                        if (izquierda) {
                            if (fig.Existe(fig.getIMG(7, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(7, fig.getJActual()))) {
                                    xiz = xiz + a * 50;
                                    fig.llenar("imagenesdePie", fig.getIMG(7, fig.getJActual()), "" + xiz, "349");
                                    fig.setValor(fig.getIMG(7, fig.getJActual()).charAt(0));
                                    fig.eliminarF(7, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xiz = xiz + a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValor(fig.getIMG(7, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(7, fig.getJActual()), "" + xiz, "374");
                                    } else {
                                        fig.setValor(fig.getIMG(7, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(7, fig.getJActual()), "" + xiz, "374");
                                    }
                                    fig.eliminarF(7, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        } else {
                            if (fig.ExisteDe(fig.getIMG(7, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(7, fig.getJActual()))) {
                                    xDe += a * 50;
                                    fig.setValorDerecha(fig.getIMG(7, fig.getJActual()).charAt(0));
                                    fig.llenar("imagenesdePie", fig.getIMG(7, fig.getJActual()), "" + (xDe + 51), "349");
                                    fig.eliminarF(7, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xDe += a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValorDerecha(fig.getIMG(7, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(7, fig.getJActual()), "" + xDe, "374");
                                    } else {
                                        fig.setValorDerecha(fig.getIMG(7, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(7, fig.getJActual()), "" + xDe, "374");
                                    }
                                    fig.eliminarF(7, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        }
                    }else if (e.getX() > 810 && e.getX() < 860 && e.getY() > 629 && e.getY() < 731) {
                        if (izquierda) {
                            if (fig.Existe(fig.getIMG(8, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(8, fig.getJActual()))) {
                                    xiz = xiz + a * 50;
                                    fig.llenar("imagenesdePie", fig.getIMG(8, fig.getJActual()), "" + xiz, "349");
                                    fig.setValor(fig.getIMG(8, fig.getJActual()).charAt(0));
                                    fig.eliminarF(8, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xiz = xiz + a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValor(fig.getIMG(8, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(8, fig.getJActual()), "" + xiz, "374");
                                    } else {
                                        fig.setValor(fig.getIMG(8, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(8, fig.getJActual()), "" + xiz, "374");
                                    }
                                    fig.eliminarF(8, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        } else {
                            if (fig.ExisteDe(fig.getIMG(8, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(8, fig.getJActual()))) {
                                    xDe += a * 50;
                                    fig.setValorDerecha(fig.getIMG(8, fig.getJActual()).charAt(0));
                                    fig.llenar("imagenesdePie", fig.getIMG(8, fig.getJActual()), "" + (xDe + 51), "349");
                                    fig.eliminarF(8, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xDe += a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValorDerecha(fig.getIMG(8, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(8, fig.getJActual()), "" + xDe, "374");
                                    } else {
                                        fig.setValorDerecha(fig.getIMG(8, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(8, fig.getJActual()), "" + xDe, "374");
                                    }
                                    fig.eliminarF(8, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        }
                    }else if (e.getX() > 890 && e.getX() < 940 && e.getY() > 629 && e.getY() < 731) {
                        if (izquierda) {
                            if (fig.Existe(fig.getIMG(9, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(9, fig.getJActual()))) {
                                    xiz = xiz + a * 50;
                                    fig.llenar("imagenesdePie", fig.getIMG(9, fig.getJActual()), "" + xiz, "349");
                                    fig.setValor(fig.getIMG(9, fig.getJActual()).charAt(0));
                                    fig.eliminarF(9, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xiz = xiz + a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValor(fig.getIMG(9, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(9, fig.getJActual()), "" + xiz, "374");
                                    } else {
                                        fig.setValor(fig.getIMG(9, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(9, fig.getJActual()), "" + xiz, "374");
                                    }
                                    fig.eliminarF(9, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        } else {
                            if (fig.ExisteDe(fig.getIMG(9, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(9, fig.getJActual()))) {
                                    xDe += a * 50;
                                    fig.setValorDerecha(fig.getIMG(9, fig.getJActual()).charAt(0));
                                    fig.llenar("imagenesdePie", fig.getIMG(9, fig.getJActual()), "" + (xDe + 51), "349");
                                    fig.eliminarF(9, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xDe += a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValorDerecha(fig.getIMG(9, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(9, fig.getJActual()), "" + xDe, "374");
                                    } else {
                                        fig.setValorDerecha(fig.getIMG(9, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(9, fig.getJActual()), "" + xDe, "374");
                                    }
                                    fig.eliminarF(9, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        }
                    }else if(e.getX() > 970 && e.getX() < 1020 && e.getY() > 629 && e.getY() < 731){
                        nf=10;
                        if (izquierda) {
                            if (fig.Existe(fig.getIMG(nf, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(nf, fig.getJActual()))) {
                                    xiz = xiz + a * 50;
                                    fig.llenar("imagenesdePie", fig.getIMG(nf, fig.getJActual()), "" + xiz, "349");
                                    fig.setValor(fig.getIMG(nf, fig.getJActual()).charAt(0));
                                    fig.eliminarF(nf, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xiz = xiz + a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValor(fig.getIMG(nf, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(nf, fig.getJActual()), "" + xiz, "374");
                                    } else {
                                        fig.setValor(fig.getIMG(nf, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(nf, fig.getJActual()), "" + xiz, "374");
                                    }
                                    fig.eliminarF(nf, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        } else {
                            if (fig.ExisteDe(fig.getIMG(nf, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(nf, fig.getJActual()))) {
                                    xDe += a * 50;
                                    fig.setValorDerecha(fig.getIMG(nf, fig.getJActual()).charAt(0));
                                    fig.llenar("imagenesdePie", fig.getIMG(nf, fig.getJActual()), "" + (xDe + 51), "349");
                                    fig.eliminarF(nf, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xDe += a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValorDerecha(fig.getIMG(nf, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(nf, fig.getJActual()), "" + xDe, "374");
                                    } else {
                                        fig.setValorDerecha(fig.getIMG(nf, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(nf, fig.getJActual()), "" + xDe, "374");
                                    }
                                    fig.eliminarF(nf, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        }
                    }else if(e.getX() > 1050 && e.getX() < 1100 && e.getY() > 629 && e.getY() < 731){
                        nf=11;
                        if (izquierda) {
                            if (fig.Existe(fig.getIMG(nf, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(nf, fig.getJActual()))) {
                                    xiz = xiz + a * 50;
                                    fig.llenar("imagenesdePie", fig.getIMG(nf, fig.getJActual()), "" + xiz, "349");
                                    fig.setValor(fig.getIMG(nf, fig.getJActual()).charAt(0));
                                    fig.eliminarF(nf, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xiz = xiz + a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValor(fig.getIMG(nf, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(nf, fig.getJActual()), "" + xiz, "374");
                                    } else {
                                        fig.setValor(fig.getIMG(nf, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(nf, fig.getJActual()), "" + xiz, "374");
                                    }
                                    fig.eliminarF(nf, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        } else {
                            if (fig.ExisteDe(fig.getIMG(nf, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(nf, fig.getJActual()))) {
                                    xDe += a * 50;
                                    fig.setValorDerecha(fig.getIMG(nf, fig.getJActual()).charAt(0));
                                    fig.llenar("imagenesdePie", fig.getIMG(nf, fig.getJActual()), "" + (xDe + 51), "349");
                                    fig.eliminarF(nf, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xDe += a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValorDerecha(fig.getIMG(nf, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(nf, fig.getJActual()), "" + xDe, "374");
                                    } else {
                                        fig.setValorDerecha(fig.getIMG(nf, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(nf, fig.getJActual()), "" + xDe, "374");
                                    }
                                    fig.eliminarF(nf, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        }
                    }else if(e.getX() > 1130 && e.getX() < 1180 && e.getY() > 629 && e.getY() < 731){
                        nf=12;
                        if (izquierda) {
                            if (fig.Existe(fig.getIMG(nf, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(nf, fig.getJActual()))) {
                                    xiz = xiz + a * 50;
                                    fig.llenar("imagenesdePie", fig.getIMG(nf, fig.getJActual()), "" + xiz, "349");
                                    fig.setValor(fig.getIMG(nf, fig.getJActual()).charAt(0));
                                    fig.eliminarF(nf, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xiz = xiz + a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValor(fig.getIMG(nf, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(nf, fig.getJActual()), "" + xiz, "374");
                                    } else {
                                        fig.setValor(fig.getIMG(nf, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(nf, fig.getJActual()), "" + xiz, "374");
                                    }
                                    fig.eliminarF(nf, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        } else {
                            if (fig.ExisteDe(fig.getIMG(nf, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(nf, fig.getJActual()))) {
                                    xDe += a * 50;
                                    fig.setValorDerecha(fig.getIMG(nf, fig.getJActual()).charAt(0));
                                    fig.llenar("imagenesdePie", fig.getIMG(nf, fig.getJActual()), "" + (xDe + 51), "349");
                                    fig.eliminarF(nf, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xDe += a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValorDerecha(fig.getIMG(nf, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(nf, fig.getJActual()), "" + xDe, "374");
                                    } else {
                                        fig.setValorDerecha(fig.getIMG(nf, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(nf, fig.getJActual()), "" + xDe, "374");
                                    }
                                    fig.eliminarF(nf, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        }
                    }else if(e.getX() > 1210 && e.getX() < 1260 && e.getY() > 629 && e.getY() < 731){
                        nf=13;
                        if (izquierda) {
                            if (fig.Existe(fig.getIMG(nf, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(nf, fig.getJActual()))) {
                                    xiz = xiz + a * 50;
                                    fig.llenar("imagenesdePie", fig.getIMG(nf, fig.getJActual()), "" + xiz, "349");
                                    fig.setValor(fig.getIMG(nf, fig.getJActual()).charAt(0));
                                    fig.eliminarF(nf, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xiz = xiz + a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValor(fig.getIMG(nf, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(nf, fig.getJActual()), "" + xiz, "374");
                                    } else {
                                        fig.setValor(fig.getIMG(nf, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(nf, fig.getJActual()), "" + xiz, "374");
                                    }
                                    fig.eliminarF(nf, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        } else {
                            if (fig.ExisteDe(fig.getIMG(nf, fig.getJActual()))) {
                                if (fig.vertical(fig.getIMG(nf, fig.getJActual()))) {
                                    xDe += a * 50;
                                    fig.setValorDerecha(fig.getIMG(nf, fig.getJActual()).charAt(0));
                                    fig.llenar("imagenesdePie", fig.getIMG(nf, fig.getJActual()), "" + (xDe + 51), "349");
                                    fig.eliminarF(nf, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                } else {
                                    xDe += a * 100;
                                    if (fig.getDerecha()) {
                                        fig.setValorDerecha(fig.getIMG(nf, fig.getJActual()).charAt(0));
                                        fig.llenar("imagenesladoDerecha", fig.getIMG(nf, fig.getJActual()), "" + xDe, "374");
                                    } else {
                                        fig.setValorDerecha(fig.getIMG(nf, fig.getJActual()).charAt(1));
                                        fig.llenar("imagenesladoIzquierda", fig.getIMG(nf, fig.getJActual()), "" + xDe, "374");
                                    }
                                    fig.eliminarF(nf, fig.getJActual());
                                    if (fig.getJAlta() == CJ) {
                                        fig.setJAlta(1);
                                        fig.repaint();
                                    } else {
                                        fig.setJAlta(fig.getJAlta() + 1);
                                        fig.repaint();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ficha no valida!!!");
                                if (fig.getJAlta() == CJ) {
                                    fig.setJAlta(1);
                                    fig.repaint();
                                } else {
                                    fig.setJAlta(fig.getJAlta() + 1);
                                    fig.repaint();
                                }
                            }
                        }
                    }
                    
                } catch (Exception ev) {
                    JOptionPane.showMessageDialog(null, "No hay Ficha!!!");
                }

            }

            @Override

            //saber si presiciono alguna ficha
            public void mousePressed(MouseEvent e) {

            }

            @Override
            //donde solto el mouse
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void ganador() {
        if (fig.getTamano() == 0) {
            String[] options = {"nuevo juego", "salir"};
            int seleccion = JOptionPane.showOptionDialog(null, "GANO!!", "JUGADOR", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (seleccion == 0) {
                inicio n = new inicio();
                n.setVisible(true);
                ventana.setVisible(false);
            } else if (seleccion == 1) {
                System.exit(0);
            }
        }
    }

}
