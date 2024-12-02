package com.example.proyectoeuromillon;

import static com.example.proyectoeuromillon.JugadaEstrellas.numerosEstrellas;
import static com.example.proyectoeuromillon.PantallaJuego.numeros;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MostrarResultado extends AppCompatActivity {
    public static ArrayList<String> numerosRandom = new ArrayList<>();
    public static ArrayList<String> numerosRandomEstrellas = new ArrayList<>();
    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;

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
        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);

        t1.setText("Tu jugada es:\n " + numeros.get(0) + ", " + numeros.get(1) + ", " + numeros.get(2) + ", " + numeros.get(3) + ", " + numeros.get(4));
        t2.setText("Tu jugada en estrellas es: \n" + numerosEstrellas.get(0) + ", " + numerosEstrellas.get(1));

    }

    @SuppressLint("SetTextI18n")
    public void ver(View view) {
        inicializarJuagadaGanadora();
        String a;
        String d;
        if (numeros.containsAll(numerosRandom)) {
            a = "acertaste todos";
        } else {
            a = "No ganaste!!";
        }
        if (numerosEstrellas.containsAll(numerosRandomEstrellas)) {
            d = "estrellaste todos";
        } else {
            d = "No ganaste!!";
        }
        if (a.equalsIgnoreCase("No ganaste!!") && d.equalsIgnoreCase("No ganaste!!")) {
            Toast.makeText(this, "No ganaste bro!!!", Toast.LENGTH_SHORT).show();
        }

        t4.setText("La jugada  ganadora es:\n " + numerosRandom.get(0) + ", " + numerosRandom.get(1) + ", " + numerosRandom.get(2) + ", " + numerosRandom.get(3) + ", " + numerosRandom.get(4));
        t3.setText("La jugada ganadora en estrellas es:\n " + numerosRandomEstrellas.get(0) + ", " + numerosRandomEstrellas.get(1));
    }

    public void inicializarJuagadaGanadora() {
        boolean o = false;
        while (numerosRandom.size() < 5) {
            Random rnd = new Random();
            int num;

            do {
                num = rnd.nextInt(51);
            } while (num < 1);
            String nn = String.valueOf(num);

            for (int i = 0; i < numerosRandom.size(); i++) {
                if (numerosRandom.get(i).equals(nn)) {
                    o = true;
                }
            }

            if (!o) {
                numerosRandom.add(nn);
            }


        }

        boolean pl = false;
        while (numerosRandomEstrellas.size() < 2) {
            Random rnd = new Random();
            int num;

            do {
                num = rnd.nextInt(13);
            } while (num < 1);
            String nn = String.valueOf(num);

            for (int i = 0; i < numerosRandomEstrellas.size(); i++) {
                if (numerosRandomEstrellas.get(i).equals(nn)) {
                    pl = true;
                }
            }

            if (!pl) {
                numerosRandomEstrellas.add(nn);
            }


        }
    }
}