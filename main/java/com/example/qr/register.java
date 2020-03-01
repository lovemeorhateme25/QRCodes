package com.example.qr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

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
        setContentView(R.layout.activity_register);

        ename=findViewById(R.id.name);
        euser=findViewById(R.id.username);
        epass=findViewById(R.id.password);

        sharedPreferences=getSharedPreferences(myInfo,MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void login(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void submit(View view){
        String name = ename.getText().toString();
        String user = euser.getText().toString();
        String pass = epass.getText().toString();

        editor.putString(myName,name);
        editor.putString(myUser,user);
        editor.putString(myPass,pass);
        editor.commit();
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
        ename.setText("");
        epass.setText("");
        euser.setText("");
    }
}
