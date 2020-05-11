package roldan.cuellar.hugoerick.proyectofinal_la_pluma_app;

import java.util.ArrayList;

import retrofit2.Call;
import roldan.cuellar.hugoerick.proyectofinal_la_pluma_app.servicio.IServicioProductoApi;
import roldan.cuellar.hugoerick.proyectofinal_la_pluma_app.servicio.ProductoApi;

public class Globales {
    public static IServicioProductoApi servicioProductoApi;
    public static ArrayList<Producto> productos = new ArrayList<Producto>();
    public static Call<ProductoApi> productoApiCall;
}
