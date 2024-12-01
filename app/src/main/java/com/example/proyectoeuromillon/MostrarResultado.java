package com.example.proyectoeuromillon;

import static com.example.proyectoeuromillon.JugadaEstrellas.numerosEstrellas;
import static com.example.proyectoeuromillon.PantallaJuego.numeros;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MostrarResultado extends AppCompatActivity {
    private TextView t1;
    private TextView t2;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mostrar_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        t1 = findViewById(R.id.textView);
        t2 = findViewById(R.id.textView2);

        t1.setText("Tu jugada es:\n " + numeros.get(0) + ", " + numeros.get(1) + ", " + numeros.get(2) + ", " +numeros.get(3) + ", " + numeros.get(4));
        t2.setText("Tu jugada en estrellas es: \n" + numerosEstrellas.get(0) + ", " + numerosEstrellas.get(1));

    }
}