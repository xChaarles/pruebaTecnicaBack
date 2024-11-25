package com.temperaturaBogota.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ubicacion")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Double longitud;
    private Double latitud;
    private Double temperatura_actual;

}
