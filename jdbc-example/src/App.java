import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conexion = getConnection();
        //exampleStatement(conexion);
        //buscarClientes(conexion);
        //buscarClientePorCodigo(conexion, 1);
        //buscarClientesPorEmpleado(conexion, 5);
        //getProductosParaReponer(conexion, 20);
        //getProductosGama(conexion, "'Herramientas'");
        //getPedidosPorCliente(conexion, 1);
        getPedidosPorEstado(conexion, String.valueOf("recHazado").toLowerCase());
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

    public static void getProductosParaReponer(Connection conexion, int punto_reposicion) {
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM producto WHERE cantidad_en_stock < "+punto_reposicion);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("nombre") + " tiene " + resultSet.getString("cantidad_en_stock") + " unidades en stock");
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }

    public static void getProductosGama(Connection conexion, String nameGama) {
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT producto.*, gama_producto.* FROM producto JOIN gama_producto ON producto.id_gama = gama_producto.id_gama WHERE gama_producto.gama = "+nameGama);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("producto.id_producto") + "  " + resultSet.getString("producto.nombre")  + "  " + resultSet.getString("gama_producto.id_gama")  + "  " +  resultSet.getString("gama_producto.gama"));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }

    public static void getPedidosPorCliente( Connection conexion, int id) {
        try {
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM pedido JOIN cliente ON pedido.id_cliente = cliente.id_cliente WHERE pedido.id_cliente = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("id_pedido") + " " + resultSet.getString("fecha_pedido") + " " + resultSet.getString("estado") + " " + resultSet.getString("cliente.nombre_cliente"));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }

    public static void getPedidosPorEstado( Connection connection, String estado) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM pedido WHERE LOWER(estado) = ?");
            statement.setString(1, estado);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("id_pedido") + " " + resultSet.getString("fecha_pedido") + " " + resultSet.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }
}
