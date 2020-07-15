package es.pc.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

@RestController
@Slf4j
public class HealthController {

    @GetMapping("/health")
    public String healthCheck(){
        log.info("Health check OK");
        return "OK";
    }
}
