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

//public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
//    private Context mContext;
//    private String[] mImage;
//    private String[] mTitle;
//    private OnNoteListener mOnNoteListener;
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//        TextView title;
//        ImageView imgView;
//        OnNoteListener onNoteListener;
//
//        public MyViewHolder(View itemView,OnNoteListener onNoteListener) {
//            super(itemView);
//            this.title = (TextView) itemView.findViewById(R.id.name);
//            this.imgView = (ImageView) itemView.findViewById(R.id.pic);
//            this. onNoteListener = onNoteListener ;
//            itemView.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View v) {
//            onNoteListener.onNoteClick(getAdapterPosition());
//        }
//
//    }
//
//    public MyAdapter(Context mContext, String[] image,String[] title,OnNoteListener onNoteListener) {
//        this.mContext = mContext;
//        this.mImage = image;
//        this.mTitle = title;
//        this.mOnNoteListener = onNoteListener;
//    }
//
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
//        MyViewHolder myViewHolder = new MyViewHolder(view,mOnNoteListener);
//        return myViewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder (final MyViewHolder holder, final int i) {
//        holder.title.setText(mTitle[i]);
//        Picasso.get().load(mImage[i]).into(holder.imgView);
//
//    }
//    @Override
//    public int getItemCount() {
//        return mTitle.length;
//    }
//
//    public interface OnNoteListener{
//        void onNoteClick(int position);
//
//    }
//
//}




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
