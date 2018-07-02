/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

/**
 *
 * @author fredy
 */
public final class Pantalla {

    private final int ancho;
    private final int alto;

    public final int[] pixeles;
    
    //Temporal
    private final static int LADO_SPRITE = 128;
    private final static int MASCARA_SPRITE = LADO_SPRITE - 1;
    //fin temporal

    public Pantalla(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;

        pixeles = new int[ancho * alto];
    }

    public void limpiar() {
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = 0;
        }
    }

    public void mostrar(final int compensacionX, final int compensacionY) {
        for (int y = 0; y < alto; y++) {
            int posicionY = y + compensacionY;
            if (posicionY < 0 || posicionY >= alto) {
                continue;
            }

            for (int x = 0; x < ancho; x++) {
                int posicionX = x + compensacionX;
                if (posicionX < 0 || posicionX >= ancho) {
                    continue;
                }
                
                //temporal
                pixeles[posicionX + posicionY * ancho] = Sprite.ASFALTO.pixeles[(x & MASCARA_SPRITE) + (y & MASCARA_SPRITE) * LADO_SPRITE ];
            }
        }
    }
}
