package com.san.carteleraextviam.controller;

import com.san.carteleraextviam.model.entitie.Pelicula;
import com.san.carteleraextviam.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;
    @PostMapping("/guardarPelicula")
    public String guardarPelicula(@RequestBody Pelicula pelicula){
        return peliculaService.guardarPelicula(pelicula);
    }

    @GetMapping("/findMovieName")
    public String findMovieName(@RequestBody Pelicula pelicula){
        return peliculaService.findMovieName(pelicula);
    }

}
