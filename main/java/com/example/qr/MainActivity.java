package com.example.qr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ename,euser,epass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private static final String myInfo = "Info";
    private static final String myName = "Name";
    private static final String myUser = "Username";
    private static final String myPass = "Password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        euser=findViewById(R.id.username);
        epass=findViewById(R.id.password);

        sharedPreferences=getSharedPreferences(myInfo,MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void register(View view) {
        startActivity(new Intent(this, register.class));
    }
    public void login(View view){
        String username = euser.getText().toString();
        String password = epass.getText().toString();
        String User = sharedPreferences.getString(myUser,"");
        String Pass = sharedPreferences.getString(myPass,"");

        if (username.equals(User) && (password.equals(Pass))){
            startActivity(new Intent(this, profile.class));
        }else {
            Toast.makeText(this, "Wrong details", Toast.LENGTH_SHORT).show();
        }
    }
}
