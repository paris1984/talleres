package es.pc.service;

import es.pc.entity.VehiculoEntity;

import java.util.List;

public interface VehiculoService {
    void createVehiculo(String tipo, String matricula);
    VehiculoEntity getVehiculo(String matricula);
    List<VehiculoEntity> getVehiculos();
}
