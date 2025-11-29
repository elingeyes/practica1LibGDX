package com.incos.practica1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class practica1 extends ApplicationAdapter {
    // Herramientas para dibujar
    private SpriteBatch lapiz;       // Dibuja imágenes y texto
    private Texture miImagen;        // Una imagen simple
    private BitmapFont miTexto;      // Para escribir palabras en pantalla
    //Variables
    private float x = 50;      // posición inicial en X
    private float y = 250;     // posición inicial en Y
    //private float velocidadX = 2; // velocidad horizontal
    //private float velocidadY = 2;    // Velocidad vertical

    // Velocidad para moverse hacia el toque
    private float velocidad = 200;  // pixeles por segundo

    @Override
    public void create() {
        // Se ejecuta UNA sola vez al iniciar el juego
        lapiz = new SpriteBatch();

        // Cargar una imagen desde la carpeta assets
        miImagen = new Texture("logo_incos.png");

        // Crear un texto básico
        miTexto = new BitmapFont();
    }

    @Override
    public void render() {
        // Limpiar la pantalla (fondo) con un color
        // Valores entre 0 y 1 → Rojo, Verde, Azul
        //ScreenUtils.clear(0.2f, 0.5f, 1f, 1f);
        //ScreenUtils.clear(51f/255f, 100f/255f, 100f/255f, 088f/255f);

        Color color = Color.valueOf("#000000"); // HEX
        ScreenUtils.clear(color.r, color.g, color.b, color.a);

       /* x += velocidadX; // moverse a la derecha
        y += velocidadY;
        // Rebote horizontal
        if (x > 400 || x < 0) {
            velocidadX = -velocidadX;
        }

        // Rebote vertical
        if (y > 500 || y < 0) {
            velocidadY = -velocidadY;
        }*/

        // Tiempo entre frames para movimiento suave
        float delta = Gdx.graphics.getDeltaTime();

        if (Gdx.input.isTouched()) {
            float toqueX = Gdx.input.getX();
            float toqueY = Gdx.graphics.getHeight() - Gdx.input.getY(); // invertir eje

            // Mover la imagen hacia el toque
            if (x < toqueX) x += velocidad * delta;
            if (x > toqueX) x -= velocidad * delta;

            if (y < toqueY) y += velocidad * delta;
            if (y > toqueY) y -= velocidad * delta;
        }


        // Empezamos a dibujar
        lapiz.begin();

        // Dibujar la imagen en la posición (x = 50, y = 80)
        lapiz.draw(miImagen, x, y,200,200);

        // Dibujar texto en pantalla
        miTexto.draw(lapiz, "Movimiento del logo", 50, 200);

        // Terminamos de dibujar
        lapiz.end();
    }

    @Override
    public void dispose() {
        // Liberar memoria al cerrar la app
        lapiz.dispose();
        miImagen.dispose();
        miTexto.dispose();
    }
}
