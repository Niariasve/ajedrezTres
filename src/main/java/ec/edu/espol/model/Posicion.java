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
public class Posicion {
    protected int x;
    protected int y;
    
    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public static boolean enTablero(Posicion posicion) {
        if (posicion.x >= 0 && posicion.x <= 7 && posicion.y >= 0 && posicion.y <= 7) {
            return true;
        }
        return false;
    }
    public boolean obtruccion(Posicion posicion) {
        
        //chequear si en el camino hay alguna ficha
        
        return false;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this == null) return false;
        if (this.getClass() != o.getClass()) return false;
        
        Posicion other = (Posicion)o;       
        return this.x == other.x && this.y == other.y;
    }
    
    public static boolean contienePosicion(ArrayList<Posicion> movimientos, Posicion posicion) {
        for (Posicion p : movimientos) {
            if (posicion.equals(p))
                return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return this.x + "," + this.y;
    }
    
    
}
