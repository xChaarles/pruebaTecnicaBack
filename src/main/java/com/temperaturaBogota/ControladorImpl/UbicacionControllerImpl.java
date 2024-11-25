package com.temperaturaBogota.ControladorImpl;

import com.temperaturaBogota.Dto.UbicacionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface UbicacionControllerImpl {

    @GetMapping("/all-ubicaciones")
    public ResponseEntity<UbicacionDto> getAllUbicacion();

}
