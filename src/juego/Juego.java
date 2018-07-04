/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import Controles.Teclado;
import Graficos.Pantalla;
import Graficos.Sprite;
import entes.criaturas.Jugador;
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
import mapa.Mapa;
import mapa.MapaCargado;
import mapa.MapaGenerado;

/**
 *
 * @author ferna
 */
public class Juego extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;//Identificador por defecto de serie

    private static final int ANCHO = 800;
    private static final int ALTO = 600;
    private static volatile boolean enFuncionamiento = false;

    private static final String NOMBRE = "Inferno Dante";

    private static String CONTADOR_APS = "";
    private static String CONTADOR_FPS = "";

    private static int aps = 0;
    private static int fps = 0;

    private static JFrame ventana;
    private static Thread thread;
    private static Teclado teclado;
    private static Pantalla pantalla;
    private static Mapa mapa;
    private static Jugador jugador;

    private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
    //No se carga la imagen de una sola vez sino que se separa por pixeles
    private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();

    private static final ImageIcon Icono = new ImageIcon(Juego.class.getResource("/icono/icono.png"));

    private Juego() {
        setPreferredSize(new Dimension(ANCHO, ALTO));

        pantalla = new Pantalla(ANCHO, ALTO);

        //mapa= new MapaGenerado(128,128); //128 Tiles ancho por 128 tiles alto
        teclado = new Teclado();
        addKeyListener(teclado);

        mapa = new MapaCargado("/mapas/mapa1.png");
        jugador = new Jugador(teclado, Sprite.ARRIBA0, 240, 225);

        ventana = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setIconImage(Icono.getImage());
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.setUndecorated(true);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciar();
    }

    private synchronized void iniciar() {
        enFuncionamiento = true;

        thread = new Thread(this, "Graficos");
        thread.start();
    }

    private synchronized void detener() {
        enFuncionamiento = false;

        try {
            thread.join();//Espera que se termine de ejecutar el Thread y no lo cierra abruptamente a diferencia de thread.stop()
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void actualizar() {
        teclado.actualizar();

        jugador.actualizar();

        if (teclado.salir) {
            System.exit(0);
        }
        aps++;

    }

    private void mostrar() {
        //Buffer espacio de memoria que guarda cosas
        BufferStrategy estrategia = getBufferStrategy();
        if (estrategia == null) {
            createBufferStrategy(3);
            return;
        }

        //pantalla.limpiar();
        // La clase Jugador se encarga de mover el mapa
        mapa.mostrar(jugador.obtenerPosicionX() - pantalla.getAncho()/2 + jugador.getSprite().getLado()/2, 
                jugador.obtenerPosicionY() - pantalla.getAlto()/2 + jugador.getSprite().getLado()/2, pantalla);
        jugador.mostrar(pantalla);
        //copia el bucle for de la pantalla al bucle for del juego
        System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);

        //for(int i =0; i<pixeles.length; i++){
        //    pixeles[i]=pantalla.pixeles[i];
        //}
        Graphics g = estrategia.getDrawGraphics();

        //Dibuja la imagen
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        //vacia la memoria que g ocupaba
        g.setColor(Color.red);
        g.drawString(CONTADOR_APS, 10, 20);
        g.drawString(CONTADOR_FPS, 10, 35);
        g.drawString("X:" + jugador.obtenerPosicionX(), 10, 50);
        g.drawString("Y: " + jugador.obtenerPosicionY(), 10, 60);
        g.dispose();

        //muestra la imagen
        estrategia.show();

        fps++;
    }

    @Override
    public void run() {
        final int NS_POR_SEGUNDO = 1000000000;
        final byte APS_OBJETIVO = 60; // APS= FPS que se quieren conseguir
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        double tiempoTranscurrido;
        double delta = 0;

        requestFocus();

        while (enFuncionamiento) {
            final long inicioBucle = System.nanoTime();
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;

            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

            while (delta >= 1) {
                actualizar();
                delta--;
            }

            mostrar();

            if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
                CONTADOR_APS = "APS:" + aps;
                CONTADOR_FPS = "FPS:" + fps;

                aps = 0;
                fps = 0;
                referenciaContador = System.nanoTime();
            }
        }
    }

}
