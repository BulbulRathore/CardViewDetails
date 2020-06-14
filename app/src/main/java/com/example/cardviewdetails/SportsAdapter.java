package com.example.cardviewdetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.MyViewHolder> {

    private final List<Sport> sportList = new ArrayList<>();
    private Context context;

    public SportsAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public SportsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(myView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SportsAdapter.MyViewHolder holder, int position) {
        Sport sport = sportList.get(position);
        holder.bindTo(sport);
    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }

    public void addSportsToList(Sport sport){
        sportList.add(sport);
        notifyItemInserted(sportList.size()-1);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView sportImage;
        TextView title;
        TextView info;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sportImage = itemView.findViewById(R.id.sportImage);
            title = itemView.findViewById(R.id.newsTitle);
            info = itemView.findViewById(R.id.subTitle);
        }

        void bindTo(Sport currentSport){
            title.setText(currentSport.getTitle());
            info.setText(currentSport.getInfo());
            Glide.with(context).load(currentSport.getImageResource()).into(sportImage);
        }
    }
}
