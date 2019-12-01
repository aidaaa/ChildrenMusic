package com.example.childrenmusic.radifi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.childrenmusic.R;
import com.example.childrenmusic.radifi.datamodel.RadifiDataModel;

import java.util.List;


public class RadifiAdapter extends RecyclerView.Adapter<RadifiAdapter.AlbumViewHolder> {
    private Context context;
     List<RadifiDataModel> models;
    RadifiOnclick onclick;

    public RadifiAdapter(Context context, List<RadifiDataModel> models ,  RadifiOnclick onclick) {
        this.context = context;
        this.models = models;
        this.onclick=onclick;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_inner_rv_item,viewGroup,false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder albumViewHolder, int i) {
        /*RadifiDataModel main=models.get(i);
        albumViewHolder.img.setImageDrawable(main.getImage());*/
        albumViewHolder.onBind(models.get(albumViewHolder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder
    {

        private ImageView img;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_inner);
/*
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition()==0)
                    {
                        Intent intent=new Intent(context, SetarPlayerActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==1)
                    {
                        Intent intent=new Intent(context, TarPlayerActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==2)
                    {
                        Intent intent=new Intent(context, TombakPlayerActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==3)
                    {
                        Intent intent=new Intent(context, QanonPlayerActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==4)
                    {
                        Intent intent=new Intent(context, SantorPlayerActivity.class);
                        context.startActivity(intent);
                    }
                }
            });*/
        }

        void onBind(RadifiDataModel model)
        {
            img.setImageDrawable(model.getImage());
            itemView.setOnClickListener(view -> onclick.onClick(model));
        }
    }
    public interface RadifiOnclick
    {
        void onClick(RadifiDataModel model);
    }
}
