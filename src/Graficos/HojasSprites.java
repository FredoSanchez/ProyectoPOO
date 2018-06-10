/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ferna
 */
public class HojasSprites {
    public final int[] pixeles;
    private final int ancho;
    private final int alto;
    
    public HojasSprites(final String ruta, final int ancho,final int alto){
        this.ancho = ancho;
        this.alto = alto;
        
        pixeles = new int[ancho * alto];
        
        BufferedImage imagen = null;
        try {
            imagen.getRGB(0,0,ancho, alto, pixeles, 0, ancho);
            imagen = ImageIO.read(HojasSprites.class.getResource(ruta));
        } catch (IOException e) {
           e.printStackTrace();
        }
        
        
    }
}
