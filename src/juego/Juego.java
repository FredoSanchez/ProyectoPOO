/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import Controles.Teclado;
import Graficos.Pantalla;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author ferna
 */
public class Juego extends Canvas implements Runnable{
    
     private static final long serialVersionUID = 1L;//Identificador por defecto de serie
        
    private static final int ANCHO = 800;
    private static final int ALTO = 600;
    private static volatile boolean enFuncionamiento = false;
    
    private static final String NOMBRE = "Inferno Dante";
    private static int aps = 0;
    private static int fps = 0;
    
    private static int x = 0;
    private static int y = 0;
    
    private static JFrame ventana;
    private static Thread thread;
    private static Teclado teclado;
    private static Pantalla pantalla;
    
    
    private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
    //No se carga la imagen de una sola vez sino que se separa por pixeles
    private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
    
    private static final ImageIcon Icono = new ImageIcon(Juego.class.getResource("/icono/icono.png"));
    
    private Juego(){
        setPreferredSize(new Dimension(ANCHO,ALTO));
        
        pantalla = new Pantalla(ANCHO, ALTO);
        
        teclado = new Teclado();
        addKeyListener(teclado);
        
        ventana = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setIconImage(Icono.getImage());
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
    }
    
    public static void main(String[] args){
        Juego juego = new Juego();
        juego.iniciar();
    }
    
    private synchronized void iniciar(){
        enFuncionamiento = true;
        
        thread = new Thread(this,"Graficos");
        thread.start();
    }
    
    private synchronized void detener(){
        enFuncionamiento = false;
        
        try {
            thread.join();//Espera que se termine de ejecutar el Thread y no lo cierra abruptamente a diferencia de thread.stop()
        } catch (InterruptedException e) {
            e.printStackTrace();
        }   
    }
    
    private void actualizar(){
        teclado.actualizar();
        
        if(teclado.arriba){
            y++;
        }
        
        if(teclado.abajo){
            y--;
        }
        
        if(teclado.izquierda){
            x++;
        }
        
        if(teclado.derecha){
            x--;
        }
        
        aps++;
        
        
    }
    
    private void mostrar(){
        //Buffer espacio de memoria que guarda cosas
        BufferStrategy estrategia = getBufferStrategy();
        if(estrategia == null){            
            createBufferStrategy(3);
            return;
        }
        
        pantalla.limpiar();
        pantalla.mostrar(x, y);
        
        //copia el bucle for de la pantalla al bucle for del juego
        System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);
        
        //for(int i =0; i<pixeles.length; i++){
        //    pixeles[i]=pantalla.pixeles[i];
        //}
        
        
        Graphics g = estrategia.getDrawGraphics();
        
        //Dibuja la imagen
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        //vacia la memoria que g ocupaba
        g.setColor(Color.white);
        g.fillRect(ANCHO/2, ALTO/2, 32, 32);
        g.dispose();
        
        //muestra la imagen
        estrategia.show();
        
        fps++;
    }

    @Override
    public void run() {
        final int NS_POR_SEGUNDO = 1000000000;
        final byte APS_OBJETIVO = 60; // APS= FPS que se quieren conseguir
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO/APS_OBJETIVO;
        
        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        double  tiempoTranscurrido;
        double delta = 0;
        
        requestFocus();
        
         while(enFuncionamiento){
            final long inicioBucle = System.nanoTime();
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;
            
            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
            
            while(delta >= 1){
                actualizar();
                delta--;
            }
            
           mostrar();
           
           if(System.nanoTime() - referenciaContador >  NS_POR_SEGUNDO){
               ventana.setTitle(NOMBRE+ " || APS:" + aps + " || FPS: " + fps );
               aps = 0;
               fps = 0;
               referenciaContador = System.nanoTime();
           }
        }
    }
    
    
}
