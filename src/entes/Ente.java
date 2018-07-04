/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entes;

import mapa.Mapa;

/**
 *
 * @author ferna
 */
public class Ente {

    protected int x;
    protected int y;

    private boolean eliminado = false;

    protected Mapa mapa;

    public void actualizar() {

    }

    public void mostrar() {

    }

    public void eliminar() {
        eliminado = true;
    }

    public int obtenerPosicionX() {
        return x;
    }

    public void modificarPosicionX(int desplazamientoX) {
        x += desplazamientoX;
    }

    public int obtenerPosicionY() {
        return y;
    }

    public void modificarPosicionY(int desplazamientoY) {
        y += desplazamientoY;
    }

    public boolean estaEliminado() {
        return eliminado;
    }

}
