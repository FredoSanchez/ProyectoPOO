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
    private HojasSprites hoja;
    
    //Coleccion de sprites
    
    public static final Sprite VACIO = new Sprite(32, 0);
    public static final Sprite CAVERNA = new Sprite(32, 1 , 8 , HojasSprites.desierto);
    public static final Sprite LAVA = new Sprite(32, 17, 11, HojasSprites.desierto);
    public static final Sprite CALDERO = new Sprite(32, 19, 13, HojasSprites.desierto);
    public static final Sprite GRIETA = new Sprite(32, 18, 11, HojasSprites.desierto);
    public static final Sprite PARED = new Sprite(32, 19, 11, HojasSprites.desierto);
    public static final Sprite PUERTA1 = new Sprite(32, 4, 24, HojasSprites.desierto);
    public static final Sprite PUERTA2 = new Sprite(32, 5, 24, HojasSprites.desierto);
    public static final Sprite PUERTA3 = new Sprite(32, 4, 25, HojasSprites.desierto);
    public static final Sprite PUERTA4 = new Sprite(32, 5, 25, HojasSprites.desierto);
    public static final Sprite PUERTA5 = new Sprite(32, 4, 26, HojasSprites.desierto);
    public static final Sprite PUERTA6 = new Sprite(32, 5, 26, HojasSprites.desierto);
    public static final Sprite PISO = new Sprite(32, 12, 5, HojasSprites.desierto);
    
    //Faltan más Sprites..
  
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

    public Sprite(final int lado, final int color) {
        this.lado = lado;
        pixeles= new int[lado*lado];
        
        for(int i=0;i<pixeles.length;i++){
            pixeles[i]=color;
        }
    }
    

    public int getLado() {
        return lado;
    }
}
