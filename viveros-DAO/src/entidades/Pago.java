package entidades;

public class Pago {
    private int idPago;
    private int idCliente;
    private String formaPago;
    private String idTransaccion;
    private String fechaPago;
    private double total;

    public Pago() {
    }

    public Pago(int idPago, int idCliente, String formaPago, String idTransaccion, String fechaPago, double total) {
        this.idPago = idPago;
        this.idCliente = idCliente;
        this.formaPago = formaPago;
        this.idTransaccion = idTransaccion;
        this.fechaPago = fechaPago;
        this.total = total;
    }

    public Pago(int idCliente, String formaPago, String idTransaccion, String fechaPago, double total) {
        this.idCliente = idCliente;
        this.formaPago = formaPago;
        this.idTransaccion = idTransaccion;
        this.fechaPago = fechaPago;
        this.total = total;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "idPago=" + idPago +
                ", idCliente=" + idCliente +
                ", formaPago='" + formaPago + '\'' +
                ", idTransaccion='" + idTransaccion + '\'' +
                ", fechaPago='" + fechaPago + '\'' +
                ", total=" + total +
                '}';
    }
}
