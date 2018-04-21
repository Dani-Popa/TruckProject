package ro.sci.DAO;

import ro.sci.domain.Route;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class RouteDAOImpl implements RouteDAO {

    private String dbType;
    private String host;
    private String port;
    private String dbName;
    private String user;
    private String pass;

    public RouteDAOImpl(String dbType, String host, String port, String dbName, String user, String pass) {
        this.dbType = dbType;
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public List<Route> getAll() {
        List<Route> result = new LinkedList<>();
        try(
                Connection connection = newConnection(dbType, host, port,
                        dbName, user, pass);

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from route");

        ) {
            while(resultSet.next()) {
                Route r = new Route();
                r.setStart(resultSet.getString(1));
                r.setDestination(resultSet.getString(2));
                result.add(r);
            }
        }   catch (Exception ex) {
            throw  new RuntimeException(ex);
        }


        return result;
    }

    @Override
    public Route create(Route r) {

        try(
                Connection connection = newConnection(dbType, host, port, dbName, user, pass);

                Statement statement = connection.createStatement();
        ) {
            statement.execute("insert into route (start, destination) values ('" + r.getStart() + "', '" + r.getDestination() + "')");
        }   catch (Exception ex) {
            throw  new RuntimeException(ex);
        }
        return r;
    }

    @Override
    public Route update(Route r) {
        return null;
    }

    private static Connection newConnection(String type,
                                            String host,
                                            String port,
                                            String dbName,
                                            String user,
                                            String pw) {

        loadDriver();
        DriverManager.setLoginTimeout(60); // wait 1 min; optional: DB may be
        // busy, good to set a higher
        // timeout
        try {
            String url = new StringBuilder().append("jdbc:").append(type) // “mysql”
                    // /
                    // “db2”
                    // /
                    // “mssql”
                    // /
                    // “oracle”
                    // /
                    // ...
                    .append("://").append(host).append(":").append(port).append("/").append(dbName).append("?user=")
                    .append(user).append("&password=").append(pw).toString();
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }

        return null;
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.err.println("Can’t load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        }

    }
}