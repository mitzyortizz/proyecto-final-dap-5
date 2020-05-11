package roldan.cuellar.hugoerick.proyectofinal_la_pluma_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BdCarrito extends SQLiteOpenHelper {
    private static final String CREAR_BD="create table carrito("+
            "idProducto integer not null,"+
            "nombre text not null,"+
            "imagen text not null,"+
            "cantidad integer not null,"+
            "precio double not null)";
    public BdCarrito(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_BD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table carrito");
        onCreate(db);
    }
}
