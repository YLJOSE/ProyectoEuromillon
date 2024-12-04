package com.example.proyectoeuromillon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText email;
    private EditText psswrd;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button = findViewById(R.id.buttonJugar);
        email = findViewById(R.id.emailText);
        psswrd = findViewById(R.id.psswrdText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PantallaJuego.class);
                startActivity(intent);

            }
        });
        // Toast.makeText(this,"Error",Toast.LENGTH_SHORT);
    }


    public boolean validation(View view) {

        Usuarios[] usuarios = Usuarios.values();

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].getEmail().matches(email.toString()) && usuarios[i].getPsswrd().matches(psswrd.toString())) {
                return true;
            }
        }
        return false;
    }
}