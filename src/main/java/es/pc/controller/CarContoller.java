package es.pc.controller;

import es.pc.entity.VehiculoEntity;
import es.pc.service.VehiculoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class CarContoller {

    private VehiculoService vehiculoService;

    @PostMapping("/taller/vehiculo/{matricula}/alta")
    public String createCar(@PathVariable("matricula") String matricula){
        log.info("Matricula:"+matricula);
        vehiculoService.createVehiculo("coche",matricula);
        return "OK";
    }



    @GetMapping("/taller/vehiculo/{matricula}/get_car")
    public VehiculoEntity getCar(@PathVariable("matricula") String matricula){
        log.info("Matricula:"+matricula);
        return vehiculoService.getVehiculo(matricula);
    }
}
