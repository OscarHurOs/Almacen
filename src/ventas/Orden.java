package ventas;

import java.util.List;

public class Orden {
    private final int idOrden;
    private static int contadorOrdenes;

    public Orden() {
        this.idOrden = ++Orden.contadorOrdenes;
    }

    public double calcularTotal(List<Producto> productos) {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return  total;
    }

    public void mostrarOrden(List<Producto> productos){
        System.out.println("Id Orden" + this.idOrden);
        var totalOrden = this.calcularTotal(productos);
        System.out.println("\t Total de la orden: $"+ totalOrden);
        mostrarProductos(productos);
    }

    /**
     * Muestra en consola los productos en la orden.
     *
     * @param productos Lista de productos a mostrar.
     */
    private static void mostrarProductos(List<Producto> productos) {
        System.out.println("\n*** Productos agregados a la orden ***");
        for (Producto p : productos) {
            System.out.println("\t\t"+ p);
        }
    }
}

