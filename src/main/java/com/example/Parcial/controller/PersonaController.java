package com.example.Parcial.controller;

import com.example.Parcial.model.Persona;
import com.example.Parcial.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @PostMapping
    public void addPersona(Persona persona){
        personaService.addPersona(persona);
    }

    @GetMapping
    public List<Persona> getAll(){return personaService.getAll();}

    @GetMapping("/{id}")
    public Persona getPersonById(@PathVariable Integer id) {
        return personaService.getPersonByID(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        personaService.delete(id);
    }

    @PutMapping("/{personaId}/jugador/{jugadorId}")
    public void addJugadorToRepresentante(@PathVariable Integer personaId, @PathVariable Integer jugadorId){
        personaService.addInstrumentToPerson(personaId, jugadorId);
    }


}
