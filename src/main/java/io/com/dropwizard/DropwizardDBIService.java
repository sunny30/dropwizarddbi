package io.com.dropwizard;

import io.com.dropwizard.resource.EntityResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import javax.sql.DataSource;

public class DropwizardDBIService extends Application<ServiceConfiguration> {

    private static final String SQL = "sql";

    public static void main(String[] args) throws Exception{
        new DropwizardDBIService().run(args);
    }

    public void run(ServiceConfiguration configuration, Environment environment) {


        final DataSource dataSource =
                configuration.getDataSourceFactory().build(environment.metrics(), SQL);
        DBI dbi = new DBI(dataSource);

        environment.jersey().register(new EntityResource(dbi.onDemand(DAOService.class)));

    }


}
