package ro.sci;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import ro.sci.DAO.TruckDAO;
import ro.sci.DAO.TruckDAOImpl;
import ro.sci.DAO.*;

import javax.sql.DataSource;


@Configuration
public class ApplicationConfiguration {

    @Bean
    public TruckDAO truckDao() {
        return new TruckDAOImpl("postgresql","localhost", "5432", "trucks",
                "postgres", "test");
    }

    @Bean
    public RouteDAO routeDao() {
        return new RouteDAOImpl("postgresql","localhost", "5432", "trucks",
                "postgres", "test");
    }


    @Bean
    public DataSource dataSource() {
        String url = new StringBuilder()
                .append("jdbc:")
                .append("postgresql")
                .append("://")
                .append("localhost")
                .append(":")
                .append("5433")
                .append("/")
                .append("trucks")
                .append("?user=")
                .append("postgres")
                .append("&password=")
                .append("postgres").toString();

        return  new SingleConnectionDataSource(url, false);
    }

}
