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
    
    @Override
    public void actualizar(){
        
    }
    
    @Override
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
            if (!enColision(desplazamientoX, 0)){
                modificarPosicionX(desplazamientoX);
            }
            if(!enColision(0, desplazamientoY)){
                modificarPosicionY(desplazamientoY);
            }            
        }
    }
    
    private boolean enColision(int desplazamientoX, int desplazamientoY){
        boolean colision = false;
        
        int posicionX = x + desplazamientoX;
        int posicionY = y + desplazamientoY;
        
        int margenIzquierdo = -18;
        int margenDerecho = 24;
        int margenSuperior = -10;
        int margenInferior = 30;
        
        int bordeIzquierdo = (posicionX + margenDerecho)/ sprite.getLado();
        int bordeDerecho = (posicionX + margenDerecho + margenIzquierdo)/ sprite.getLado();
        int bordeSuperior = (posicionY + margenInferior)/ sprite.getLado();
        int bordeInferior = (posicionY + margenInferior + margenSuperior)/ sprite.getLado();
        
        if(mapa.getCuadroCatalogo(bordeIzquierdo + bordeSuperior * mapa.getAncho()).isSolido()){
            colision = true;
        }
        if(mapa.getCuadroCatalogo(bordeIzquierdo + bordeInferior * mapa.getAncho()).isSolido()){
            colision = true;
        }
        if(mapa.getCuadroCatalogo(bordeDerecho + bordeSuperior * mapa.getAncho()).isSolido()){
            colision = true;
        }
        if(mapa.getCuadroCatalogo(bordeDerecho + bordeInferior * mapa.getAncho()).isSolido()){
            colision = true;
        }
        
        return colision;
    }

    public Sprite getSprite() {
        return sprite;
    }
    
    
}
