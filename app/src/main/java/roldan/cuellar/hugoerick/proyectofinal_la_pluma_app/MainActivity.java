package roldan.cuellar.hugoerick.proyectofinal_la_pluma_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import roldan.cuellar.hugoerick.proyectofinal_la_pluma_app.servicio.APIPRODUCTOS;
import roldan.cuellar.hugoerick.proyectofinal_la_pluma_app.servicio.IServicioProductoApi;
import roldan.cuellar.hugoerick.proyectofinal_la_pluma_app.servicio.ProductoApi;
import roldan.cuellar.hugoerick.proyectofinal_la_pluma_app.servicio.ProductoRecordApi;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener  {

    ListView myListView;
    List<Producto> miListaDeProductos = new ArrayList<Producto>();
    ListAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarLista();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menulogin,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_cerrarsesion: cerrarSesion();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void cerrarSesion() {
        Intent intent = new Intent(this,LoginActovity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void cargarLista() {

        myListView = findViewById(R.id.listView1);
        adaptador = new ListAdapter(this, R.layout.item_fila, Globales.productos);
        myListView.setAdapter(adaptador);
        myListView.setOnItemClickListener(this);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Producto productoSeleccionadio = miListaDeProductos.get(position);
        Toast.makeText(this, "Item seleccionado nro: " + position + " " + productoSeleccionadio.getNombre(), Toast.LENGTH_SHORT).show();
    }
}
