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
public abstract class Cuadro {
    public int x;
    public int y;
    
    public Sprite sprite;

    public Cuadro(Sprite sprite) {
        this.sprite = sprite;
    }
    
    public void mostrar(int x, int y, Pantalla pantalla){
        
    }
    
    public boolean solido(){
        return false;
    }
}