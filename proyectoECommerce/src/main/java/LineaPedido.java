public class LineaPedido {
    private Producto producto;
    private int cantidadProducto;

    public LineaPedido(Producto producto, int cantidadProducto){
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
    }

    public void setProducto(Producto producto){ this.producto = producto; }
    public Producto getProducto(){ return producto; }

    public void setCantidadProducto(int cantidadProducto){ this.cantidadProducto = cantidadProducto; }
    public int getCantidadProducto(){ return cantidadProducto; }

    public double getSubtotal(){
        return producto.getPrecio()*cantidadProducto;
    }

    public void mostrarLineaPedido(){
        System.out.println("Producto: " + producto.getNombre());
        System.out.println("Cantidad: " + cantidadProducto);
        System.out.println("Precio: $" + producto.getPrecio());
        System.out.println("Subtotal: $" + getSubtotal());
    }
}
