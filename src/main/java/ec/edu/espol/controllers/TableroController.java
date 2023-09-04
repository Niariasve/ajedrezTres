
package ec.edu.espol.controllers;

import ec.edu.espol.model.Alfil;
import ec.edu.espol.model.Caballo;
import ec.edu.espol.model.Peon;
import ec.edu.espol.model.Pieza;
import ec.edu.espol.model.Posicion;
import ec.edu.espol.model.Reina;
import ec.edu.espol.model.Rey;
import ec.edu.espol.model.Torre;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author User
 */
public class TableroController implements Initializable {
    
    private Pieza piezaActual = null;
     
    private Button piezaSelect = null; 
    private String piezaSelectId = null;
    private int numeroClick = 0;
    private int xOrigen = -1;
    private int yOrigen = -1;
    
    
    private ArrayList<Pieza> piezas;

    private ArrayList<Posicion> movimientos = null;
    
    private static String peonBlanco = "src\\main\\resources\\fichas\\peonBlanco.png";
    private static String peonNegro = "src\\main\\resources\\fichas\\peonNegro.png";
    private static String reinaBlanca = "src\\main\\resources\\fichas\\reinaBlanca.png";
    private static String reinaNegra = "src\\main\\resources\\fichas\\reinaNegra.png";
    private static String reyBlanco = "src\\main\\resources\\fichas\\reyBlanco.png";
    private static String reyNegro = "src\\main\\resources\\fichas\\reyNegro.png";
    private static String torreBlanca = "src\\main\\resources\\fichas\\torreBlanca.png";
    private static String torreNegra = "src\\main\\resources\\fichas\\torreNegra.png";
    private static String caballoBlanco = "src\\main\\resources\\fichas\\caballoBlanco.png";
    private static String caballoNegro = "src\\main\\resources\\fichas\\caballoNegro.png";
    private static String alfilBlanco = "src\\main\\resources\\fichas\\alfilBlanco.png";
    private static String alfilNegro = "src\\main\\resources\\fichas\\alfilNegro.png";
    
    private boolean jugadorActual; //Blancas = false y Negras = true
    
