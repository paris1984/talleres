package es.pc.service;

public interface VehiculoService {
    void createVehiculo(String tipo, String matricula);
    void getVehiculo(String matricula);
}
