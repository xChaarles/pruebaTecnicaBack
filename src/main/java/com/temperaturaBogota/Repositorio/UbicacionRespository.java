package com.temperaturaBogota.Repositorio;

import com.temperaturaBogota.Entidades.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionRespository extends JpaRepository<Ubicacion, Integer> {
}
