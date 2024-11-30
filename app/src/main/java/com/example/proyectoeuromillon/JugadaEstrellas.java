package com.example.proyectoeuromillon;

import static com.example.proyectoeuromillon.PantallaJuego.numeros;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class JugadaEstrellas extends AppCompatActivity {
    private Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jugada_estrellas);
        button = findViewById(R.id.buttonCompletarJugada);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentet = new Intent(JugadaEstrellas.this, MostrarResultado.class);
                startActivity(intentet);
            }
        });

    }
}