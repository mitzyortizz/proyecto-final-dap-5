package roldan.cuellar.hugoerick.proyectofinal_la_pluma_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import roldan.cuellar.hugoerick.proyectofinal_la_pluma_app.servicio.APIPRODUCTOS;
import roldan.cuellar.hugoerick.proyectofinal_la_pluma_app.servicio.IServicioProductoApi;
import roldan.cuellar.hugoerick.proyectofinal_la_pluma_app.servicio.ProductoApi;
import roldan.cuellar.hugoerick.proyectofinal_la_pluma_app.servicio.ProductoRecordApi;

public class LoginActovity extends AppCompatActivity {
    EditText txtEmail;
    EditText txtPassword;
    EditText txtConfirmarPassword;
    Switch swRecordarUsuario;
    SharedPreferences preferencias;
    String email;
    String password;
    Boolean recordar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_actovity);
        iniciarControls();
        cargarPreferenciasUsuario();
    }

    public void guardarUsuario()
    {
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("email",txtEmail.getText().toString());
        editor.putString("password",txtPassword.getText().toString());
        editor.putBoolean("recordarusuario",swRecordarUsuario.isChecked());
        editor.apply();
    }

    public void IniciarSesionClick (View view)
    {
        if (validarDatos())
        {
            guardarUsuario();
            cargarProductosYMostrarPantallaPrincipal("d8cc8a3ce0ce2b7a8a77539f5972e84409cafa98");
        }
    }

    private void mostrarPantallaPrincipal() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    private boolean validarDatos() {
        if (!email.isEmpty() && !password.isEmpty())
        {
            if (txtPassword.getText().toString().equals(password) && txtEmail.getText().toString().equals(email))
                return true;
            else
            {
                Toast.makeText(this, "Error usuario contraseña incorretos", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        else
        {
            String emailIngresado = txtEmail.getText().toString();
            String passwordIngresado = txtPassword.getText().toString();
            String confirmarPasswordIngresado = txtConfirmarPassword.getText().toString();
            if (emailIngresado.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emailIngresado).matches())
            {
                Toast.makeText(this, "Error de formato email", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (passwordIngresado.isEmpty() || passwordIngresado.length()<4 || !passwordIngresado.equals(confirmarPasswordIngresado))
            {
                Toast.makeText(this, "Error de password, password minimo 4 digitos", Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
        }
    }

    public void cargarPreferenciasUsuario()
    {
        email = preferencias.getString("email","");
        password = preferencias.getString("password","");
        recordar = preferencias.getBoolean("recordarusuario",false);
        if (!email.isEmpty() && !password.isEmpty())
        {
            txtConfirmarPassword.setVisibility(View.INVISIBLE);
            if (recordar==true)
            {
                txtEmail.setText(email);
                txtPassword.setText(password);
                swRecordarUsuario.setChecked(true);
            }
            else
                swRecordarUsuario.setChecked(false);
        }
    }

    public void iniciarControls()
    {
        txtEmail = findViewById(R.id.editTextEmail);
        txtPassword = findViewById(R.id.editTextPasword);
        txtConfirmarPassword = findViewById(R.id.editTextConfirmarPassword);
        swRecordarUsuario = findViewById(R.id.switchRecordarUsuario);
        preferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
    }

    private void cargarProductosYMostrarPantallaPrincipal(String token) {
        IServicioProductoApi servicio = APIPRODUCTOS.getAPI().create(IServicioProductoApi.class);
        Globales.productoApiCall = servicio.getListaProductos(token);
        Globales.productoApiCall.enqueue(new Callback<ProductoApi>() {
            @Override
            public void onResponse(Call<ProductoApi> call, Response<ProductoApi> response) {
                try {
                    if (response.isSuccessful()){
                        ProductoApi productoApiTest = response.body();
                        for (ProductoRecordApi record : response.body().getData().getRecords()) {
                            Globales.productos.add(new Producto(R.mipmap.naranja, record.getId(), record.getDescription(), record.getPrice() ));
                        }
                        mostrarPantallaPrincipal();
                    }
                }
                catch (Exception E){
                    Toast.makeText(LoginActovity.this, "Error: "+E.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProductoApi> call, Throwable t) {

                Toast.makeText(LoginActovity.this, "Error: al cargar los productos, intente mas tarde | " + t.getCause(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
