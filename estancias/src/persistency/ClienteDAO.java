package persistency;

import entity.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO {

    public ClienteDAO() {

    }
    //agregar, eliminar, listar, buscar, modificar
    public void agregarCliente(Cliente cliente) throws Exception {
        try {
            String sql = "INSERT INTO cliente (id_cliente, nombre, calle, numero, codigo_postal, ciudad, pais, email) VALUES ("
                    + cliente.getIdCliente() + "', '"
                    + cliente.getNombre() + "', '"
                    + cliente.getCalle() + "', "
                    + cliente.getNumero() + ", '"
                    + cliente.getCodigoPostal() + "', '"
                    + cliente.getCiudad() + "', '"
                    + cliente.getPais() + "', '"
                    + cliente.getEmail() + "')";
            crud(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarClientes() throws Exception {
        try {
            String sql = "SELECT * FROM clientes";
            consultarDataBase(sql);
            List<Cliente> clientes = new ArrayList<>();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("id_cliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setCalle(resultSet.getString("calle"));
                cliente.setNumero(resultSet.getInt("numero"));
                cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
                cliente.setCiudad(resultSet.getString("ciudad"));
                cliente.setPais(resultSet.getString("pais"));
                cliente.setEmail(resultSet.getString("email"));
                clientes.add(cliente);
            }
            closeDataBase();
            for (Cliente client : clientes) {
                System.out.println(client.toString());
                System.out.println("--------------------");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarCliente(int id) throws Exception {
        try {
            String sql = "DELETE FROM cliente WHERE id_cliente = " + id;
            crud(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarCliente(int id) throws Exception {
        try {
            String sql = "SELECT * FROM cliente WHERE id_cliente = " + id;
            consultarDataBase(sql);
            Cliente cliente = new Cliente();
            if(resultSet.next()) {
                cliente.setIdCliente(resultSet.getInt("id_cliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setCalle(resultSet.getString("calle"));
                cliente.setNumero(resultSet.getInt("numero"));
                cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
                cliente.setCiudad(resultSet.getString("ciudad"));
                cliente.setPais(resultSet.getString("pais"));
                cliente.setEmail(resultSet.getString("email"));
            }
            closeDataBase();
            cliente.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
