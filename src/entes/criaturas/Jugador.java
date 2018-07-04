/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entes.criaturas;

import Controles.Teclado;
import Graficos.Pantalla;
import Graficos.Sprite;

/**
 *
 * @author ferna
 */
public class Jugador extends Criatura {

    private Teclado teclado;
    
    private int animacion;

    public Jugador(Teclado teclado, Sprite sprite) {
        this.teclado = teclado;
        this.sprite = sprite;
    }

    public Jugador(Teclado teclado,Sprite sprite, int posicionX, int posicionY) {
        this.teclado = teclado;
        this.sprite = sprite;
        this.x = posicionX;
        this.y = posicionY;
    }

    @Override
    public void actualizar() {
        int desplazamientoX = 0;
        int desplazamientoY = 0;
        if (animacion < 32767){
            animacion++;
        }else{
            animacion=0;
        }

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
            enMovimiento = true;
        }else{
            enMovimiento = false;
        }
        if(direccion== 'n'){
                sprite = Sprite.ARRIBA0;
                if (enMovimiento){
                    //Velocidad en la que se alternan las animaciones
                    //Se divide entre un numero par y su modulo o residuo debe ser mayor que la mitad de ese numero
                    //porque depende del numero de sprites 
                    if (animacion % 30 > 15){                        
                        sprite = Sprite.ARRIBA1;
                    }else{
                        sprite = Sprite.ARRIBA2;
                    }
                }
            }
            if(direccion== 's'){
                sprite = Sprite.ABAJO0;
                if (enMovimiento){
                    if (animacion % 30 > 15){                        
                        sprite = Sprite.ABAJO1;
                    }else{
                        sprite = Sprite.ABAJO2;
                    }
                }
            }
            if(direccion== 'o'){
                sprite = Sprite.IZQUIERDA0;
                if (enMovimiento){
                    if (animacion % 30 > 15){                        
                        sprite = Sprite.IZQUIERDA1;
                    }else{
                        sprite = Sprite.IZQUIERDA2;
                    }
                }
            }
            if(direccion== 'e'){
                sprite = Sprite.DERECHA0;
                if (enMovimiento){
                    if (animacion % 30 > 15){                        
                        sprite = Sprite.DERECHA1;
                    }else{
                        sprite = Sprite.DERECHA2;
                    }
                }
            }

    }
    
    public void mostrar(Pantalla pantalla){
       pantalla.mostrarJugador(x, y, this);
    }
}
