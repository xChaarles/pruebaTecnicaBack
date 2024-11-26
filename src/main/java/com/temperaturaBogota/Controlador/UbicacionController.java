package com.temperaturaBogota.Controlador;

import com.temperaturaBogota.ControladorImpl.UbicacionControllerImpl;
import com.temperaturaBogota.Dto.UbicacionDto;
import com.temperaturaBogota.Service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UbicacionController implements UbicacionControllerImpl {

    @Autowired
    UbicacionService ubicacionService;

    @Override
    public ResponseEntity<UbicacionDto> getAllUbicacion(){
        return ResponseEntity.ok(ubicacionService.getAllUbicacion());
    }

    @Override
    public ResponseEntity<UbicacionDto> getUbicacionById(@PathVariable Integer id){
        return ResponseEntity.ok((ubicacionService.getUbicacionById(id)));
    }

    @Override
    public ResponseEntity<UbicacionDto> crearUbicacion(@RequestBody UbicacionDto crearUbi){
        return ResponseEntity.ok(ubicacionService.crearUbicacion(crearUbi));
    }

    @Override
    public ResponseEntity<UbicacionDto> updateUbicacion (@PathVariable Integer id, @RequestBody UbicacionDto updateUbi){
        return ResponseEntity.ok(ubicacionService.updateUbicacion(id, updateUbi));
    }

    @Override
    public  ResponseEntity<UbicacionDto> borrarUbicacion(@PathVariable Integer id){
        return ResponseEntity.ok(ubicacionService.borrarUbicacion(id));
    }
}
