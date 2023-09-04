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
public class Reina extends Pieza{

    public Reina(int x, int y, String color) {
        super(x, y, color);
    }
    
    @Override
    public void setMovimientos(ArrayList<Pieza> piezas) {
        ArrayList<Posicion> movPosibles = new ArrayList<>();
        
        //la reina es una combinacion entre los movimientos del alfil y de la torre
        
        int x = this.x;
        int y = this.y;
        
        //movimientos diagonales
        int[] dx = {1,1,-1,-1};
        int[] dy = {1,-1,1,-1};
        
        for (int i = 0; i<4; i++){
            int c = 1;           
            while(true) {
                Posicion pos = new Posicion(x+c*dx[i], y+c*dy[i]);
                if (!Posicion.enTablero(pos)) 
                    break;
                Pieza otraPieza = Pieza.piezaEnCasilla(piezas, pos);
                if (otraPieza != null) {
                    if (!otraPieza.color.equals(this.color)) {
                        movPosibles.add(pos);
                    }
                    break;
                }
                movPosibles.add(pos);
                c++;
            }
        }
        
        //movimientos laterales
        int[] dw = {1,0,-1,0};
        int[] dz = {0,1,0,-1};
        
        for (int i = 0; i<4; i++) {
            int c = 1;
            while (true){
                Posicion pos = new Posicion(x+c*dw[i], y+c*dz[i]);
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
