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
public class Pieza extends Posicion{
    protected String color;
    protected boolean vivo;
    protected ArrayList<Posicion> movimientos;
    
    public Pieza (int x, int y, String color) {
        super(x, y);
        this.color = color;
        this.vivo = true;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public ArrayList<Posicion> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Pieza> piezas) {
        System.out.println("null");
        this.movimientos = new ArrayList<Posicion>();
    }
    
    
    public static Pieza piezaEnCasilla(ArrayList<Pieza> piezas, Posicion posicion) {
        for (Pieza pieza : piezas) {
            if (pieza.x == posicion.x && pieza.y == posicion.y)
                return pieza;
        }
        return null;
    }
    
    public static Pieza getInstance(Pieza pieza) {
        if (pieza instanceof Peon) {           
            return (Peon)pieza;
        } 
        if (pieza instanceof Rey) {
            return (Rey)pieza;
        }
        if (pieza instanceof Reina) {
            return (Reina)pieza;
        }
        if (pieza instanceof Alfil) {
            return (Alfil)pieza;
        }
        if (pieza instanceof Caballo) {
            return (Caballo)pieza;
        }
        if (pieza instanceof Torre) {
            return (Torre)pieza;
        }
        return null;
    }
    
    public Posicion getPosicion() {
        return new Posicion(this.x, this.y);
    }
    
    public boolean equalsPieza(Pieza p) {
        return this.getPosicion().equals(p);
    }
}
