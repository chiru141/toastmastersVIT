package com.chiru141.toastmastervit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by chiru141 on 22-Mar-16.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    EditText username,password;
    Button login,register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
        setinit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.register:
                String user=username.getText().toString();
                String pass=password.getText().toString();
                saveCredentials(user,pass);
                goToMainActivity();
                break;
            case R.id.login:
                String user1=username.getText().toString();
                String pass1=password.getText().toString();
                validateCredentials(user1,pass1);
                break;

        }
    }

    private void validateCredentials(String user, String pass) {
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        String spUser=sharedPreferences.getString("username",null);
        String spPass=sharedPreferences.getString("password",null);
        if(user.equals(spUser) && pass.equals(spPass))
        {
            goToMainActivity();
        }
        else
        {
            showMessage("Invalid Credentials");
        }

    }

    private void showMessage(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    private void goToMainActivity() {
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();

    }

    private void saveCredentials(String user, String pass) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username",user);
        editor.putString("password",pass);
        editor.apply();
    }

    private void setinit() {
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    private void init() {

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
    }
}
