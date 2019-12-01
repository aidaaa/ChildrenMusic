package com.example.childrenmusic.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.childrenmusic.R;
import com.example.childrenmusic.badi.BadyMainActivity;
import com.example.childrenmusic.kobeie.KobeieMainActivity;
import com.example.childrenmusic.main.datamodel.MainDataModel;
import com.example.childrenmusic.radifi.RadifiMainActivity;
import com.example.childrenmusic.zehi_kamani.ZehiKamaniMainActivity;
import com.example.childrenmusic.zehi_zakhmeie.ZehiZakhmeieMainActivity;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private Context context;
    private List<MainDataModel> models;

    public MainAdapter(Context context, List<MainDataModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.main_item,viewGroup,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
        MainDataModel mainDataModel=models.get(i);
        mainViewHolder.img.setImageDrawable(mainDataModel.getImage());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;

        public MainViewHolder(@NonNull final View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_main);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition()==0)
                    {
                        Intent intent=new Intent(context, BadyMainActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==1)
                    {
                        Intent intent=new Intent(context, KobeieMainActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==2)
                    {
                        Intent intent=new Intent(context, RadifiMainActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==3)
                    {
                        Intent intent=new Intent(context, ZehiKamaniMainActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==4)
                    {
                        Intent intent=new Intent(context, ZehiZakhmeieMainActivity.class);
                        context.startActivity(intent);
                    }
                }
            });

        }
    }
}
