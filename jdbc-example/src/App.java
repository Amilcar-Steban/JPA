import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conexion = getConnection();
        //exampleStatement(conexion);
        //buscarClientes(conexion);
        //buscarClientePorCodigo(conexion, 1);
        buscarClientesPorEmpleado(conexion, 5);
        cerrarConexion(conexion);
    }
    public static Connection getConnection() throws Exception {
        String host = "localhost";
        String port = "3306";
        String database = "viveros";
        String username = "root";
        String password = "Pass123.";
        String zona = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + zona;

        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión establecida");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
        return conexion;
    }

    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("La conexión a la base de datos fue cerrada de manera exitosa");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión:" + e.getMessage());
            }
        }
    }

    public static void exampleStatement(Connection conexion) {
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cliente");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("nombre_cliente") + " " + resultSet.getString("apellido_contacto"));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }
    public static void buscarClientes(Connection conexion) {
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cliente ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("nombre_cliente") + " " + resultSet.getString("apellido_contacto") + " " + resultSet.getString("telefono"));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }

    public static void buscarClientePorCodigo(Connection conexion, int id) {
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cliente WHERE codigo_cliente = " + id);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("nombre_cliente") + " " + resultSet.getString("apellido_contacto") + " " + resultSet.getString("telefono"));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public static void buscarClientesPorEmpleado(Connection conexion, int id_empleado) {
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(
                "SELECT cliente.* FROM cliente JOIN empleado ON empleado.id_empleado = cliente.id_empleado WHERE empleado.codigo_empleado = " + id_empleado);
                resultSet.last();
                int size = resultSet.getRow();

                if (size == 0) {
                    System.out.println("No hay clientes para el empleado con código: " + id_empleado);
                }else{
                    resultSet.beforeFirst();
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("nombre_cliente") + " " + resultSet.getString("apellido_contacto") + " " + resultSet.getString("telefono"));
                    }
                }

        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
