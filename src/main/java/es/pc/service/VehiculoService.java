package es.pc.service;

import es.pc.entity.VehiculoEntity;

public interface VehiculoService {
    void createVehiculo(String tipo, String matricula);
    VehiculoEntity getVehiculo(String matricula);
}
