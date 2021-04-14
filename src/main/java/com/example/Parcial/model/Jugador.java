package com.example.Parcial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jugador extends Persona{
    private Float peso;
    private Float altura;
    private Integer goles;
    private Integer minutos;
    private String fechaNacimiento;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "monto_id")
    private Moneda moneda;

    @Override
    public TypePersona typePersona() {
        return TypePersona.JUGADOR;
    }

}
