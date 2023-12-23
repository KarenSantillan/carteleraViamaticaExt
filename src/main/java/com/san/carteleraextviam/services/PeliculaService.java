package com.san.carteleraextviam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.san.carteleraextviam.feignclients.PeliculaFeignClient;
import com.san.carteleraextviam.model.entitie.Pelicula;

import feign.FeignException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Service
public class PeliculaService {
	
    @Autowired
    private PeliculaFeignClient peliculaFeignClient;

    @Value("${jwt.secret}")
    private String jwtPassw;

    public String guardarPelicula(@RequestBody Pelicula pelicula){
        validarCampos(pelicula);
/*
        Pelicula peliculaExiste = peliculaFeignClient.buscarPelicula(pelicula);
        if (peliculaExiste != null){
            //Existe pelicula -> se genera el token
            String jwtSct = generarTokenJWT(peliculaExiste);
            return jwtSct;
        }else {*/
            try{
                return peliculaFeignClient.guardarPelicula(pelicula);
            } catch (FeignException e){
                e.printStackTrace();
                throw new RuntimeException("Hubo un error al guardar la película");
            }
        //}

    }
    public String findMovieName(@RequestBody Pelicula pelicula){
        validarCampos(pelicula);
        try {
            Pelicula peliculaExiste =  peliculaFeignClient.buscarPelicula(pelicula);
            if (peliculaExiste != null) {
                //Existe pelicula -> se genera el token
                String jwtSct = generarTokenJWT(peliculaExiste);
                return jwtSct;
            }
            else {
                return "La película no existen en base";
            }
        } catch (FeignException e){
            throw new RuntimeException("Hubo un error al buscar la película");
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

    private String generarTokenJWT(Pelicula pelicula){
        return Jwts.builder()
                .setSubject(pelicula.getNombre())
                .claim("id", pelicula.getIdPelicula())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000)) // 3 días de expiración
                .signWith(SignatureAlgorithm.HS512, jwtPassw)
                .compact();

    }
}
