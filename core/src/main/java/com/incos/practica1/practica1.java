package com.incos.practica1;

import com.badlogic.gdx.ApplicationAdapter;
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

        // Empezamos a dibujar
        lapiz.begin();

        // Dibujar la imagen en la posición (x = 50, y = 80)
        lapiz.draw(miImagen, 50, 250,200,200);

        // Dibujar texto en pantalla
        miTexto.draw(lapiz, "Mi nombre es Yesmani!", 50, 200);

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
