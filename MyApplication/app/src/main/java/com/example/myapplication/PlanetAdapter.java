package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetHolder> {


    private Context context;
    private ArrayList<Planet> planets;
    public PlanetAdapter(Context context, ArrayList<Planet> planets) {
        this.context = context;
        this.planets = planets;
    }


    @NonNull
    @Override
    public PlanetAdapter.PlanetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.planet_layout_item,parent,false);

        return new PlanetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetAdapter.PlanetHolder holder, int position) {
    Planet planet = planets.get(position);
    holder.SetDetails(planet);
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    class PlanetHolder extends RecyclerView.ViewHolder{
        private TextView txtName, txtDistance, txtGravity,txtDiameter;
        public PlanetHolder(@NonNull View itemView) {
            super(itemView);
            txtName= itemView.findViewById(R.id.txtName);
            txtDistance= itemView.findViewById(R.id.txtDistance);
            txtGravity= itemView.findViewById(R.id.txtGravity);
            txtDiameter= itemView.findViewById(R.id.txtDiameter);

        }
        void SetDetails(Planet planet){
            txtName.setText(planet.getPlanetName());
            txtDistance.setText(String.format(Locale.US,"Distance from sun: %d Million KM",planet.getDistanceFromSun()));
            txtGravity.setText(String.format(Locale.US,"Surface Gravity: %d N/kg", planet.getGravity()));
            txtDiameter.setText(String.format(Locale.US,"Diameter: %d KM" ,planet.getDiameter()));


        }


    }
}
