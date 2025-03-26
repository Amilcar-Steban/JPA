package persistencia;

import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO {

    public ClienteDAO() {
    }

    public void guardarCliente(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("Debe indicar el cliente");
        }
        String sql = "INSERT INTO cliente(codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, "
            + "telefono, fax, ciudad, region, pais, codigo_postal, id_empleado, limite_credito) VALUES ("
            + "'" + cliente.getCodigoCliente() + "', '"
            + cliente.getNombreCliente() + "', '"
            + cliente.getNombreContacto() + "', '"
            + cliente.getApellidoContacto() + "', '"
            + cliente.getTelefono() + "', '"
            + cliente.getFax() + "', '"
            + cliente.getCiudad() + "', '"
            + cliente.getRegion() + "', '"
            + cliente.getPais() + "', '"
            + cliente.getCodigoPostal() + "', "
            + cliente.getIdEmpleado() + ", "
            + cliente.getLimiteCredito() + ")";

        insertarModificarEliminarDataBase(sql);
    }

    public void listarTodosLosClientes() throws Exception {
        String sql = "SELECT * FROM cliente";
        consultarDataBase(sql);
        List<Cliente> clientes = new ArrayList<>();
        while (resultSet.next()) {
            Cliente cliente = new Cliente();
            cliente.setCodigoCliente(resultSet.getInt("codigo_cliente"));
            cliente.setNombreCliente(resultSet.getString("nombre_cliente"));
            cliente.setNombreContacto(resultSet.getString("nombre_contacto"));
            cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));
            cliente.setTelefono(resultSet.getString("telefono"));
            cliente.setFax(resultSet.getString("fax"));
            cliente.setCiudad(resultSet.getString("ciudad"));
            cliente.setRegion(resultSet.getString("region"));
            cliente.setPais(resultSet.getString("pais"));
            cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
            cliente.setIdEmpleado(resultSet.getInt("id_empleado"));
            cliente.setLimiteCredito(resultSet.getDouble("limite_credito"));
            clientes.add(cliente);
        }
        closeDataBase();
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }
    public void eliminarClienteId(int id) throws Exception {
        String sql = "DELETE FROM cliente WHERE idCliente = " + id;
        insertarModificarEliminarDataBase(sql);
    }

}
