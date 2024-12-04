package com.example.proyectoeuromillon;

public enum Usuarios {

    Pedro("Pedro@pedrito.com", "pedrito123"),
    Carlos("Carlos@Carlitos.com", "carlitos123"),
    Luis("Luis@Luisito.com", "lusito123"),
    Lucas("Lucas@Luquita.com", "luquitas123"),
    Cristiano("Cristiano@Cristianito.com", "bicho7");

    private final String email;
    private final String psswrd;

    Usuarios(String email, String contrasenna) {
        this.email = email;
        this.psswrd = contrasenna;
    }

    public String getEmail() {
        return email;
    }

    public String getPsswrd() {
        return psswrd;
    }
}
