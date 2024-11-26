package com.temperaturaBogota.ControladorImpl;

import com.temperaturaBogota.Dto.UbicacionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@CrossOrigin( origins="http://localhost:4200/")
public interface UbicacionControllerImpl {

    @GetMapping("/all-ubicaciones")
    public ResponseEntity<UbicacionDto> getAllUbicacion();

    @GetMapping("/{id}")
    public ResponseEntity<UbicacionDto> getUbicacionById(@PathVariable Integer id);

    @PostMapping("/crear-ubicacion")
    public ResponseEntity<UbicacionDto> crearUbicacion(@RequestBody UbicacionDto crearUbi);

    @PutMapping("/update-ubicacion/{id}")
    public ResponseEntity<UbicacionDto> updateUbicacion (@PathVariable Integer id, @RequestBody UbicacionDto updateUbi);

    @DeleteMapping("/delete-ubicacion/{id}")
    public  ResponseEntity<UbicacionDto> borrarUbicacion(@PathVariable Integer id);

}
