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
public class Caballo extends Pieza{

    public Caballo(int x, int y, String color) {
        super(x, y, color);
    }
    
    @Override
    public void setMovimientos(ArrayList<Pieza> piezas) {
        ArrayList<Posicion> movPosibles = new ArrayList<>();
        
        int x = this.x;
        int y = this.y;
        
        //el caballo solo se puede mover de estas maneras por lo que hay que probar todas las combinaciones
        //y hacer las respectivas validaciones
        
        int[] dx = {-1,1,2,2,1,-1,-2,-2};
        int[] dy = {-2,-2,-1,1,2,2,1,-1};
        
        Pieza otraPieza = null;
        
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
