package com.example.Parcial.model;

public enum TypePersona {
    JUGADOR("Jugador"), REPRESENTANTE("Jugador");

    private String descripcion;

    TypePersona(String descripcion) {
        this.descripcion = descripcion;
    }

    public static TypePersona find(final String value) {
        for (TypePersona v : values()) {
            if (v.toString().equalsIgnoreCase(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid TypePersona: %s", value));
    }

    public String getDescripcion() {
        return descripcion;
    }
}
