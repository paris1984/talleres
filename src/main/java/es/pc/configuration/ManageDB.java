package es.pc.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Configuration
@Slf4j
public class ManageDB {

    private static final String CREATION_SQL = "create table IF NOT EXISTS vehiculos(\n" +
            "matricula varchar(15) primary key,\n" +
            "tipo      varchar(20)\n" +
            ");";
    @Bean
    public Connection connection(){
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = c.createStatement();
            stmt.execute(CREATION_SQL);
        } catch ( Exception e ) {
            log.error("Error al crear la conexion:" +e.getMessage());
        }

        log.info("Opened database successfully");
        return c;
    }
}
