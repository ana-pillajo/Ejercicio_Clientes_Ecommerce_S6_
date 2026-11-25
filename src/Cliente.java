public class Cliente {

    private String identificacion;
    private String nombre;
    private double totalCompras;
    private boolean activo;

    public Cliente(String identificacion, String nombre, double totalCompras, boolean activo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.totalCompras = totalCompras;
        this.activo = activo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTotalCompras() {
        return totalCompras;
    }

    public boolean isActivo() {
        return activo;
    }

    public String mostrarInformacion() {
        String estado;
        if (activo) {
            estado = "Activo";
        } else {
            estado = "Inactivo";
        }
        return identificacion + " - " + nombre + " - $" + String.format("%.2f", totalCompras) + " - " + estado;
    }
}