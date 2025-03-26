package entidades;

import java.sql.Date;

public class Estancia {

    private int idEstancia;
    private int idCliente;
    private int idCasa;
    private String nombreHuesped;
    private java.sql.Date fechaDesde;
    private java.sql.Date fechaHasta;

    public Estancia() {
    }

    public Estancia(int idEstancia, int idCliente, int idCasa, String nombreHuesped, Date fechaDesde, Date fechaHasta) {
        this.idEstancia = idEstancia;
        this.idCliente = idCliente;
        this.idCasa = idCasa;
        this.nombreHuesped = nombreHuesped;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public Estancia(int idCliente, int idCasa, String nombreHuesped, Date fechaDesde, Date fechaHasta) {
        this.idCliente = idCliente;
        this.idCasa = idCasa;
        this.nombreHuesped = nombreHuesped;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public int getIdEstancia() {
        return idEstancia;
    }

    public void setIdEstancia(int idEstancia) {
        this.idEstancia = idEstancia;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }

    public java.sql.Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(java.sql.Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public java.sql.Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(java.sql.Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @Override
    public String toString() {
        return "{ \"idEstancia\": " + idEstancia + 
               ", \"idCliente\": " + idCliente + 
               ", \"idCasa\": " + idCasa + 
               ", \"nombreHuesped\": \"" + nombreHuesped + "\"" +
               ", \"fechaDesde\": \"" + fechaDesde + "\"" +
               ", \"fechaHasta\": \"" + fechaHasta + "\" }";
    }
}
