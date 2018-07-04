/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import Graficos.Pantalla;
import mapa.cuadro.Cuadro;

/**
 *
 * @author fredy
 */
public abstract class Mapa {

    protected int ancho;
    protected int alto;

    protected int[] cuadros;
    protected Cuadro[] cuadrosCatalogo;

    public Mapa(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;

        cuadros = new int[ancho * alto];
        generarMapa();
    }

    public Mapa(String ruta) {
        cargarMapa(ruta);
        generarMapa();
    }

    protected void generarMapa() {

    }

    protected void cargarMapa(String ruta) {

    }

    public void actualizar() {

    }

    public void mostrar(int compensacionX, int compensacionY, Pantalla pantalla) {
        
        pantalla.setDiferencia(compensacionX, compensacionY);
        
        //oeste
        int o = compensacionX >> 5;//BitShifting en vez de división para rendimiento.
        //este
        int e = (compensacionX + pantalla.getAncho()+Cuadro.LADO) >> 5;
        //norte
        int n = compensacionY >> 5;
        //sur
        int s = (compensacionY + pantalla.getAlto()+Cuadro.LADO) >> 5;
        
        for(int y=n; y<s;y++){
            for(int x=o;x<e;x++){
                //getCuadro(x,y).mostrar(x, y, pantalla); //
                if(x < 0 || y < 0 || x >= ancho || y >= alto){
                    Cuadro.VACIO.mostrar(x, y, pantalla);
                }else{
                    cuadrosCatalogo[x + y * ancho].mostrar(x, y, pantalla);
                }
            }
        }
    }

    public Cuadro getCuadro(final int x, final int y) {
        if(x<0 || y<0 || x>= ancho || y>= alto){
        return Cuadro.VACIO;  //dibuja cuadro vacio al salirse de la dimension de pantalla
    }
        switch (cuadros[x + y * ancho]) {
            case 0:
                return Cuadro.CAVERNA;

            case 1:
                return Cuadro.LAVA;

            case 2:
                return Cuadro.CALDERO;

            case 3:
                return Cuadro.GRIETA;

            case 4:
                return Cuadro.PARED;

            case 5:
                return Cuadro.PUERTA1;

            case 6:
                return Cuadro.PUERTA2;

            case 7:
                return Cuadro.PUERTA3;

            case 8:
                return Cuadro.PUERTA4;

            case 9:
                return Cuadro.PUERTA5;
                
                case 10:
                return Cuadro.PUERTA6;

            case 11:
                return Cuadro.PISO;
   

            default:
                return Cuadro.VACIO;
        }

    }

}
