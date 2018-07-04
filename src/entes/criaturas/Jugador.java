/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entes.criaturas;

import Controles.Teclado;

/**
 *
 * @author ferna
 */
public class Jugador extends Criatura {

    private Teclado teclado;

    public Jugador(Teclado teclado) {
        this.teclado = teclado;
    }

    public Jugador(Teclado teclado, int posicionX, int posicionY) {
        this.teclado = teclado;
        this.x = posicionX;
        this.y = posicionY;
    }

    @Override
    public void actualizar() {
        int desplazamientoX = 0;
        int desplazamientoY = 0;

        if (teclado.arriba) {
            desplazamientoY--;
        }

        if (teclado.abajo) {
            desplazamientoY++;
        }

        if (teclado.izquierda) {
            desplazamientoX--;
        }

        if (teclado.derecha) {
            desplazamientoX++;
        }

        if (desplazamientoX != 0 || desplazamientoY != 0) {
            mover(desplazamientoX, desplazamientoY);
        }

    }
    
    @Override
    public void mostrar(){
        
    }
}
