/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

/**
 *
 * @author ferna
 */
public final class Sprite {
    private final int lado;
    
    private int x;
    private int y;
    
    public int[] pixeles;
    private final HojasSprites hoja;
    
    //Coleccion de sprites
    public static Sprite ASFALTO = new Sprite(32, 0 , 8 , HojasSprites.desierto);
    //Fin de la coleccion de sprites
    
    public Sprite(final int lado, final int columna,final int fila,final HojasSprites hoja){
        this.lado = lado;
        
        pixeles = new int[lado * lado];
        
        this.x = columna * lado;
        this.y = fila * lado;
        this.hoja = hoja;
        
        for(int y = 0; y < lado;y++){
            for(int x = 0; x < lado; x++){
                pixeles[x + y *lado] =  hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
            }
        }
    }
}
