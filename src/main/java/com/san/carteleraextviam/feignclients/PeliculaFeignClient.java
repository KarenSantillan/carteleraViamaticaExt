package com.san.carteleraextviam.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.san.carteleraextviam.model.entitie.Pelicula;

@FeignClient(name = "PeliculaService", url = "http://127.0.0.1:8080")
public interface PeliculaFeignClient {

    @PostMapping(path= "/saveMovie", consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    String guardarPelicula(@RequestBody Pelicula pelicula);
}
