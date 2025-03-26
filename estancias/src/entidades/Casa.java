package entidades;

public class Casa {
    private int idCasa;
    private String calle;
    private int numero;
    private String codigoPostal;
    private String ciudad;
    private String pais;
    private String fechaDesde;
    private String fechaHasta;
    private int tiempoMinimo;
    private int tiempoMaximo;
    private double precioHabitacion;
    private String tipoVivienda;

    public Casa() {
    }

    public Casa(String calle, String ciudad, String codigoPostal, String fechaDesde, String fechaHasta, int idCasa, int numero, String pais, double precioHabitacion, int tiempoMaximo, int tiempoMinimo, String tipoVivienda) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.idCasa = idCasa;
        this.numero = numero;
        this.pais = pais;
        this.precioHabitacion = precioHabitacion;
        this.tiempoMaximo = tiempoMaximo;
        this.tiempoMinimo = tiempoMinimo;
        this.tipoVivienda = tipoVivienda;
    }

    public Casa(String ciudad, String codigoPostal, String fechaDesde, String fechaHasta, int idCasa, int numero, String pais, double precioHabitacion, int tiempoMaximo, int tiempoMinimo, String tipoVivienda) {
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.idCasa = idCasa;
        this.numero = numero;
        this.pais = pais;
        this.precioHabitacion = precioHabitacion;
        this.tiempoMaximo = tiempoMaximo;
        this.tiempoMinimo = tiempoMinimo;
        this.tipoVivienda = tipoVivienda;
    }

    public int getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public int getTiempoMinimo() {
        return tiempoMinimo;
    }

    public void setTiempoMinimo(int tiempoMinimo) {
        this.tiempoMinimo = tiempoMinimo;
    }

    public int getTiempoMaximo() {
        return tiempoMaximo;
    }

    public void setTiempoMaximo(int tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
    }

    public double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    @Override
    public String toString() {
        return "{"
                + "\"idCasa\":" + idCasa
                + ", \"calle\":\"" + calle + "\""
                + ", \"numero\":" + numero
                + ", \"codigoPostal\":\"" + codigoPostal + "\""
                + ", \"ciudad\":\"" + ciudad + "\""
                + ", \"pais\":\"" + pais + "\""
                + ", \"fechaDesde\":\"" + fechaDesde + "\""
                + ", \"fechaHasta\":\"" + fechaHasta + "\""
                + ", \"tiempoMinimo\":" + tiempoMinimo
                + ", \"tiempoMaximo\":" + tiempoMaximo
                + ", \"precioHabitacion\":" + precioHabitacion
                + ", \"tipoVivienda\":\"" + tipoVivienda + "\""
                + "}";
    }

}
