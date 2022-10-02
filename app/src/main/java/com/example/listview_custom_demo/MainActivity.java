package com.example.listview_custom_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Country> myList = new ArrayList<>();

        Country vn = new Country("Vietnam", "ad", 97338579);
        Country ru = new Country("Russia", "ae", 97331579);
        Country us = new Country("United States", "af", 97334579);
        Country jp = new Country("Japan", "ag", 97335579);
        Country en = new Country("United Kingdom", "ai", 97338679);
        Country fr = new Country("France", "al", 97338279);
        Country ab = new Country("Nothing", "al", 125764896);

        myList.add(vn);
        myList.add(ru);
        myList.add(us);
        myList.add(jp);
        myList.add(en);
        myList.add(fr);
        myList.add(ab);

        final ListView listView = (ListView) findViewById(R.id.listVIew_item);
        listView.setAdapter(new CustomListView(this, myList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Country country = (Country) o;
                Toast.makeText(MainActivity.this, "Selected: " + " " + country, Toast.LENGTH_LONG).show();
            }
        });
    }
}