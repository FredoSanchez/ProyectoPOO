/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa.cuadro;

import Graficos.Pantalla;
import Graficos.Sprite;

/**
 *
 * @author fredy
 */
public class Cuadro {

    public int x;
    public int y;

    public Sprite sprite;

    public static final int LADO = 32;
    //Colección de cuadros

    public static final Cuadro VACIO = new Cuadro(Sprite.VACIO);
    public static final Cuadro CAVERNA = new Cuadro(Sprite.CAVERNA);
    public static final Cuadro LAVA = new Cuadro(Sprite.LAVA);
    public static final Cuadro CALDERO = new Cuadro(Sprite.CALDERO);
    public static final Cuadro GRIETA = new Cuadro(Sprite.GRIETA);
    public static final Cuadro PARED = new Cuadro(Sprite.PARED);
    public static final Cuadro PUERTA1 = new Cuadro(Sprite.PUERTA1);
    public static final Cuadro PUERTA2 = new Cuadro(Sprite.PUERTA2);
    public static final Cuadro PUERTA3 = new Cuadro(Sprite.PUERTA3);
    public static final Cuadro PUERTA4 = new Cuadro(Sprite.PUERTA4);
    public static final Cuadro PUERTA5 = new Cuadro(Sprite.PUERTA5);
    public static final Cuadro PUERTA6 = new Cuadro(Sprite.PUERTA6);
    public static final Cuadro PISO = new Cuadro(Sprite.PISO);

    //Faltan más Sprites..
    //Fin de la colección de cuadros
    public Cuadro(Sprite sprite) {
        this.sprite = sprite;
    }

    public void mostrar(int x, int y, Pantalla pantalla) {
        pantalla.mostrarCuadro(x << 5, y << 5, this);
    }

    public boolean solido() {
        return false;
    }
}
