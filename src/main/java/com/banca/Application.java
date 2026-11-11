package com.banca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.util.Arrays;

@SpringBootApplication
@EnableTransactionManagement
public class Application {
    private final DataSource dataSource;
    private final Environment environment;

    public Application(DataSource dataSource, Environment environment) {
        this.dataSource = dataSource;
        this.environment = environment;
        validateEnvironment();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        migrateDatabase();
        logApplicationStartup();
    }

    private void migrateDatabase() {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration")
                .load();
        flyway.migrate();
    }

    private void validateEnvironment() {
        String[] activeProfiles = environment.getActiveProfiles();
        if (Arrays.stream(activeProfiles).noneMatch(profile -> profile.equals("dev") || profile.equals("prod"))) {
            throw new IllegalStateException("Debe activarse al menos un perfil: 'dev' o 'prod'");
        }
    }

    private void logApplicationStartup() {
        String protocol = environment.getProperty("server.ssl.key-store") != null ? "https" : "http";
        String serverPort = environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.servlet.context-path");
        if (contextPath == null || contextPath.isBlank()) {
            contextPath = "/";
        }
        System.out.println(String.format("\n----------------------------------------------------------\n" +
                "Aplicación 'Banca Service' iniciada!\n" +
                "Perfiles activos: %s\n" +
                "Acceso local: %s://localhost:%s%s\n" +
                "----------------------------------------------------------",
                Arrays.toString(environment.getActiveProfiles()),
                protocol,
                serverPort,
                contextPath));
    }
}