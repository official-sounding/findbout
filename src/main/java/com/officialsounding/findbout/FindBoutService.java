package com.officialsounding.findbout;

import com.officialsounding.findbout.dao.BoutDAO;
import com.officialsounding.findbout.resources.BoutResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;
import com.yammer.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import org.skife.jdbi.v2.DBI;

public class FindBoutService extends Service<FindBoutConfiguration> {

    public static void main(String[] args) throws Exception {
        new FindBoutService().run(args);

    }

    @Override
    public void initialize(Bootstrap<FindBoutConfiguration> bootstrap) {
        bootstrap.setName("findbout");
        bootstrap.addBundle(new AssetsBundle("/static/", "/"));
        bootstrap.addBundle(new DBIExceptionsBundle());
    }

    @Override
    public void run(FindBoutConfiguration configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final BoutDAO dao = jdbi.onDemand(BoutDAO.class);

        environment.addResource(new BoutResource(dao));
    }
}
