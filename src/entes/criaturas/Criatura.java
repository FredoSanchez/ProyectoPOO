/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entes.criaturas;

import Graficos.Sprite;
import entes.Ente;

/**
 *
 * @author ferna
 */
public abstract class Criatura extends Ente {
    protected Sprite sprite;
    protected char direccion = 'n';
    protected boolean enMovimiento =  false;
    
    public void actualizar(){
        
    }
    
    public void mostrar(){
        
    }
    
    public void mover(int desplazamientoX, int desplazamientoY){
        if(desplazamientoX > 0){
            direccion = 'e';
        }
        if(desplazamientoX < 0){
            direccion = 'o';
        }
        
        if(desplazamientoY > 0){
            direccion = 's';
        }
        
        if(desplazamientoY < 0){
            direccion ='n';
        }
        
        if(!estaEliminado()){
            modificarPosicionX(desplazamientoX);
            modificarPosicionY(desplazamientoY);
        }
    }
    
    private boolean enColision(){
        return false;
    }
    
}
