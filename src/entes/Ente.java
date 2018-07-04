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

    private int x;
    private int y;

    private boolean eliminado = false;

    protected Mapa mapa;

    public void actualizar() {

    }

    public void mostrar() {

    }

    public void eliminar() {
        eliminado = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean estaEliminado() {
        return eliminado;
    }

}
