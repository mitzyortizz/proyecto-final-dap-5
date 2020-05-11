package roldan.cuellar.hugoerick.proyectofinal_la_pluma_app.servicio;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductDataApi {
    @SerializedName("records")
    private List<ProductoRecordApi> records;

    public ProductDataApi(List<ProductoRecordApi> records) {
        this.records = records;
    }

    public List<ProductoRecordApi> getRecords() {
        return records;
    }

    public void setRecords(List<ProductoRecordApi> records) {
        this.records = records;
    }
}
