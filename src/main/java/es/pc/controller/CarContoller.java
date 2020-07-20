package es.pc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CarContoller {
    @GetMapping("/taller/vehiculo/{matricula}/alta")
    public String getCar(@PathVariable("matricula") String matricula){
        log.info("Matricula:"+matricula);
        return "OK";
    }
}
