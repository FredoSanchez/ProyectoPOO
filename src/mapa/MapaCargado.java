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
                case 0xffff5442:
                    cuadrosCatalogo[i] = Cuadro.LAVA;
                    continue;
                case 0xff5b3026:
                    cuadrosCatalogo[i] = Cuadro.CAVERNA;
                    continue;
                case 0xff2e2533:
                    cuadrosCatalogo[i] = Cuadro.CALDERO;
                    continue;
                case 0xffb88751:
                    cuadrosCatalogo[i] = Cuadro.PIEDRA;
                default:
                    cuadrosCatalogo[i] = Cuadro.VACIO;
            }
        }
    }

}
