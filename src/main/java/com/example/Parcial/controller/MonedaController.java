package com.example.Parcial.controller;

import com.example.Parcial.model.Moneda;
import com.example.Parcial.model.Persona;
import com.example.Parcial.service.MonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moneda")
public class MonedaController {

    @Autowired
    MonedaService monedaService;

    @PostMapping
    public void addMoneda(@RequestBody Moneda moneda){monedaService.addMoneda(moneda);}

    @GetMapping
    public List<Moneda> getAll(){return monedaService.getAll();}

    @GetMapping("/{id}")
    public Moneda getMonedaById(@PathVariable Integer id) {
        return monedaService.getMonedaByID(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        monedaService.delete(id);
    }
}
