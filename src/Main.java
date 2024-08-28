import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Crear de cliente
        Cliente cliente = new Cliente("Andrés", "4444-4");

        // Solicitar descripción de la factura
        System.out.print("Ingrese una descripción de la factura");
        String descripcion = s.nextLine();
        Factura factura = new Factura(descripcion, cliente);

        // Crear prodductos e ítems
        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese el nombre del producto nº " + (i + 1) + ": ");
            String nombre = s.nextLine();

            System.out.print("Ingrese el precio: ");
            double precio = s.nextDouble();

            System.out.print("Ingrese la cantidad: ");
            int cantidad = s.nextInt();
            s.nextLine(); // consumir el salto de linea

            Producto producto = new Producto(nombre, precio);
            ItemFactura itemFactura = new ItemFactura(producto, cantidad);
            factura.addItemFactura(itemFactura);

            System.out.println();
        }

        // Mostrar detalle de la factura
        System.out.println(factura);
    }
}