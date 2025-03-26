import persistency.ClienteDAO;

public class Main {
    public static void main(String[] args) throws Exception {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.listarClientes();
        //clienteDAO.eliminarCliente(1);
        //clienteDAO.buscarCliente(1);
    }
}
