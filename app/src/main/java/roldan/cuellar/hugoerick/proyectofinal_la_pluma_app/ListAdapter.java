package roldan.cuellar.hugoerick.proyectofinal_la_pluma_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Producto> {
    private List<Producto> myLista;
    private Context myContext;
    private int resourceLayout;

    public ListAdapter(@NonNull Context context, int resource, @NonNull List<Producto> objects) {
        super(context, resource, objects);
        this.myLista = objects;
        this.myContext = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null)
        {
            view = LayoutInflater.from(myContext).inflate(R.layout.item_fila,null);
        }
        Producto modelo = myLista.get(position);
        ImageView imagen = view.findViewById(R.id.imageView1);
        imagen.setImageResource(modelo.getImagen());

        TextView txtCodigo = view.findViewById(R.id.txtCodProducto);
        txtCodigo.setText(modelo.getCodProducto() + "");

        TextView txtNombre = view.findViewById(R.id.txtNombreProducto);
        txtNombre.setText(modelo.getNombre() + "");

        TextView txtPrecio = view.findViewById(R.id.txtPrecioProducto);
        txtPrecio.setText(modelo.getPrecio() + "");

        return view;
    }

}
