package com.example.proyectoeuromillon;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class PantallaJuego extends AppCompatActivity {
    private Button button, buttonReset;
    private static int iterator = 0;
    public static ArrayList<String> numeros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pantalla_juego);

        Toast toast = Toast.makeText(this, "Si repetiste números, presiona RESET y vuelve a ingresar!!!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 100);
        toast.show();

        button = findViewById(R.id.buttonJugar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaJuego.this, JugadaEstrellas.class);
                startActivity(intent);
            }
        });

        buttonReset = findViewById(R.id.buttonReset);

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeros.clear();
                iterator = 0;
                Toast.makeText(PantallaJuego.this, "Vuelve a ingresar tu jugada", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void confirmarJugada(View view) {
        iterator++;
        if (iterator <= 5) {
            int id = view.getId();
            String nameImage = getResources().getResourceEntryName(id);
            // uso de expresiones regulares
            String strRegex = "\\d+$";
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(strRegex);
            // encontrar la coincidencia
            java.util.regex.Matcher matcher = pattern.matcher(nameImage);
            if (matcher.find()) {
                String mg = matcher.group();
                Toast.makeText(this, "Tu número es: " + matcher.group(), Toast.LENGTH_SHORT).show();
                numeros.add(mg);
            }
            if (iterator == 5) {
                String d = "";
                for (int i = 0; i < numeros.size(); i++) {
                    d += numeros.get(i) + " ";
                }
                Toast.makeText(this, "Tu jugada es: " + d, Toast.LENGTH_LONG).show();
            }

        } else {

            Toast.makeText(this, "Ya no puedes seleccionar más", Toast.LENGTH_LONG).show();

        }

    }
}