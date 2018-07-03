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
    
    public static final int LADO=32;
    //Colección de cuadros
    
    public static final Cuadro VACIO = new Cuadro(Sprite.VACIO);
    public static final Cuadro CAVERNA = new Cuadro(Sprite.CAVERNA);
    public static final Cuadro LAVA = new Cuadro(Sprite.LAVA);
    public static final Cuadro CALDERO = new Cuadro(Sprite.CALDERO);
    public static final Cuadro PIEDRA = new Cuadro(Sprite.PIEDRA);
    
    
     //Faltan más Sprites..
    
    //Fin de la colección de cuadros

    public Cuadro(Sprite sprite) {
        this.sprite = sprite;
    }
    
    public void mostrar(int x, int y, Pantalla pantalla){
         pantalla.mostrarCuadro(x<<5, y <<5, this);
    }
    
    public boolean solido(){
        return false;
    }
}
