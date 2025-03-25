package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

    protected Connection conexion = null;
    protected ResultSet resultSet = null;
    protected Statement statement = null;

    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DATABSE = "viveros";
    private final String USER = "root";
    private final String PASSWORD = "Pass123.";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    protected void connectDataBase() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABSE;
            conexion = java.sql.DriverManager.getConnection(url, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void closeDataBase() throws SQLException, ClassNotFoundException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void insertarModificarEliminarDataBase(String sql) throws Exception {
        try {
            connectDataBase();
            statement = conexion.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException ex) {

            System.out.println(ex.getMessage());
            throw ex;
        } finally {
            closeDataBase();
        }
    }

    protected void consultarDataBase(String sql) throws Exception {
        try {
            connectDataBase();
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
}
