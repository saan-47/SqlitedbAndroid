package com.example.databaseaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        try{
            sqLiteDatabase = this.openOrCreateDatabase("MyDB", MODE_PRIVATE,null);
            Cursor c = sqLiteDatabase.rawQuery("select * from MyUsers",null);
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            c.moveToFirst();
            ListView listView = findViewById(R.id.listviewname);
            GridView gridView = findViewById(R.id.gridview);
            ArrayList<String> strings = new ArrayList<>();
            while (!c.isAfterLast()){
                //Toast.makeText(this, c.getString(nameIndex), Toast.LENGTH_SHORT).show();
                //ArrayAdapter<String> tArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.g, strings);
                strings.add(c.getString(nameIndex));
                c.moveToNext();
            }
            ArrayAdapter<String> tArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, strings);
            listView.setAdapter(tArrayAdapter);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}