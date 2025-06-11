import java.util.*;

public class Pedido {
    private ArrayList<LineaPedido> lineasPedidos = new ArrayList<>();

    public ArrayList<LineaPedido> getLineasPedidos(){ return lineasPedidos; }
    public void agregarLinea(LineaPedido lineaPedido){
        lineasPedidos.add(lineaPedido);
        System.out.println("Agregado al carrito");
    }

    public double calcularTotal(){
        double total = 0;
        for (LineaPedido lp : lineasPedidos){
            total = total + lp.getSubtotal();
        }
        return total;
    }

    public void mostrarPedido(){
        System.out.println("Detalles del pedido: ");
        for (LineaPedido lp : lineasPedidos){
            lp.mostrarLineaPedido();
        }
        System.out.println("Total: $" + calcularTotal());
    }
}
