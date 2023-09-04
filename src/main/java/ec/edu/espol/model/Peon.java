/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Peon extends Pieza{
    
    public Peon(int x, int y, String color) {
        super(x, y, color);
    }
    
    @Override
    public void setMovimientos(ArrayList<Pieza> piezas) {
        ArrayList<Posicion> movPosibles = new ArrayList<>();
        int x = this.x;
        int y = this.y;
        
        if (this.color.equals("blanco")) {
            //Las Blancas se mueven uno hacia arriba lo que en el tablero es y-1, las x se mantienen igual
            Posicion movArriba = new Posicion(x, y-1);
            if (Posicion.enTablero(movArriba) && Pieza.piezaEnCasilla(piezas, movArriba) == null) {
                movPosibles.add(movArriba);
                //verificar el primer movimiento doble de peones blancos
                //este movimiento siempre va a estar dentro del tablero, por eso no lo verifico
                //los peones no pueden moverse hacia atras, solo basta con verificar el color, y la casilla donde deberian estar para verificar el movimiento
                Posicion movArribaDos = new Posicion(x, y-2);
                if (this.y == 6 && Pieza.piezaEnCasilla(piezas, movArribaDos) == null)
                    movPosibles.add(movArribaDos);
            }
            //verificar si el peon puede capturar para la derecha y/o para la izquierda
            Posicion arribaDer = new Posicion(x+1, y-1);
            Posicion arribaIzq = new Posicion(x-1, y-1);
            
            if (Posicion.enTablero(arribaDer) && Pieza.piezaEnCasilla(piezas, arribaDer) != null) {
                if(Pieza.piezaEnCasilla(piezas, arribaDer).color.equals("negro"))
                    movPosibles.add(arribaDer);
            }
            if (Posicion.enTablero(arribaIzq) && Pieza.piezaEnCasilla(piezas, arribaIzq) != null) {
                if (Pieza.piezaEnCasilla(piezas, arribaIzq).color.equals("negro"))
                    movPosibles.add(arribaIzq);
            }
        } else if (this.color.equals("negro")) {
            //Las blancas se mueven uno hacia abajo en el tablero, por lo que es y+1 en el tablero, x se mantiene igual
            Posicion movAbajo = new Posicion(x, y+1);
            if (Posicion.enTablero(movAbajo) && Pieza.piezaEnCasilla(piezas, movAbajo) == null) {
                movPosibles.add(movAbajo);
                //verificar movimiento doble de peones negros
                Posicion movAbajoDos = new Posicion(x, y+2);
                if (this.y == 1 && Pieza.piezaEnCasilla(piezas, movAbajoDos) == null) 
                    movPosibles.add(movAbajoDos);
            }
            //verificar si el peon puede capturar
            Posicion abajoDer = new Posicion(x+1, y+1);
            Posicion abajoIzq = new Posicion(x-1, y+1);
            
            if (Posicion.enTablero(abajoDer) && Pieza.piezaEnCasilla(piezas, abajoDer) != null) {
                if(Pieza.piezaEnCasilla(piezas, abajoDer).color.equals("blanco"))
                    movPosibles.add(abajoDer);
            }
            if (Posicion.enTablero(abajoIzq) && Pieza.piezaEnCasilla(piezas, abajoIzq) != null) {
                if (Pieza.piezaEnCasilla(piezas, abajoIzq).color.equals("blanco"))
                    movPosibles.add(abajoIzq);
            }
        }
        
        this.movimientos = movPosibles;       
    }
}
