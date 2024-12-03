package com.example.proyectoeuromillon;

import static java.lang.Thread.sleep;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class JugadaEstrellas extends AppCompatActivity {
    private Button button, buttonReset;
    private static int iterator = 0;
    public static ArrayList<String> numerosEstrellas = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jugada_estrellas);

        Toast toast = Toast.makeText(this, "Si repetiste números, presiona RESET y vuelve a ingresar!!!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 100);
        toast.show();

        button = findViewById(R.id.buttonCompletarJugada);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentet = new Intent(JugadaEstrellas.this, MostrarResultado.class);
                startActivity(intentet);
            }
        });
        buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numerosEstrellas.clear();
                iterator = 0;
                Toast.makeText(JugadaEstrellas.this, "Vuelve a ingresar tu jugada", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void confirmarJugadaEstrellas(View view) {
        iterator++;
        if (iterator <= 2) {
            int id = view.getId();
            String nameImage = getResources().getResourceEntryName(id);
            // uso de expresiones regulares
            String strRegex = "\\d+$";
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(strRegex);
            // encontrar la coincidencia
            java.util.regex.Matcher matcher = pattern.matcher(nameImage);
            if (matcher.find()) {
                String mg = matcher.group();
                Toast.makeText(this, "Tu número es: " + mg, Toast.LENGTH_SHORT).show();
                numerosEstrellas.add(mg);
            }
            if (iterator == 2) {
                String d = "";
                for (int i = 0; i < numerosEstrellas.size(); i++) {
                    d += numerosEstrellas.get(i) + " ";
                }
                Toast.makeText(this, "Tu jugada es: " + d, Toast.LENGTH_LONG).show();
            }

        } else {

            Toast.makeText(this, "Ya no puedes seleccionar más", Toast.LENGTH_LONG).show();

        }
    }
}