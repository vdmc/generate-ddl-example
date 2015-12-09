package nl.generate.ddl.example;

import org.hibernate.jpa.AvailableSettings;

import java.io.IOException;
import java.util.Properties;

public class SchemaCreator {

    public static void main(String[] args) throws IOException {
        execute("default", "./target/create.sql");
        System.exit(0);
    }

    public static void execute(String persistenceUnitName, String destination) {
        System.out.println("Generating DDL create script to : " + destination);

        final Properties persistenceProperties = new Properties();

        // XXX force persistence properties : remove database target
        persistenceProperties.setProperty(org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO, "");
        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_DATABASE_ACTION, "none");

        // XXX force persistence properties : define create script target from metadata to destination
        // persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_CREATE_SCHEMAS, "true");
        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_SCRIPTS_ACTION, "create");
        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_CREATE_SOURCE, "metadata");
        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_SCRIPTS_CREATE_TARGET, destination);
        persistenceProperties.setProperty(AvailableSettings.JDBC_DRIVER,"org.h2.Driver");
        persistenceProperties.setProperty(AvailableSettings.JDBC_URL,"jdbc:h2:mem:jpaschema");
        javax.persistence.Persistence.generateSchema(persistenceUnitName, persistenceProperties);
    }

}