package com.example.proyectoeuromillon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class PantallaJuego extends AppCompatActivity {
    private Button button;
    private static int iterator=0;
    public static ArrayList<String> numeros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pantalla_juego);


        button = findViewById(R.id.buttonJugar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaJuego.this, JugadaEstrellas.class);
                startActivity(intent);
            }
        });
     }

    public void confirmarJugada(View view) {
        iterator++;
        if(iterator==5){
            Toast.makeText(this,"Ya no puedes seleccionar más",Toast.LENGTH_SHORT).show();
        }
        int id = view.getId();
        String nameImage = getResources().getResourceEntryName(id);
        numeros.add(nameImage);
        Toast.makeText(this, "Imagen clicada: " + nameImage, Toast.LENGTH_SHORT).show();

    }
}