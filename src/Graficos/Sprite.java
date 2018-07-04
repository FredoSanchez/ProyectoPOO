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
    
    //Coleccion de sprites del personaje
    public static final Sprite ABAJO0 = new Sprite(32, 0, 0, 0, HojasSprites.jugador);
    public static final Sprite ABAJO1 = new Sprite(32, 0, 1, 0, HojasSprites.jugador);
    public static final Sprite ABAJO2 = new Sprite(32, 0, 2, 0, HojasSprites.jugador);
    
    public static final Sprite ARRIBA0 = new Sprite(32, 1, 0, 0, HojasSprites.jugador);
    public static final Sprite ARRIBA1 = new Sprite(32, 1, 1, 0, HojasSprites.jugador);
    public static final Sprite ARRIBA2 = new Sprite(32, 1, 2, 0, HojasSprites.jugador);
    
    public static final Sprite DERECHA0 = new Sprite(32, 2, 0, 0, HojasSprites.jugador);
    public static final Sprite DERECHA1 = new Sprite(32, 2, 1, 0, HojasSprites.jugador);
    public static final Sprite DERECHA2 = new Sprite(32, 2, 2, 0, HojasSprites.jugador);
    
    public static final Sprite IZQUIERDA0 = new Sprite(32, 3, 0, 0, HojasSprites.jugador);
    public static final Sprite IZQUIERDA1 = new Sprite(32, 3, 1, 0, HojasSprites.jugador);
    public static final Sprite IZQUIERDA2 = new Sprite(32, 3, 2, 0, HojasSprites.jugador);
    //Fin de la coleccion de sprites del personaje

    //Coleccion de sprites
    public static final Sprite VACIO = new Sprite(32, 0);
    public static final Sprite CAVERNA = new Sprite(32, 1, 8, 0, HojasSprites.desierto);
    public static final Sprite LAVA = new Sprite(32, 16, 11, 0, HojasSprites.desierto);
    public static final Sprite CALDERO = new Sprite(32, 19, 13, 0, HojasSprites.desierto);
    public static final Sprite GRIETA = new Sprite(32, 18, 11, 0, HojasSprites.desierto);
    public static final Sprite PARED = new Sprite(32, 19, 11, 0, HojasSprites.desierto);
    public static final Sprite PUERTA1 = new Sprite(32, 4, 24, 0, HojasSprites.desierto);
    public static final Sprite PUERTA1D = new Sprite(32, 4, 24, 1, HojasSprites.desierto);
    //public static final Sprite PUERTA2 = new Sprite(32, 5, 24, 0, HojasSprites.desierto);
    public static final Sprite PUERTA3 = new Sprite(32, 4, 25, 0, HojasSprites.desierto);
     public static final Sprite PUERTA3D = new Sprite(32, 4, 25, 1, HojasSprites.desierto);
   // public static final Sprite PUERTA4 = new Sprite(32, 5, 25, 0, HojasSprites.desierto);
    public static final Sprite PUERTA5 = new Sprite(32, 4, 26, 0, HojasSprites.desierto);
    public static final Sprite PUERTA5D = new Sprite(32, 4, 26, 1, HojasSprites.desierto);
    //public static final Sprite PUERTA6 = new Sprite(32, 5, 26, 0, HojasSprites.desierto);
    public static final Sprite PISO = new Sprite(32, 19, 22, 0, HojasSprites.desierto);
    
    public static final Sprite HOYOLAVA = new Sprite(32, 15, 6, 0,HojasSprites.desierto);
    public static final Sprite PIEDRA = new Sprite(32, 18, 6, 0,HojasSprites.desierto);
    public static final Sprite CAVERNALAVA = new Sprite(32, 21, 6, 0,HojasSprites.desierto);
    public static final Sprite LAVANEGRO = new Sprite(32, 17, 11, 0,HojasSprites.desierto);

    //Faltan más Sprites..
    //Fin de la coleccion de sprites
    public Sprite(final int lado, final int columna, final int fila, final int version, final HojasSprites hoja) {
        this.lado = lado;

        pixeles = new int[lado * lado];

        this.x = columna * lado;
        this.y = fila * lado;
        this.hoja = hoja;

        cargarSprite(version);

    }

    public Sprite(final int lado, final int color) {
        this.lado = lado;
        pixeles = new int[lado * lado];

        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = color;
        }
    }

    public int getLado() {
        return lado;
    }

    private void cargarSprite(int version) {
        if (version == 0) {
            cargaNormal();
        } else {
            cargaManipulada(version);
        }
    }

    private void cargaNormal() {
        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
            }
        }
    }

    private void cargaManipulada(int version) {
        int[] pixelesTemporales = iniciarPixelesTemporales();

        switch (version) {
            case 1:
                invertirX(pixelesTemporales);
                break;
            case 2:
                invertirY(pixelesTemporales);
                break;
            case 3:
                invertirXY(pixelesTemporales);
                break;
            case 4:
                rotar90I(pixelesTemporales);
                break;
            case 5:
                rotar90D(pixelesTemporales);
                break;
            case 6:
                rotarI90InvertirY(pixelesTemporales);
                break;
            case 7:
                rotarD90InvertidoY(pixelesTemporales);
                break;
            default:
                cargaNormal();
        }
    }

    private int[] iniciarPixelesTemporales() {
        int[] pixelesTemporales = new int[lado * lado];

        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixelesTemporales[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
            }
        }

        return pixelesTemporales;
    }

    /**
     * Estos son metodos que van ir en la funcion iniciarPixelesTemporales Y asi
     * poder invertir los sprites
     *
     * @param pixelesTemporales
     */
    //1
    private void invertirX(int[] pixelesTemporales) {
        int i = 0;
        for (int y = 0; y < lado; y++) {
            for (int x = lado - 1; x > -1; x--) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
    }

    //2
    private void invertirY(int[] pixelesTemporales) {
        int i = 0;
        for (int y = lado - 1; y > -1; y--) {
            for (int x = 0; x < lado; x++) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
    }

    //3
    private void invertirXY(int[] pixelesTemporales) {
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = pixelesTemporales[pixelesTemporales.length - 1 - i];
        }
    }

    //4
    private void rotar90I(int[] pixelesTemporales) {
        int i = 0;
        for (int x = lado - 1; x > -1; x--) {
            for (int y = 0; y < lado; y++) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
    }

    //5
    private void rotar90D(int[] pixelesTemporales) {
        int i = 0;
        for (int x = 0; x < lado; x++) {
            for (int y = lado - 1; y > -1; y--) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
    }

    //6
    private void rotarI90InvertirY(int[] pixelesTemporales) {
        int i = 0;
        for (int x = 0; x < lado; x++) {
            for (int y = 0; y < lado; y++) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
    }

    //7
    private void rotarD90InvertidoY(int[] pixelesTemporales) {
        int i = 0;
        for (int x = lado - 1; x > -1; x--) {
            for (int y = lado - 1; y > -1; y--) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
    }
}
