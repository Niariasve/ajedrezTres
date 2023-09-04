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
public class Torre extends Pieza{

    public Torre(int x, int y, String color) {
        super(x, y, color);
    }
    
    @Override
    public void setMovimientos(ArrayList<Pieza> piezas) {
        ArrayList<Posicion> movPosibles = new ArrayList<>();
        
        int x = this.x;
        int y = this.y;
        
        //la torre solo se puede mover arriba, abajo, izquierda, derecha
        
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        
        for (int i = 0; i<4; i++) {
            int c = 1;
            while (true){
                Posicion pos = new Posicion(x+c*dx[i], y+c*dy[i]);
                if (!Posicion.enTablero(pos))
                    break;
                Pieza otraPieza = Pieza.piezaEnCasilla(piezas, pos);
                if (otraPieza != null) {
                    if(!otraPieza.color.equals(this.color)) {
                        movPosibles.add(pos);                                               
                    }
                    break;                     
                }
                movPosibles.add(pos);
                c++;
            }
        }
        this.movimientos = movPosibles;
    }
}
