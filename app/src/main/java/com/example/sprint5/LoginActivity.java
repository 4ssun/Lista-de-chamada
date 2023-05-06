package com.example.sprint5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btAcessar, btRegistrar;
    EditText txtLogin, txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btAcessar = findViewById(R.id.btAcessar);
        btAcessar.setOnClickListener(this);
        btRegistrar = findViewById(R.id.btRegistrar);
        btRegistrar.setOnClickListener(this);
        txtLogin = findViewById(R.id.txtLogin);
        txtSenha = findViewById(R.id.txtSenha);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btRegistrar) {
            Intent Registrarview = new Intent(this, RegistrarActivity.class);
            startActivity(Registrarview);
        }
        if (v.getId() == R.id.btAcessar) {
            consultarUser();
        }
    }
    public void consultarUser()
    {
        String Email = txtLogin.getText().toString();
        String Senha = txtSenha.getText().toString();

        DBManage bd = new DBManage(getBaseContext());

        Cursor data = bd.LoginData(Email, Senha) ;

        if(data.moveToFirst()){
            Intent tela = new Intent(this, Main.class);
            String email = data.getString(1);
            Bundle parametros = new Bundle();
            parametros.putString("email",email);
            tela.putExtras(parametros);
            startActivity(tela);
        }else{
            String msg= "E-mail ou senha incorretos";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            Clean();
        }
    }
    public void Clean(){
        txtLogin.setText("");
        txtSenha.setText("");
        txtLogin.requestFocus();
    }
}