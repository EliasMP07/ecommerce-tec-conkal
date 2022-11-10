package com.example.mitienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegistrar extends AppCompatActivity {

    SQLite DB;
    Button botonCrearCuenta, botonTengoCuenta;
    EditText nombre, apellidoPa, apellidoMa, userName, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_registrar);

        botonTengoCuenta = (Button) findViewById(R.id.btnTengoCuenta);
        nombre = (EditText) findViewById(R.id.txtNombres);
        apellidoPa = (EditText) findViewById(R.id.txtApellidoPaterno);
        apellidoMa = (EditText) findViewById(R.id.txtApellidoMaterno);
        userName = (EditText) findViewById(R.id.txtUserName);
        password = (EditText) findViewById(R.id.txtPassword);

        DB = new SQLite(this);

        botonTengoCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ActivityRegistrar.this, MainActivity.class);
                startActivity(i);
                finish();



            }
        });


    }

    public void Registrar (View view){

        String nombres = nombre.getText().toString();
        String apellidoP = apellidoPa.getText().toString();
        String apellidoM = apellidoMa.getText().toString();
        String username = userName.getText().toString();
        String pass = password.getText().toString();

        if (nombres.length() > 0 && apellidoP.length() > 0 && apellidoM.length() > 0 && username.length() > 0 && pass.length() > 0) {

            SQLiteDatabase db = DB.getWritableDatabase();

                db.execSQL("INSERT INTO usuarios (Nombres,ApellidoP,ApellidoM,Username,Password) VALUES ('" + nombres + "', '" + apellidoP + "','" + apellidoM + "','" + username + "','" + pass + "')");
                db.close();
                Toast.makeText(this, "Los datos generales se han registrado", Toast.LENGTH_SHORT).show();


                nombre.setText("");
                apellidoPa.setText("");
                apellidoMa.setText("");
                userName.setText("");
                password.setText("");

        }
        else
        {
            Toast.makeText(this, "Ingrese todos los datos generales", Toast.LENGTH_SHORT).show();
        }



    }
}