    @FXML
    private GridPane tableroGrid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inicializarTablero();
    }    
    
    public void inicializarTablero() {
        piezas = new ArrayList<>();
        jugadorActual = false;
        int c = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                
                StackPane pane = new StackPane();
                pane.setAlignment(Pos.CENTER);
                
                Rectangle r = new Rectangle();
                Button b = new Button();
                b.setStyle("-fx-background-color: transparent;");
                
                String bId = (i)+","+(j);
                
//                r.setX(i);
//                r.setY(j);
                
                r.setWidth(100);
                r.setHeight(100);
                
                b.setPrefHeight(85);
                b.setPrefWidth(65);
                b.setId(bId);                
                
                if(c % 2 == 0) {
                    r.setFill(Color.WHITE);
                } else {
                    r.setFill(Color.LIGHTBLUE);
                }
                
                pane.getChildren().addAll(r, b);
                tableroGrid.add(pane, i, j);
                
                if (j == 0) {
                    if (i == 0 || i == 7) {
                        b.setGraphic(cargarImagen(torreNegra));
                        Pieza torre = new Torre(i, j, "negro");
                        piezas.add(torre);
                    }
                    else if (i == 1 || i == 6) {
                        b.setGraphic(cargarImagen(caballoNegro));
                        Pieza caballo = new Caballo(i,j,"negro");
                        piezas.add(caballo);
                    }
                    else if (i == 2 || i == 5) {
                        b.setGraphic(cargarImagen(alfilNegro));
                        Pieza alfil = new Alfil(i,j,"negro");
                        piezas.add(alfil);
                    }
                    else if (i == 3) {
                        b.setGraphic(cargarImagen(reinaNegra));
                        Pieza reina = new Reina(i,j,"negro");
                        piezas.add(reina);
                    }
                    else if (i == 4) {
                        b.setGraphic(cargarImagen(reyNegro));
                        Pieza rey = new Rey(i,j,"negro");
                        piezas.add(rey);
                    }
                }
                else if (j == 1) {
                    b.setGraphic(cargarImagen(peonNegro));
                    Pieza peon = new Peon(i,j,"negro");
                    piezas.add(peon);
                }
                else if (j == 6) {
                    b.setGraphic(cargarImagen(peonBlanco));
                    Pieza peon = new Peon(i,j,"blanco");
                    piezas.add(peon);
                }
                else if (j == 7) {
                    if (i == 0 || i == 7) {
                        b.setGraphic(cargarImagen(torreBlanca));
                        Pieza torre = new Torre(i, j, "blanco");
                        piezas.add(torre);
                    }
                    else if (i == 1 || i == 6) {
                        b.setGraphic(cargarImagen(caballoBlanco));
                        Pieza caballo = new Caballo(i,j,"blanco");
                        piezas.add(caballo);
                    }
                    else if (i == 2 || i == 5) {
                        b.setGraphic(cargarImagen(alfilBlanco));
                        Pieza alfil = new Alfil(i,j,"blanco");
                        piezas.add(alfil);
                    }
                    else if (i == 3) {
                        b.setGraphic(cargarImagen(reinaBlanca));
                        Pieza reina = new Reina(i,j,"blanco");
                        piezas.add(reina);
                    }
                    else if (i == 4) {
                        b.setGraphic(cargarImagen(reyBlanco));
                        Pieza rey = new Rey(i,j,"blanco");
                        piezas.add(rey);
                    }
                    
                }
                b.setOnAction((ActionEvent e) -> {
                    moverFicha((Button) e.getSource());
                });               
                c++;
            }
            c++;
        }               
    }
    
    ImageView cargarImagen(String url) {
        try {
            FileInputStream in = new FileInputStream(url);
            Image im = new Image(in);
            ImageView iv = new ImageView();
            iv.setImage(im);
            iv.setFitHeight(75);
            iv.setFitWidth(75);
            return iv;
        } catch (FileNotFoundException e) {
            System.out.println("No archivo existe");
        }
        return null;
    }
    
    private boolean piezaPerteneceAJugador(Pieza pieza){
        if(this.jugadorActual && pieza.getColor().equals("negro")){
            return true;
        }
        if(!this.jugadorActual && pieza.getColor().equals("blanco")){
            return true;
        }
        return false;
    }
    
    private void moverFicha(Button piezaClick) { 
        
        if (numeroClick == 0) {
            System.out.println("NUMERO CLICK: " + numeroClick);
            
            if (piezaClick.getGraphic() != null) {
                if (piezaSelect == null ) {
                    piezaSelect = piezaClick;
                    
                    String[] coordenadas = piezaClick.getId().split(",");
                    xOrigen = Integer.parseInt(coordenadas[0]);
                    yOrigen = Integer.parseInt(coordenadas[1]);                    
                    Posicion pos = new Posicion(xOrigen, yOrigen);
                    
                    Pieza p = null;
                    for (Pieza pieza : piezas) {
                        if (pieza.getX() == xOrigen && pieza.getY() == yOrigen) {
                            pieza.setMovimientos(piezas);                            
                            movimientos = pieza.getMovimientos();
                            System.out.println(movimientos);
                            piezaActual = Pieza.piezaEnCasilla(piezas, pos);
//                            p = Pieza.getInstance(pieza);
//                            System.out.println(pieza.getMovimientos());
                        }    
                    }
//                    if (p != null) {
//                        movimientos = p.getMovimientos();
//                        //System.out.println(p.getMovimientos());
//                            
//                        
//                    }
                    piezaSelectId = piezaClick.getId();
                    numeroClick++;
                }
                
                if(!piezaPerteneceAJugador(piezaActual)){
                    piezaSelect = null;
                    piezaSelectId = null;
                    numeroClick = 0; 
                    piezaActual = null;
                }
            }  
        } else if(numeroClick == 1) {
            System.out.println("NUMERO CLICK: " + numeroClick);
            if(piezaClick != piezaSelect) {
                String[] coordenadas = piezaClick.getId().split(",");
                int xDestino = Integer.parseInt(coordenadas[0]);                
                int yDestino = Integer.parseInt(coordenadas[1]);
                System.out.println(xDestino +","+yDestino);
                
                Posicion posDestino = new Posicion(xDestino, yDestino);
//                System.out.println("Hasta aqui todo flama");
//                System.out.println(Posicion.contienePosicion(movimientos, posDestino));
                if (Posicion.contienePosicion(movimientos, posDestino)) {
//                    System.out.println("Contiene");
                    boolean capturar = false;
                    Pieza p = null;
                    for (Pieza pieza : piezas) {
//                        System.out.println("checking piece");
                        if (pieza.getX() == xDestino && pieza.getY() == yDestino) {
//                               System.out.println("eatable");
                              capturar = true;
                              p = pieza;
                              
                              if(p.getColor().equals(piezaActual.getColor())){
                                  capturar = true;
                                  p = null;
                                  piezaSelect = null;
                                    piezaSelectId = null;
                                    numeroClick = 0; 
                                    piezaActual = null;
                              }
                              
                              break;
                        } else {
                            capturar = false;
                            p = null;                            
                        }                                                
                    }
                    if (capturar && p != null) {
//                        System.out.println("?");
                        
                        System.out.println("Capturado");
                        piezas.remove(p);
                        piezaActual.setX(xDestino);
                        piezaActual.setY(yDestino);
                        ImageView graficoPiezaAnterior = (ImageView) piezaSelect.getGraphic();
                        piezaClick.setGraphic(graficoPiezaAnterior);
                        piezaSelect.setGraphic(null);
                        this.jugadorActual = !this.jugadorActual;
                    } else if (!capturar || p == null && piezaActual != null) {
//                        System.out.println("?2");
                        piezaActual.setX(xDestino);
                        piezaActual.setY(yDestino);
                        ImageView graficoPiezaAnterior = (ImageView) piezaSelect.getGraphic();
                        piezaClick.setGraphic(graficoPiezaAnterior);
                        piezaSelect.setGraphic(null);
                        this.jugadorActual = !this.jugadorActual;
                    }
                }
                
            }
            piezaSelect = null;
            piezaSelectId = null;
            numeroClick = 0; 
            piezaActual = null;
        }        
    }
    

}
