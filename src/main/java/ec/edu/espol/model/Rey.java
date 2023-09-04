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
public class Rey extends Pieza{
    
    private boolean jaque;
    
    public Rey(int x, int y, String color) {
        super(x,y,color);
        this.jaque = false;
    }
     
    @Override
    public void setMovimientos(ArrayList<Pieza> piezas) {
        ArrayList<Posicion> movPosibles = new ArrayList<>();
        
        Pieza otraPieza = null;
        
        int x = this.x;
        int y = this.y;
        
        //el rey se mueve en todas las direcciones pero solo en una casilla
        //se puede aplicar la misma logica que con el caballo, solo cambiando los dx y dy
        
        int[] dx = {1,1,-1,-1,1,0,-1,0};
        int[] dy = {1,-1,1,-1,0,1,0,-1};
        
        for (int i = 0; i<8; i++) {            
            Posicion pos = new Posicion(x+(dx[i]), y+(dy[i]));
            if (Posicion.enTablero(pos)) {
                otraPieza = Pieza.piezaEnCasilla(piezas, pos);
                if (otraPieza == null || !otraPieza.color.equals(this.color))
                    movPosibles.add(pos);
            }
        }
        this.movimientos = movPosibles;               
    }
}
