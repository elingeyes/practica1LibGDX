package com.incos.practica1;

import com.badlogic.gdx.ApplicationAdapter;
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

    @Override
    public void create() {
        // Se ejecuta UNA sola vez al iniciar el juego
        lapiz = new SpriteBatch();

        // Cargar una imagen desde la carpeta assets
        miImagen = new Texture("libgdx.png");

        // Crear un texto básico
        miTexto = new BitmapFont();
    }

    @Override
    public void render() {
        // Limpiar la pantalla (fondo) con un color
        // Valores entre 0 y 1 → Rojo, Verde, Azul
        ScreenUtils.clear(0, 0, 0, 1); // fondo negro

        // Empezamos a dibujar
        lapiz.begin();

        // Dibujar la imagen en la posición (x = 50, y = 80)
        lapiz.draw(miImagen, 50, 80);

        // Dibujar texto en pantalla
        miTexto.draw(lapiz, "Hola, este es mi primer juego!", 50, 200);

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
