package roldan.cuellar.hugoerick.proyectofinal_la_pluma_app;

public class Producto {
    private int imagen;
    private int codProducto;
    private String nombre;
    private String precio;

    public Producto(int imagen, int codProducto, String nombre, String precio) {
        this.imagen = imagen;
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
