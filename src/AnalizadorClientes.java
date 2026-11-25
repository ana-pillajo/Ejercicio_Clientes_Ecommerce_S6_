public class AnalizadorClientes {

    // Asociación: el arreglo se conserva como atributo
    private Cliente[] clientes;

    public AnalizadorClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public int contarActivos() {
        int contador = 0;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null && clientes[i].isActivo()) {
                contador++;
            }
        }
        return contador;
    }

    public double calcularPromedioCompras() {
        double suma = 0;
        int validos = 0;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                suma += clientes[i].getTotalCompras();
                validos++;
            }
        }
        if (validos == 0) {
            return 0;
        }
        return suma / validos;
    }

    public Cliente buscarPorIdentificacion(String identificacion) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null && clientes[i].getIdentificacion().equals(identificacion)) {
                return clientes[i];
            }
        }
        return null;
    }

    public Cliente obtenerMayorComprador() {
        Cliente mayor = null;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                if (mayor == null || clientes[i].getTotalCompras() > mayor.getTotalCompras()) {
                    mayor = clientes[i];
                }
            }
        }
        return mayor;
    }

    public String listarClientes() {
        String resultado = "";
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                resultado += clientes[i].mostrarInformacion() + "\n";
            }
        }
        return resultado;
    }

    // Desafío
    public String listarClientesConComprasMayoresA(double valor) {
        String resultado = "";
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null && clientes[i].getTotalCompras() > valor) {
                resultado += clientes[i].mostrarInformacion() + "\n";
            }
        }
        if (resultado.equals("")) {
            return "Ningún cliente supera $" + String.format("%.2f", valor);
        }
        return resultado;
    }
}