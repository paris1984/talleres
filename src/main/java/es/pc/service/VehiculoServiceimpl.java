package es.pc.service;

import es.pc.entity.VehiculoEntity;
import es.pc.repository.VehiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
        return vehiculoRepository.getVehiculo(matricula);
    }
}
