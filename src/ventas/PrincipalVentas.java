package ventas;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PrincipalVentas {
    public static void main(String[] args) {
        System.out.println("*** Sistema de ventas ***");
        Scanner scanner = new Scanner(System.in);

        // Crear una lista para almacenar los productos
        List<Producto> productos = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();

            double precio;
            while (true) {
                System.out.print("Ingrese el precio del producto: ");
                try {
                    precio = Double.parseDouble(scanner.nextLine());
                    if (precio < 0) {
                        System.out.println("El precio no puede ser negativo. Intente de nuevo.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número válido para el precio.");
                }
            }


            // Crear un objeto Producto con los datos ingresados
            Producto producto = new Producto(nombre, precio);
            productos.add(producto); 
            System.out.println("Producto creado: " + producto);


            // Preguntar si desea agregar otro producto
            System.out.print("¿Desea agregar otro producto? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (!respuesta.equals("s") && !respuesta.equals("sí")) {
                continuar = false; // Terminar el bucle si la respuesta no es afirmativa
            }
        }

        // Mostrar información de todos los productos creados
        System.out.println("\n*** Productos creados ***");
        for (Producto p : productos) {
            System.out.println(p);
        }
        // Cerrar el Scanner
        scanner.close();
        System.out.println("¡Gracias por usar el sistema de ventas!");
    }
}
