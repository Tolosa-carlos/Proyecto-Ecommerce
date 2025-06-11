import java.util.*;

public class GestorProductos {
    private ArrayList<Producto> listaProductos = new ArrayList<>();

    public void agregarProductos(String nombre, double precio, int stock){
        Producto nuevoProducto = new Producto(nombre, precio, stock);
        listaProductos.add(nuevoProducto);
        System.out.println("Producto agregado correctamente");
    }

    public void mostrarListaProductos(){
        for (Producto p : listaProductos){
            p.mostrarProducto();
            System.out.println("---------------------------------");
        }
    }

    public Producto buscarProducto(int id){
        for (Producto p : listaProductos){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void eliminarProducto(int id){
        Producto producto = buscarProducto(id);
        if (producto != null){
            System.out.println("Producto: " + producto + "eliminado");
            listaProductos.remove(producto);
        }
        System.out.println("Producto no encontrado");
    }

    public void actualizarProducto(int id, String nuevoNombre, double nuevoPrecio, int nuevoStock){
        Producto producto = buscarProducto(id);
        if (producto != null){
            producto.setNombre(nuevoNombre);
            producto.setPrecio(nuevoPrecio);
            producto.setCantStock(nuevoStock);
            System.out.println("Producto actualizado correctamente.");
        }else {
            System.out.println("Producto no encontrado.");
        }
    }

}
