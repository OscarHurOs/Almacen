package ventas;

import java.util.Objects;

/**
 * Clase que representa un producto en un sistema de ventas.
 */
public class Producto {
    // ID único del producto, asignado automáticamente.
    private final int idProducto;
    // Nombre del prodcuto
    private String nombre;
    // Precio del producto
    private double precio;
    // Contador estático para generar ID de productos de manera única
    private static int contadorProductos;


    /**
     * Constructor de la clase Producto.
     *
     * @param nombre El nombre del producto.
     * @param precio El precio del producto.
     */
    public Producto(String nombre,double precio){
        this.idProducto =++Producto.contadorProductos;
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Obtiene el ID del producto.
     *
     * @return El ID del producto.
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nuevo nombre del producto.
     * @throws IllegalArgumentException si el nombre es nulo o vacío.
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio El nuevo precio del producto.
     * @throws IllegalArgumentException si el precio es negativo.
     */
    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    /**
     * Devuelve una representación en cadena del producto.
     *
     * @return Una cadena que representa el producto.
     */
    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + this.idProducto +
                ", nombre='" + this.nombre + '\'' +
                ", precio=" + this.precio +
                '}';
    }

    /**
     * Compara este producto con otro objeto para determinar si son iguales.
     *
     * @param o El objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return idProducto == producto.idProducto;
    }

    /**
     * Devuelve un valor hash para el producto.
     *
     * @return El valor hash del producto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idProducto);
    }
}
