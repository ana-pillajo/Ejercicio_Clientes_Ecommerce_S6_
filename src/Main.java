public class Main {

    public static void main(String[] args) {

        Cliente[] clientes = new Cliente[6];
        clientes[0] = new Cliente("1712345678", "Ana Torres", 320.50, true);
        clientes[1] = new Cliente("1723456789", "Luis Mora", 150.00, false);
        clientes[2] = new Cliente("1734567890", "María Paz", 780.25, true);
        clientes[3] = new Cliente("1745678901", "Carlos Vega", 95.00, true);
        clientes[4] = new Cliente("1756789012", "Sofía León", 510.00, false);
        clientes[5] = new Cliente("1767890123", "Diego Ruiz", 260.75, true);

        AnalizadorClientes analizador = new AnalizadorClientes(clientes);

        System.out.println("=== LISTADO DE CLIENTES ===");
        System.out.println(analizador.listarClientes());


        System.out.println("Clientes activos: " + analizador.contarActivos());

        System.out.println("Promedio de compras: $" + String.format("%.2f", analizador.calcularPromedioCompras()));
        System.out.println();

        System.out.println("=== BÚSQUEDA ===");
        Cliente encontrado = analizador.buscarPorIdentificacion("1734567890");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.mostrarInformacion());
        } else {
            System.out.println("Cliente 1734567890 no encontrado");
        }

        Cliente noExiste = analizador.buscarPorIdentificacion("0000000000");
        if (noExiste == null) {
            System.out.println("Cliente 0000000000 no encontrado (retornó null)");
        } else {
            System.out.println("Encontrado: " + noExiste.mostrarInformacion());
        }
        System.out.println();

        Cliente mayor = analizador.obtenerMayorComprador();
        if (mayor != null) {
            System.out.println("Mayor comprador: " + mayor.mostrarInformacion());
        }
        System.out.println();

        System.out.println("=== DESAFÍO: compras mayores a $300 ===");
        System.out.println(analizador.listarClientesConComprasMayoresA(300));
        System.out.println("=== DESAFÍO: compras mayores a $1000 ===");
        System.out.println(analizador.listarClientesConComprasMayoresA(1000));
    }
}