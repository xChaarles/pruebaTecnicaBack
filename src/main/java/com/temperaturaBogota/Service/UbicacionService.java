package com.temperaturaBogota.Service;

import com.temperaturaBogota.Dto.UbicacionDto;
import com.temperaturaBogota.Entidades.Ubicacion;
import com.temperaturaBogota.Repositorio.UbicacionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRespository ubicacionRespository;

    public UbicacionDto getAllUbicacion(){
        UbicacionDto ubicacionDto = new UbicacionDto();
        try{
            List<Ubicacion> result = ubicacionRespository.findAll();
            if(!result.isEmpty()) {
                ubicacionDto.setUbicacionList(result);
                ubicacionDto.setStatuscode(200);
                ubicacionDto.setMessage("lista de Ubicaciones Exitosa");
            }else {
                ubicacionDto.setStatuscode(404);
                ubicacionDto.setMessage("No se encontraron Ubicaciones");
            }
        }catch (Exception e){
            ubicacionDto.setStatuscode(500);
            ubicacionDto.setMessage("Ocurrio un error" + e.getMessage());
        }
        return ubicacionDto;
    }


}
