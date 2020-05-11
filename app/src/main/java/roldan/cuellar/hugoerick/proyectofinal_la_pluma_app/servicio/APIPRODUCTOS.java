package roldan.cuellar.hugoerick.proyectofinal_la_pluma_app.servicio;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//http://mitzyortiz.eu5.org/servicios/obtener_productos_service2.php
//http://mitzyortiz.eu5.org/servicios/guardar_productos_service.php?nombre=banana&precio=8
public class APIPRODUCTOS {
    public static final String URL_BASE = "http://dap5.whilex.com/api/v1/";
    public static Retrofit retrofit = null;
    public static Retrofit getAPI() {
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
