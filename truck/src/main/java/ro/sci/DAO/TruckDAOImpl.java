package ro.sci.DAO;


import ro.sci.domain.Truck;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class TruckDAOImpl implements TruckDAO {

    private String dbType;
    private String host;
    private String port;
    private String dbName;
    private String user;
    private String pass;

    public TruckDAOImpl(String dbType, String host, String port, String dbName, String user, String pass) {
        this.dbType = dbType;
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public List<Truck> getAll() {
        List<Truck> result = new LinkedList<>();
        try(
                Connection connection = newConnection(dbType, host, port,
                        dbName, user, pass);

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from truck");

        ) {
            while(resultSet.next()) {
                Truck c = new Truck();
                c.setProducer(resultSet.getString(1));
                c.setModel(resultSet.getString(2));
                c.setTruckid(resultSet.getInt(3));
                result.add(c);
            }
        }   catch (Exception ex) {
            throw  new RuntimeException(ex);
        }


        return result;
    }

    @Override
    public Truck create(Truck c) {

        try(
                Connection connection = newConnection(dbType, host, port, dbName, user, pass);

                Statement statement = connection.createStatement();
        ) {
            statement.execute("insert into truck (producer, model,truckid) values('" + c.getProducer() + "', '" +c.getModel() + "', " + c.getTruckid() + ")");
        }   catch (Exception ex) {
            throw  new RuntimeException(ex);
        }
        return c;
    }

    @Override
    public Truck update(Truck c) {
        return null;
    }

    @Override
    public Truck delete(Truck c) {
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
