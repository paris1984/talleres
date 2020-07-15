package es.pc.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
@Slf4j
public class ManageDB {

    @Bean
    public Connection connection(){
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch ( Exception e ) {
            log.error("Error al crear la conexion:" +e.getMessage());
        }
        log.info("Opened database successfully");
        return c;
    }
}
