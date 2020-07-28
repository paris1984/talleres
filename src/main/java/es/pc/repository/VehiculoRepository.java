package es.pc.repository;

import es.pc.entity.VehiculoEntity;

import java.util.List;

public interface VehiculoRepository {
    void save(VehiculoEntity entity);
    VehiculoEntity getVehiculo(String matricula);
    List<VehiculoEntity> getVehiculos();
}
