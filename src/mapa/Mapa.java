/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import Graficos.Pantalla;

/**
 *
 * @author fredy
 */
public abstract class Mapa {
    protected int ancho;
    protected int alto;
    
    protected int[] cuadros;

    public Mapa(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        
        cuadros = new int[ancho * alto];
        generarMapa();
    }

    public Mapa(String ruta) {
        cargarMapa(ruta);
    }
    

    protected void generarMapa() {
        
    }

    private void cargarMapa(String ruta) {
        
    }
    
    public void actualizar(){
        
    }
    
    public void mostrar(int compensacionX, int compensacionY, Pantalla pantalla){
        
    }
    
}
