package servicios;

import entidades.Cliente;
import persistencia.ClienteDAO;

public class ServicioCliente {
    private ClienteDAO clienteDAO;

    public ServicioCliente() {
        this.clienteDAO = new ClienteDAO();
    }

    public void crearCliente(int codigoCliente, String nombreCliente, String nombreContacto, String apellidoContacto, String telefono, String fax, String ciudad, String region, String pais, String codigoPostal, int idEmpleado, double limiteCredito) throws Exception {

        if(validacionCrearCliente(nombreCliente, apellidoContacto)){
            clienteDAO.guardarCliente( new Cliente(codigoCliente, nombreCliente, nombreContacto, apellidoContacto, telefono, fax, ciudad, region, pais, codigoPostal, idEmpleado, limiteCredito));
        }
    }

    public boolean validacionCrearCliente(String nombre, String apellido) throws Exception {
        if(nombre == null || nombre.isEmpty() ){
            throw new Exception("El nombre del cliente es obligatorio");
        }
        if(apellido == null || apellido.isEmpty()){
            throw new Exception("El apellido del cliente es obligatorio");
        }
        return true;
    }

    public boolean validacionBuscarCliente(int id) throws Exception {
        if(id <= 0) {
            throw new Exception("El id es incorrecto");
        }
        return true;
    }

    public void buscarCliente(int id) throws Exception {
        if(validacionBuscarCliente(id)){
            clienteDAO.buscarClienteId(id);
        }else{
            throw new Exception("El id es incorrecto");
        }
    }

}
