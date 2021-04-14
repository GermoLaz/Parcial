package com.example.Parcial.service;

import com.example.Parcial.model.Jugador;
import com.example.Parcial.model.Persona;
import com.example.Parcial.repository.PersonaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PersonaService {
    private PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    public void addPersona(Persona persona) {
        personaRepository.save(persona);
    }

    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    public Persona getPersonByID(Integer id) {
        return personaRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void delete(Integer id) {
        personaRepository.deleteById(id);
    }

    public void addInstrumentToPerson(Integer personaId, Integer jugadorId) {
        Persona persona = getPersonById(personaId);
        Jugador jugador = personaService.getPersonaById(instrumentId);
        persona.getJugadorList().add(jugador);
        personaRepository.save(persona);
    }
}
