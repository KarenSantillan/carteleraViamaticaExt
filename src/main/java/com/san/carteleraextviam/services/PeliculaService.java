package com.san.carteleraextviam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.san.carteleraextviam.feignclients.PeliculaFeignClient;
import com.san.carteleraextviam.model.entitie.Pelicula;

import feign.FeignException;

@Service
public class PeliculaService {
	
    @Autowired
    private PeliculaFeignClient peliculaFeignClient;

    public String guardarPelicula(@RequestBody Pelicula pelicula){
        validarCampos(pelicula);
        try{
            return peliculaFeignClient.guardarPelicula(pelicula);
        } catch (FeignException e){
        	e.printStackTrace();
            throw new RuntimeException("Hubo un error al guardar la película");
        }

    }

    private void validarCampos(Pelicula pelicula){
        if (pelicula.getNombre() == null || pelicula.getNombre().isEmpty()){
            throw new IllegalArgumentException("Se debe indicar el nombre de la película");
        }
        if (pelicula.getDuracion() == null || pelicula.getDuracion().toString().isEmpty()){
            throw new IllegalArgumentException("Se debe indicar la duración de la película");
        }
    }

}
