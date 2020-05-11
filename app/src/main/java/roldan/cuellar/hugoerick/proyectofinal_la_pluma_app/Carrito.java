package roldan.cuellar.hugoerick.proyectofinal_la_pluma_app;

public class Carrito {
    private Integer productId;
    private String nombre;
    private Integer cantidad;
    private Double precio;
    private String image;

    public Carrito(Integer productId, String nombre, Integer cantidad, Double precio, String image) {
        this.productId = productId;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.image = image;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
