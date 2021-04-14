package com.example.Parcial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Representante extends Persona{
    private Float pesoDeLaBoveda;
    private Float montoTotal;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "jugador_id")
    List<Jugador> jugadores;

    @Override
    public TypePersona typePersona() {
        return TypePersona.REPRESENTANTE;
    }

}
