package persistencia;

public class ProductoDAO extends DAO {

    public ProductoDAO() {
    }

    public void eliminarProducto(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM producto WHERE id_producto = " + codigo + "";
            insertarModificarEliminarDataBase(sql);
            System.out.println("El registro fue eliminado de manera exitosa");
        } catch (Exception e) {
            throw e;
        } finally {
            closeDataBase();
        }
    }

}
