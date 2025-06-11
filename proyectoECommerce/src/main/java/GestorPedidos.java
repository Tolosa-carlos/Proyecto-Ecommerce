import javax.sound.midi.Soundbank;
import java.util.*;

public class GestorPedidos {
    private ArrayList<Pedido> pedidos;
    private GestorProductos gestorProductos;

    public GestorPedidos(GestorProductos gestorProductos){
        this.gestorProductos = gestorProductos;
        this.pedidos = new ArrayList<>();
    }

    public void crearPedido(){
        Scanner scanner = new Scanner(System.in);
        Pedido nuevoPedido = new Pedido();
        String continuar = "";

        do {
            gestorProductos.mostrarListaProductos();
            System.out.println("Ingrese el ID del producto: ");
            int id = scanner.nextInt();
            Producto producto = gestorProductos.buscarProducto(id);
            if (producto == null){
                System.out.println("Producto no encontrado.");
                continue;
            }

            System.out.println("Ingrese la cantidad deseada: ");
            int cantidad = scanner.nextInt();
            if (cantidad <= 0){
                System.out.println("La cantidad debe ser mayor a 0.");
                continue;
            }
            if (cantidad > producto.getCantStock()){
                System.out.println("Stock insuficiente. Disponible: " + producto.getCantStock());
                continue;
            }

            LineaPedido linea = new LineaPedido(producto, cantidad);
            nuevoPedido.agregarLinea(linea);

            System.out.println("Quiere agregar otro producto? (s/n): ");
            scanner.nextLine();
            continuar = scanner.nextLine();

        }while (continuar.equalsIgnoreCase("s"));

        for (LineaPedido linea : nuevoPedido.getLineasPedidos()){
            Producto p = linea.getProducto();
            int cantidad = linea.getCantidadProducto();
            p.setCantStock(p.getCantStock() - cantidad);
        }

        pedidos.add(nuevoPedido);
        System.out.println("Pedido registrado con exito.");
        nuevoPedido.mostrarPedido();

        }

    public void mostrarPedidos(){
        if (pedidos.isEmpty()){
            System.out.println("No hay pedidos.");
            return;
        }
        System.out.println("-----------------------Lista de pedidos-----------------------");
        int numero = 1;
        for (Pedido p : pedidos){
            System.out.println("- Pedido #" + numero + ":");
            p.mostrarPedido();
            numero++;
        }
    }
}
