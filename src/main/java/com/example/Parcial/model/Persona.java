package com.example.Parcial.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typePersona", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Jugador.class, name = "JUGADOR"), @JsonSubTypes.Type(value = Representante.class, name = "REPRESENTANTE")
})
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "El nombre del jugador es requerido")
    private String nombre;
    @NotNull(message = "El apellido del jugador es requerido")
    private String apellido;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract TypePersona typePersona();

}
