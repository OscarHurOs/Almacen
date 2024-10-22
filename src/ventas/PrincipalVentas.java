package ventas;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que gestiona el flujo de creación y visualización de productos.
 */
public class PrincipalVentas {
    public static void main(String[] args) {
        System.out.println("*** Sistema de ventas ***");
        Scanner scanner = new Scanner(System.in);
        List<Producto> productos = new ArrayList<>();
        //Crear productos
        ingresarProductos(scanner,productos);
        //crear una orden y agregar los productos
        crearOrdenes(scanner,productos);

        scanner.close();
        System.out.println("¡Gracias por usar el sistema de ventas!");

    }

    /**
     * Permite al usuario ingresar productos en el sistema.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     * @param productos Lista de productos a llenar.
     */
    private static void ingresarProductos(Scanner scanner, List<Producto> productos){
        // Bucle principal para ingresar productos
        do{
            String nombre = obtenerNombreProducto(scanner);
            double precio = obtenerPrecioProducto(scanner);

            // Crear un objeto Producto con los datos ingresados
            Producto producto = new Producto(nombre, precio);
            productos.add(producto);
            System.out.println("Producto creado: " + producto);

        }while(continuarAgregandoProducto(scanner));
        mostrarProductos(productos);
    }

    /**
     * Solicita y devuelve el nombre del producto ingresado por el usuario.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     * @return El nombre del producto.
     */
    private static String obtenerNombreProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        return scanner.nextLine();
    }

    /**
     * Solicita y valida el precio ingresado por el usuario.
     * Asegura que el precio sea un valor numérico y no negativo.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     * @return El precio válido del producto.
     */
    private static double obtenerPrecioProducto(Scanner scanner) {
        double precio;
        while (true) {
            System.out.print("Ingrese el precio del producto: ");
            try {
                precio = Double.parseDouble(scanner.nextLine());
                if (precio < 0) {
                    System.out.println("El precio no puede ser negativo. Intente de nuevo.");
                    continue;
                }
                return precio;  // Retorna el precio válido
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número válido.");
            }
        }
    }

    /**
     * Pregunta al usuario si desea agregar otro producto.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     * @return true si el usuario desea continuar, false en caso contrario.
     */
    private static boolean continuarAgregandoProducto(Scanner scanner) {
        while (true) {
            System.out.print("¿Desea agregar otro producto? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals("s")) {
                return true;  // Continuar agregando productos
            } else if (respuesta.equals("n")) {
                return false;  // Terminar el ciclo de productos
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese 's' para sí o 'n' para no.");
            }
        }
    }

    /**
     * Muestra en consola los productos creados.
     *
     * @param productos Lista de productos a mostrar.
     */
    private static void mostrarProductos(List<Producto> productos) {
        System.out.println("\n*** Productos creados ***");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    /**
     * Permite al usuario crear órdenes y agregar productos a ellas.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     * @param productos Lista de productos disponibles.
     */
    private static void crearOrdenes(Scanner scanner, List<Producto> productos) {
        boolean crearOrdenes;
        do {
            Orden orden = new Orden();
            List<Producto> productosOrden = new ArrayList<>();

            agregarProductosAOrden(scanner, productos, productosOrden);

            orden.mostrarOrden(productosOrden);

            // Preguntar al usuario si desea crear otra orden
            crearOrdenes = continuarAgregandoOrden(scanner);
        } while (crearOrdenes);
    }

    /**
     * Permite al usuario agregar productos a la orden.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     * @param productos Lista de productos disponibles.
     * @param productosOrden Lista de productos en la orden.
     */
    private static void agregarProductosAOrden(Scanner scanner, List<Producto> productos, List<Producto> productosOrden) {
        boolean agregarProductos;
        do {
            mostrarProductos(productos);  // Muestra todos los productos disponibles
            System.out.print("Ingrese el ID del producto que desea agregar a la orden: ");
            int idProducto = Integer.parseInt(scanner.nextLine());

            // Buscar el producto por ID
            Producto productoSeleccionado = buscarProductoPorId(productos, idProducto);
            if (productoSeleccionado != null) {
                productosOrden.add(productoSeleccionado);
                System.out.println("Producto agregado a la orden: " + productoSeleccionado);
            } else {
                System.out.println("Producto no encontrado. Intente de nuevo.");
            }

            agregarProductos = continuarAgregandoProducto(scanner);
        } while (agregarProductos);
    }

    /**
     * Busca un producto por su ID en la lista de productos.
     *
     * @param productos Lista de productos donde buscar.
     * @param idProducto ID del producto a buscar.
     * @return El producto encontrado o null si no se encuentra.
     */
    private static Producto buscarProductoPorId(List<Producto> productos, int idProducto) {
        for (Producto p : productos) {
            if (p.getIdProducto() == idProducto) {
                return p;
            }
        }
        return null; // Producto no encontrado
    }

    /**
     * Pregunta al usuario si desea crear otra orden.
     *
     * @param scanner Objeto Scanner para la entrada del usuario.
     * @return true si el usuario desea continuar, false en caso contrario.
     */
    private static boolean continuarAgregandoOrden(Scanner scanner) {
        while (true) {
            System.out.print("¿Desea crear otra orden? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals("s")) {
                return true;  // Continuar creando órdenes
            } else if (respuesta.equals("n")) {
                return false;  // Terminar el ciclo de órdenes
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese 's' para sí o 'n' para no.");
            }
        }
    }
}
