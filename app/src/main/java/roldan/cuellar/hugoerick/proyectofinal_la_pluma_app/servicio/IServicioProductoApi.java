package roldan.cuellar.hugoerick.proyectofinal_la_pluma_app.servicio;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface IServicioProductoApi {
    @GET("product/list")
    Call<ProductoApi> getListaProductos(@Header("X-Token-Key") String token);

}
