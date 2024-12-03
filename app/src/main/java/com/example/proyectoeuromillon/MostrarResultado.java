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
    private TextView t5;
    private TextView t6;
    private TextView t7;
    private TextView t8;

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

        t1 = findViewById(R.id.tvUno);
        t2 = findViewById(R.id.tvDos);
        t3 = findViewById(R.id.tvTres);
        t4 = findViewById(R.id.tvCuatro);
        t5 = findViewById(R.id.tvCinco);
        t6 = findViewById(R.id.tvEstrella1);
        t7 = findViewById(R.id.tvEstrella2);
        t8 = findViewById(R.id.tvResultado);

        t1.setText(numeros.get(0));
        t2.setText(numeros.get(1));
        t3.setText(numeros.get(2));
        t4.setText(numeros.get(3));
        t5.setText(numeros.get(4));
        t6.setText(numerosEstrellas.get(0));
        t7.setText(numerosEstrellas.get(1));


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
            Toast.makeText(this, "No ganaste bro!!!", Toast.LENGTH_LONG).show();
        }

        t8.setText(numerosRandom.get(0) + ", " + numerosRandom.get(1) + ", " + numerosRandom.get(2) + ", " + numerosRandom.get(3) + ", " + numerosRandom.get(4) + " y " + numerosRandomEstrellas.get(0) + ", " + numerosRandomEstrellas.get(1) + ", " );


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