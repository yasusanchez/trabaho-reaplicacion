import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private static final int MAX_ITEMS = 10;
    private static int ultimoFolio = 0;

    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceItems;

    // Constructor
    public Factura(String descripcion, Cliente cliente) {
        this.folio = ++ultimoFolio;
        this.descripcion = descripcion;
        this.fecha = new Date();
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.indiceItems = 0;
    }

    // Getters y Setters
    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addItemFactura(ItemFactura item) {
        if (indiceItems < MAX_ITEMS) {
            items[indiceItems++] = item;
        } else {
            System.out.println("No es posible agregar más ítems a la factura.");
        }
    }

    public float calcularTotal() {
        float total = 0;
        for (ItemFactura item : items) {
            if (item != null) {
                total += item.calcularImporte();
            }
        }
        return total;
    }

    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura Nº: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\nDescripción: ")
                .append(descripcion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha Emisión: ")
                .append(df.format(fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");

        for (ItemFactura item : items) {
            if (item != null) {
                sb.append(item)
                        .append("\n");
            }
        }
        sb.append("\nGran Total: ")
                .append(calcularTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
