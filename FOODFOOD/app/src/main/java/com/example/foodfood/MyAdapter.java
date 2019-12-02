package com.example.foodfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<List2>  List2;

    public MyAdapter(Context c,ArrayList<List2> p){
        context =c ;
        List2= p;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(List2.get(position).getName());
        Picasso.get().load(List2.get(position).getPic()).into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return List2.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView pic;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.name);
            pic = (ImageView) itemView.findViewById((R.id.pic));
        }
    }
}
