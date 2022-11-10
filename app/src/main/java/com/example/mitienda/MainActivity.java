package com.example.mitienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.mitienda.SQLite;


public class MainActivity extends AppCompatActivity {
    Button registrar, iniciarSeccion;
    EditText userName, Pass;
    SQLite DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        registrar = (Button) findViewById(R.id.btnCrear);
        userName = (EditText) findViewById(R.id.txtUser);
        Pass = (EditText) findViewById(R.id.txtPasswordd);
        DB = new SQLite(this);

        iniciarSeccion = (Button) findViewById(R.id.btnIniciar);

        iniciarSeccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String user = userName.getText().toString();
               String pass = Pass.getText().toString();

               if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))

                   Toast.makeText(MainActivity.this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
               else{
                   Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                   if (checkuserpass == true){
                       Toast.makeText(MainActivity.this, "Inicio Correcto", Toast.LENGTH_SHORT).show();
                       Intent i = new Intent(MainActivity.this, ActivityInicio.class);
                       startActivity(i);
                       finish();
                   }else{
                       Toast.makeText(MainActivity.this, "Inicio incorrecto", Toast.LENGTH_SHORT).show();
                   }
               }



            }
        });


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, ActivityRegistrar.class);
                startActivity(i);
                finish();



            }
        });



    }


}