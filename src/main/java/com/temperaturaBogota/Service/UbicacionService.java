package com.temperaturaBogota.Service;

import com.temperaturaBogota.Dto.UbicacionDto;
import com.temperaturaBogota.Entidades.Ubicacion;
import com.temperaturaBogota.Repositorio.UbicacionRespository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            ubicacionDto.setMessage("Ocurrio un error: " + e.getMessage());
        }
        return ubicacionDto;
    }

    public UbicacionDto getUbicacionById(Integer id){
        UbicacionDto ubicacionDto = new UbicacionDto();
        try{
            Ubicacion ubicacion = ubicacionRespository.findById(id).
                    orElseThrow( () -> new RuntimeException("Ubicacion no encontrada"));
            ubicacionDto.setUbicacion(ubicacion);
            ubicacionDto.setStatuscode(200);
            ubicacionDto.setMessage("Ubicacion encontrda Exitosamente");
        }catch (Exception e){
            ubicacionDto.setStatuscode(500);
            ubicacionDto.setMessage("Ocurrio un error: " + e.getMessage());
        }
        return ubicacionDto;
    }

    public UbicacionDto crearUbicacion(UbicacionDto crearUbi){
        UbicacionDto ubicacionDto = new UbicacionDto();
        try{
            Ubicacion ubicacion = new Ubicacion();
            ubicacion.setNombre(crearUbi.getNombre());
            ubicacion.setLatitud(crearUbi.getLatitud());
            ubicacion.setLongitud(crearUbi.getLongitud());
            ubicacion.setTemperatura_actual(crearUbi.getTemperatura_actual());

            Ubicacion ubicacion1Resul = ubicacionRespository.save(ubicacion);

            if (ubicacion1Resul.getId()>0){
                ubicacionDto.setUbicacion(ubicacion1Resul);
                ubicacionDto.setStatuscode(200);
                ubicacionDto.setMessage("Creacion de la Ubicacion Exitosa");
            }

        }catch (Exception e){
            ubicacionDto.setStatuscode(500);
            ubicacionDto.setMessage("Ocurrio un error: "+ e.getMessage());
        }
        return ubicacionDto;
    }

    public UbicacionDto updateUbicacion (Integer id, UbicacionDto updateUbi){
        UbicacionDto ubicacionDto = new UbicacionDto();
        try{
            Optional<Ubicacion> ubicacionOptional =ubicacionRespository.findById(id);
            if (ubicacionOptional.isPresent()){
                Ubicacion ubicacionExiste = ubicacionOptional.get();
                ubicacionExiste.setNombre(updateUbi.getNombre());
                ubicacionExiste.setLatitud(updateUbi.getLatitud());
                ubicacionExiste.setLongitud(updateUbi.getLongitud());
                ubicacionExiste.setTemperatura_actual(updateUbi.getTemperatura_actual());

                Ubicacion saveUbicacion = ubicacionRespository.save(ubicacionExiste);

                ubicacionDto.setUbicacion(saveUbicacion);
                ubicacionDto.setStatuscode(200);
                ubicacionDto.setMessage("Ubicacion Actualizada correctamente");
            }else {
                ubicacionDto.setStatuscode(404);
                ubicacionDto.setMessage("Ubicacion no encontrada");
            }
        }catch (Exception e){
            ubicacionDto.setStatuscode(500);
            ubicacionDto.setMessage("Ocurrio un error: "+ e.getMessage());
        }
        return ubicacionDto;
    }

    public UbicacionDto borrarUbicacion(Integer id){
        UbicacionDto ubicacionDto = new UbicacionDto();
        try{
            Optional<Ubicacion> ubicacionOptional = ubicacionRespository.findById(id);
            if(ubicacionOptional.isPresent()){
                ubicacionRespository.deleteById(id);
                ubicacionDto.setStatuscode(200);
                ubicacionDto.setMessage("Ubicacion eliminada con Exito");
            }else {
                ubicacionDto.setStatuscode(404);
                ubicacionDto.setMessage("Ubicaion no encontrada");
            }
        }catch (Exception e){
            ubicacionDto.setStatuscode(500);
            ubicacionDto.setMessage("Ocurrio un error: " + e.getMessage());
        }
        return ubicacionDto;
    }

}
