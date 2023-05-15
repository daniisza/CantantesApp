package com.example.adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] idImagen = {
              R.drawable.lavoe,
              R.drawable.frankie,
              R.drawable.tito,
              R.drawable.vic,
              R.drawable.dcastro,
              R.drawable.maelo,
              R.drawable.tony,
        };
        String[] nombres = {
                "Hector Lavoe", "Frankie Ruiz", "Tito Rojas", "Victor Manuelle", "Alex D´Castro", "Maelo Ruiz", "Tony Vega"
        };
        String[] title ={
                "Fallecimiento: 29 de junio de 1993", "Fallecimiento: 9 de agosto de 1998", "Fallecimiento: 26 de diciembre de 2020", " Nació en Salinas, Puerto Rico", "Es un cantante estadounidense de origen puertorriqueño de salsa", "Realmente comenzó su carrera profesional en la música cuando se convirtió en la primera voz de Pedro Conga y su Orquesta Internacional.", "Un reconocido artista de salsa cristiana"
        };
        String[] mensajes = {
                "Hola, por favor enviar la información...", "Tienes una nueva notificación", "Intentaste acceder a tu cuenta...", "Por referir a un amigo reclama 5000", "Adquiere tu nuevo vehículo", "Que quieres comer hoy?", "Nuevo mensaje de usuario..."
        };

        String[] horaUltimoMensaje ={
                "7:25", "10:15", "22:36", "11:55", "10:05", "21:20", "8:45"
        };
        String[] instrumento ={
                "Güiro", "Campana", "Congas", "Timbal", "Trompeta", "Maracas", "Clave"
        };
        String[] pais = {
                "Puerto Rico", "Usa - Puerto Rico", "Puerto Rico", "Puerto Rico", "Usa - Puerto Rico", "Usa - Puerto Rico", "Puerto Rico"
        };

        listAdapter listAdapter = new listAdapter(MainActivity.this, nombres, title, mensajes,  horaUltimoMensaje, instrumento,pais, idImagen);
        lista = (ListView) findViewById(R.id.listaView);
        lista.setAdapter(listAdapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent irAinformacion = new Intent(MainActivity.this, recibir.class)
                        .putExtra("nombre", nombres[position])
                        .putExtra("titulo", title[position])
                        .putExtra("mensaje", mensajes[position])
                        .putExtra("hora", horaUltimoMensaje[position])
                        .putExtra("telefono", instrumento[position])
                        .putExtra("pais", pais[position])
                        .putExtra("imagen", idImagen[position]);

                startActivity(irAinformacion);
            }
        });
    }
}