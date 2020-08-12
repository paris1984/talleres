package es.pc.service;

import es.pc.entity.VehiculoEntity;
import es.pc.exception.BusinessException;
import es.pc.repository.VehiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class VehiculoServiceimpl implements VehiculoService {

    private VehiculoRepository vehiculoRepository;

    @Override
    public void createVehiculo(String tipo, String matricula) {

        vehiculoRepository.save(VehiculoEntity.builder().matricula(matricula).tipo(tipo).build());
    }

    @Override
    public VehiculoEntity getVehiculo(String matricula) {

        VehiculoEntity vehiculo = vehiculoRepository.getVehiculo(matricula);
        if(vehiculo==null){
            throw new BusinessException("Not found","404");
        }
        return vehiculo;
    }

    @Override
    public List<VehiculoEntity> getVehiculos() { return vehiculoRepository.getVehiculos(); }
}
