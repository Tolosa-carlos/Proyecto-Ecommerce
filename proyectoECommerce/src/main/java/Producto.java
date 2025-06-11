
public class Producto {
    private static int contador = 0;
    private int id;
    private String nombre;
    private double precio;
    private int cantStock;

    public Producto(String nombre, double precio, int cantStock){
        this.id = ++contador;
        this.nombre = nombre;
        this.precio = precio;
        this.cantStock = cantStock;
    }

    public void setId(){ this.id = ++contador; }
    public int getId(){ return  id; }

    public void setNombre(String nombre){ this.nombre = nombre; }
    public String getNombre(){ return nombre; }

    public void setPrecio(double precio){ this.precio = precio; }
    public double getPrecio(){ return precio; }

    public void setCantStock(int cantStock){ this.cantStock = cantStock; }
    public int getCantStock(){return cantStock; }

    public void mostrarProducto(){
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Stock: " + cantStock + " unidades");
    }

    public void actualizarProducto(String nuevoNombre, double nuevoPrecio, int nuevoStock){
        this.nombre = nuevoNombre;
        this.precio = nuevoPrecio;
        this.cantStock = nuevoStock;
    }
}
