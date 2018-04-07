package com.example.maria.juegomemoria;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Random;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    //Guarda las cartas en un vector
    private static final int[] CARTA_RESOURCES = new int[]{
            R.drawable.imagen1,
            R.drawable.imagen2,
            R.drawable.imagen3,
            R.drawable.imagen4,
            R.drawable.imagen1Copy,
            R.drawable.imagen2Copy,
            R.drawable.imagen3Copy,
            R.drawable.imagen4Copy
    };

    private Carta[] cartas;
    private boolean touchActivo = true;
    private Carta visible = null;

    //Cuándo se corre la aplicación ejecuta el onCreate, solo se llama una vez para llamar al layout. Es el método más importante.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Carga el XML Layout. Sin esta línea no carga el Layout y no muestra nada. R es una instancia de todas las clases, es global.
    }

    private class Carta implements View.OnClickListener{

        private final ImageButton boton;
        private final int imagen;
        private boolean caraVisible = false;
        Carta(final int imagen) {
            this.imagen = imagen;
            this.boton = new ImageButton(MainActivity.this);
            this.boton.setOnClickListener(this);
        }

        void setCaraVisible(final boolean caraVisible){
            this.caraVisible = caraVisible;
        }

        @Override
        public void onClick(View v) {
            if(!caraVisible&&touchActivo){
                onCartaDescubierta(this);
            }
        }
    }

    private void onCartaDescubierta(Carta carta) {
    }
}
