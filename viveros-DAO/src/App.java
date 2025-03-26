
import persistencia.ClienteDAO;

public class App {
    public static void main(String[] args) throws Exception {
        ClienteDAO clienteDAO = new ClienteDAO();
        //ProductoDAO productoDAO = new ProductoDAO();

        //clienteDAO.listarTodosLosClientes();
        /* Cliente cliente = new Cliente(
            2, 
            "Amilcar S.", 
            "Amil367", 
            "Rodriguez", 
            "3163914358", 
            "555-5678", 
            "Cali", 
            "Valle del Cauca", 
            "Colombia", 
            "760001",
            5, 
            50000.0
        ); */
        //clienteDAO.guardarCliente(cliente);
        clienteDAO.buscarClienteId(5);
        //productoDAO.eliminarProducto(50);
    }
}
