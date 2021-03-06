/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author ferna
 */
public class HojasSprites {

    public final int[] pixeles;
    private final int ancho;
    private final int alto;
    
    //coleccion de hojas de sprites
    public static HojasSprites desierto = new HojasSprites("/texturas/prueba.png",1024,1024);
    public static HojasSprites jugador = new HojasSprites("/texturas/jugador.png",320,320);
    //fin de la coleccion

    public HojasSprites(final String ruta, final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;

        pixeles = new int[ancho * alto];

        BufferedImage imagen;
        
        //Se leen datos y puede que tenga error de ruta o inexistencia
        try {
            imagen = ImageIO.read(HojasSprites.class.getResource(ruta));    
            //(xInicial, yInicial , ancho, alto, array, desplazamiento, tamañoScaneo)
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public int getAncho(){
        return ancho;
    }
}
