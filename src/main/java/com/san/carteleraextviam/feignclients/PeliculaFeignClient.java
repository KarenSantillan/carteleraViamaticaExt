package com.san.carteleraextviam.feignclients;

import com.san.carteleraextviam.model.entitie.Pelicula;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PeliculaService", url = "http://127.0.0.1:8080")
public interface PeliculaFeignClient {

    @PostMapping("/guardarPelicula")
    Pelicula guardarPelicula(@RequestBody Pelicula pelicula);
}
