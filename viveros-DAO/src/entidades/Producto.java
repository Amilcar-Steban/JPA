package entidades;

public class Producto {
    private int idProducto;
    private int codigoProducto;
    private String nombre;
    private int idGama;
    private int dimensiones;
    private int Proveedor;
    private int descripcion;
    private int cantidadEnStock;
    private double precioVenta;
    private String precioProveedor;

    public Producto() {
    }

    public Producto(int idProducto, int codigoProducto, String nombre, int idGama, int dimensiones, int proveedor,
            int descripcion, int cantidadEnStock, double precioVenta, String precioProveedor) {
        this.idProducto = idProducto;
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.idGama = idGama;
        this.dimensiones = dimensiones;
        Proveedor = proveedor;
        this.descripcion = descripcion;
        this.cantidadEnStock = cantidadEnStock;
        this.precioVenta = precioVenta;
        this.precioProveedor = precioProveedor;
    }

    public Producto(int codigoProducto, String nombre, int idGama, int dimensiones, int proveedor,
            int descripcion, int cantidadEnStock, double precioVenta, String precioProveedor) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.idGama = idGama;
        this.dimensiones = dimensiones;
        Proveedor = proveedor;
        this.descripcion = descripcion;
        this.cantidadEnStock = cantidadEnStock;
        this.precioVenta = precioVenta;
        this.precioProveedor = precioProveedor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdGama() {
        return idGama;
    }

    public void setIdGama(int idGama) {
        this.idGama = idGama;
    }

    public int getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(int dimensiones) {
        this.dimensiones = dimensiones;
    }

    public int getProveedor() {
        return Proveedor;
    }

    public void setProveedor(int proveedor) {
        Proveedor = proveedor;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(String precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", codigoProducto=" + codigoProducto +
                ", nombre='" + nombre + '\'' +
                ", idGama=" + idGama +
                ", dimensiones=" + dimensiones +
                ", Proveedor=" + Proveedor +
                ", descripcion=" + descripcion +
                ", cantidadEnStock=" + cantidadEnStock +
                ", precioVenta=" + precioVenta +
                ", precioProveedor='" + precioProveedor + '\'' +
                '}';
    }

}
