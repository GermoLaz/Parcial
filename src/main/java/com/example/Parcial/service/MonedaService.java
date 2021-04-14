package com.example.Parcial.service;

import com.example.Parcial.model.Moneda;
import com.example.Parcial.repository.MonedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class MonedaService {
    private MonedaRepository monedaRepository;

    @Autowired
    public MonedaService(MonedaRepository monedaRepository){
        this.monedaRepository = monedaRepository;
    }

    public void addMoneda(Moneda moneda) {
        monedaRepository.save(moneda);
    }

    public List<Moneda> getAll() {
        return monedaRepository.findAll();
    }

    public Moneda getMonedaByID(Integer id) {
        return monedaRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void delete(Integer id) {
        monedaRepository.deleteById(id);
    }
}
