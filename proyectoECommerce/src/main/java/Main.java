import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorProductos gestorProductos = new GestorProductos();
        GestorPedidos gestorPedidos = new GestorPedidos(gestorProductos);
        int opc;

        do {
            System.out.println("-------------------------------------------------");
            System.out.println("----------------Sistema de gestion---------------");
            System.out.println("-------------------------------------------------");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar/Actualizar producto");
            System.out.println("4) Eliminar producto");
            System.out.println("5) Crear un pedido");
            System.out.println("6) Listar pedidos");
            System.out.println("0) Salir");
            System.out.println("Seleccione una opción: ");
            opc = scanner.nextInt();

            switch (opc){
                case 1:
                    scanner.nextLine();
                    System.out.println("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Precio: $");
                    double precio = scanner.nextDouble();
                    System.out.println("Stock: ");
                    int cantidad = scanner.nextInt();
                    gestorProductos.agregarProductos(nombre, precio, cantidad);
                    break;

                case 2:
                    gestorProductos.mostrarListaProductos();
                    break;

                case 3:
                    System.out.println("ID del producto a buscar: ");
                    int idABuscar = scanner.nextInt();
                    Producto producto = gestorProductos.buscarProducto(idABuscar);
                    if (producto != null){
                        System.out.println("Producto encontrado:");
                        producto.mostrarProducto();
                        System.out.print("Desea actualizar algun dato? (s/n): ");
                        scanner.nextLine();
                        String respuesta = scanner.nextLine();
                        if (respuesta.equalsIgnoreCase("s")){
                            System.out.println("Nombre: ");
                            String nuevoNombre = scanner.nextLine();
                            System.out.println("Precio: ");
                            double nuevoPrecio = scanner.nextDouble();
                            System.out.println("Stock: ");
                            int nuevaCantidad = scanner.nextInt();
                            //gestorProductos.
                        }
                    }else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("ID del producto a eliminar: ");
                    int idAEliminar = scanner.nextInt();
                    gestorProductos.eliminarProducto(idAEliminar);
                    break;

                case 5:
                    gestorPedidos.crearPedido();
                    break;

                case 6:
                    gestorPedidos.mostrarPedidos();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opción invalida. Intente denuevo.");
            }
        }while (opc != 0);

        scanner.close();
    }
}
