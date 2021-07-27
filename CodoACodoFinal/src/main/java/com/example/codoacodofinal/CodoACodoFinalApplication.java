package com.example.codoacodofinal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodoACodoFinalApplication implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(CodoACodoFinalApplication.class);
    public static void main(String[] args) {

        SpringApplication.run(CodoACodoFinalApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        LOG.info("################################  IMPORTANTE DE LEER   ##################################");
        LOG.info("El sistema inserta automaticamente los roles, un admin por defecto y un usuario por defecto a manera de utilizarlos para probar las funcionalidades y restricciones segun el rol del usuario.");
        LOG.info("Dichos roles y usuarios se insertan mediante consulta sql, ambas estan en el archivo 'import.sql' en resources.");
        LOG.info("Credenciales del administrador :  usuario: 'admin', clave: '123'");
        LOG.info("Credenciales del usuario :  usuario: 'user', clave: '123'");
    }
}
