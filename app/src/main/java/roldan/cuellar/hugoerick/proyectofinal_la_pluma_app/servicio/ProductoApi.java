package roldan.cuellar.hugoerick.proyectofinal_la_pluma_app.servicio;

import com.google.gson.annotations.SerializedName;

public class ProductoApi {
    @SerializedName("data")
    private ProductDataApi data;

    public ProductoApi(ProductDataApi data) {
        this.data = data;
    }

    public ProductDataApi getData() {
        return data;
    }

    public void setData(ProductDataApi data) {
        this.data = data;
    }
}
