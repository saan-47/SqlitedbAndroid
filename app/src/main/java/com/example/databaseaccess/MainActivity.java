package com.example.databaseaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqLiteDatabase = this.openOrCreateDatabase("MyDB",MODE_PRIVATE,null);
        sqLiteDatabase.execSQL("Create table if not exists MyUsers(name varchar(200), age int(4) )");

    }
    public void addNewUser(View view){
        try{
            EditText txName = findViewById(R.id.editTextTextPersonName);
            String name = txName.getText().toString();
            EditText txAge = findViewById(R.id.editTextTextPersonName2);
            int age = Integer.parseInt(txAge.getText().toString());
            sqLiteDatabase.execSQL("Insert into MyUsers (name,age) values('"+name+"','"+age+"')");
            //Toast.makeText(this, "User Added", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}