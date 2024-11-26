package com.temperaturaBogota.Dto;

import com.temperaturaBogota.Entidades.Ubicacion;
import lombok.Data;

import java.util.List;

@Data
public class UbicacionDto {

    private int statuscode;
    private String message;
    private Integer id;
    private String nombre;
    private Double longitud;
    private Double latitud;
    private Double temperatura_actual;
    private Ubicacion ubicacion;
    private List<Ubicacion> ubicacionList;

}
