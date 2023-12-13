package com.san.carteleraextviam.model.entitie;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Integer idPelicula;
   
    private String nombre;

    private Integer duracion;

}
