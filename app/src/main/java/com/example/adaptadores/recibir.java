package com.example.adaptadores;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class recibir extends AppCompatActivity {

    String nombre, titulo, mensaje, hora, telefono, pais;
    TextView textoNombre, textoTitulo,  textoTelefono, textoPais, textoMsm;
    int imagen;
    CircleImageView image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recibir);

        textoNombre = findViewById(R.id.textoNombre);
        textoTitulo = findViewById(R.id.textoTitulo);
        textoMsm = findViewById(R.id.textoMensaje);
        textoTelefono = findViewById(R.id.telefono);
        textoPais = findViewById(R.id.pais);

        image = findViewById(R.id.imagen);


        Intent datos = getIntent();
        if (datos != null) {
            nombre = datos.getStringExtra("nombre");
            titulo = datos.getStringExtra("titulo");
            mensaje = datos.getStringExtra("mensaje");
            hora = datos.getStringExtra("hora");
            telefono = datos.getStringExtra("telefono");
            pais = datos.getStringExtra("pais");
            imagen = datos.getIntExtra("imagen", R.drawable.lavoe);

            textoPais.setText(pais);
            textoNombre.setText(nombre);
            textoTelefono.setText(telefono);
            textoTitulo.setText(titulo);
            image.setImageResource(imagen);
            textoMsm.setText(mensaje);
        }
    }
}