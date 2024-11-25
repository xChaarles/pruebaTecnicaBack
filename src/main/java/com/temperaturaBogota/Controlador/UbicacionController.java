package com.temperaturaBogota.Controlador;

import com.temperaturaBogota.ControladorImpl.UbicacionControllerImpl;
import com.temperaturaBogota.Dto.UbicacionDto;
import com.temperaturaBogota.Service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UbicacionController implements UbicacionControllerImpl {

    @Autowired
    UbicacionService ubicacionService;

    @Override
    public ResponseEntity<UbicacionDto> getAllUbicacion(){
        return ResponseEntity.ok(ubicacionService.getAllUbicacion());
    }
}
