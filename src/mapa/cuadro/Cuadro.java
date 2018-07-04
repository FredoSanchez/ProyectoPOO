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
    
    private boolean solido;

    public static final int LADO = 32;
    //Colección de cuadros

    public static final Cuadro VACIO = new Cuadro(Sprite.VACIO,true);
    public static final Cuadro CAVERNA = new Cuadro(Sprite.CAVERNA,true);
    public static final Cuadro LAVA = new Cuadro(Sprite.LAVA, true);
    public static final Cuadro CALDERO = new Cuadro(Sprite.CALDERO, true);
    public static final Cuadro GRIETA = new Cuadro(Sprite.GRIETA,true);
    public static final Cuadro PARED = new Cuadro(Sprite.PARED,true);
    public static final Cuadro PUERTA1 = new Cuadro(Sprite.PUERTA1,true);
     public static final Cuadro PUERTA1D = new Cuadro(Sprite.PUERTA1D,true);
   // public static final Cuadro PUERTA2 = new Cuadro(Sprite.PUERTA2);
    public static final Cuadro PUERTA3 = new Cuadro(Sprite.PUERTA3,true);
     public static final Cuadro PUERTA3D = new Cuadro(Sprite.PUERTA3D,true);
    //public static final Cuadro PUERTA4 = new Cuadro(Sprite.PUERTA4);
    public static final Cuadro PUERTA5 = new Cuadro(Sprite.PUERTA5,true);
    public static final Cuadro PUERTA5D = new Cuadro(Sprite.PUERTA5D,true);
    //public static final Cuadro PUERTA6 = new Cuadro(Sprite.PUERTA6);
    public static final Cuadro PISO = new Cuadro(Sprite.PISO);
    public static final Cuadro HOYOLAVA = new Cuadro(Sprite.HOYOLAVA, true);
    public static final Cuadro PIEDRA = new Cuadro(Sprite.PIEDRA, true);
    public static final Cuadro CAVERNALAVA = new Cuadro(Sprite.CAVERNALAVA, true);
    public static final Cuadro LAVANEGRO = new Cuadro(Sprite.LAVANEGRO, true);
    
    

    //Faltan más Sprites..
    //Fin de la colección de cuadros
    public Cuadro(Sprite sprite) {
        this.sprite = sprite;
        solido = false;
    }

    public Cuadro(Sprite sprite, boolean solido) {
        this.sprite = sprite;
        this.solido = solido;
    }
    
    

    public void mostrar(int x, int y, Pantalla pantalla) {
        pantalla.mostrarCuadro(x << 5, y << 5, this);
    }

    public boolean isSolido() {
        return solido;
    }
}
