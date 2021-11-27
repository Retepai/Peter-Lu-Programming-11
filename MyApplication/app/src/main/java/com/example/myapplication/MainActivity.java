package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView normal_recycler;

    private PlanetAdapter adapter;
    private ArrayList<Planet> planetArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        normal_recycler= findViewById(R.id.recyclerview);
        normal_recycler.setLayoutManager(new LinearLayoutManager(this));
        planetArrayList= new ArrayList<>();
        adapter = new PlanetAdapter(this,planetArrayList);
        normal_recycler.setAdapter(adapter);
        normal_recycler.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        createListData();
    }

    private void createListData() {
        //This methode is for adding the data to recyclerView
        //lit's make adapter and plaent model class




        Planet planet= new Planet("Earth",150,10,12750);
        planetArrayList.add(planet);
        Planet planet1= new Planet("urmom",150,10,12750);
        planetArrayList.add(planet1);
        Planet planet2= new Planet("uranus",150,10,12750);
        planetArrayList.add(planet2);
        Planet planet3= new Planet("gay",150,10,12750);
        planetArrayList.add(planet3);
        Planet planet4= new Planet("Earth",150,10,12750);
        planetArrayList.add(planet4);
        Planet planet5= new Planet("urmom",150,10,12750);
        planetArrayList.add(planet5);
        Planet planet6= new Planet("uranus",150,10,12750);
        planetArrayList.add(planet6);
        Planet planet7= new Planet("gay",150,10,12750);
        planetArrayList.add(planet7);
    }
}