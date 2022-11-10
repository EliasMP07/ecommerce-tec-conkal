package com.example.mitienda;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {

    String ConstEst = "CREATE TABLE usuarios (idUsuario INTEGER PRIMARY KEY  AUTOINCREMENT, Nombres TEXT NOT NULL, ApellidoP TEXT NOT NULL, ApellidoM TEXT NOT NULL, Username TEXT NOT NULL, Password TEXT NOT NULL)";
    String ConstEst2 = "CREATE TABLE datossolicitud (NControl NUMERIC PRIMARY KEY NOT NULL CHECK(8), Semestre NUMERIC NOT NULL, Carrera TEXT NOT NULL)";


    public SQLite(Context context)
    {
        super(context, "dbPrincipal", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ConstEst);
        db.execSQL(ConstEst2);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(ConstEst2);
        db.execSQL(ConstEst);
        db.execSQL("DROP TABLE IF EXISTS Propietario");
    }



    public boolean checkusernamepassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select* from usuarios where Username=? and Password=?", new String[] {username,password});
        if (cursor.getCount() > 0)
            return true;
        else
            return  false;
    }

}