/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import mapa.cuadro.Cuadro;

/**
 *
 * @author ferna
 */
public class MapaCargado extends Mapa {

    private int[] pixeles;

    public MapaCargado(String ruta) {
        super(ruta);
    }

    protected void cargarMapa(String ruta) {
        try {
            BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));
            ancho = imagen.getWidth();
            alto = imagen.getHeight();
            
            cuadrosCatalogo = new Cuadro[ancho * alto];
            pixeles = new int[ancho * alto];
            
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    protected void generarMapa(){
        for(int i = 0; i < pixeles.length; i++){
            switch(pixeles[i]){
           case 0xffae424a:
                    cuadrosCatalogo[i] = Cuadro.LAVA;
                    continue;
                case 0xff7d4d35:
                    cuadrosCatalogo[i] = Cuadro.CAVERNA;
                    continue;
                case 0xffaec54a:
                    cuadrosCatalogo[i] = Cuadro.CALDERO;
                    continue;
                    
                case 0xff161414:
                    cuadrosCatalogo[i] = Cuadro.GRIETA;
                    continue;
                    
                    case 0xffe37431:
                    cuadrosCatalogo[i] = Cuadro.PARED;
                    continue;
                    
                    case 0xffc8c1c9:
                    cuadrosCatalogo[i] = Cuadro.PUERTA1;
                    continue;
                    
                   /* case 0xffbdc0a2:
                    cuadrosCatalogo[i] = Cuadro.PUERTA2;
                    continue;*/
                    
                    case 0xff6f878a:
                    cuadrosCatalogo[i] = Cuadro.PUERTA3;
                    continue;
                    
                    /*case 0xff83797b:
                    cuadrosCatalogo[i] = Cuadro.PUERTA4;
                    continue;*/
                    
                    case 0xff6e6258:
                    cuadrosCatalogo[i] = Cuadro.PUERTA5;
                    continue;
                    
                    /*case 0xff6c4665:
                    cuadrosCatalogo[i] = Cuadro.PUERTA6;
                    continue;*/
                    
                    case 0xff322d16:
                    cuadrosCatalogo[i] = Cuadro.PISO;
                    continue;
                    
                    
                default:
                    cuadrosCatalogo[i] = Cuadro.VACIO;
            }
        }
    }

}
