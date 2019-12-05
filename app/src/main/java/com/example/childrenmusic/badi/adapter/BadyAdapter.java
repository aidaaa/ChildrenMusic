package com.example.childrenmusic.badi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.childrenmusic.R;
import com.example.childrenmusic.badi.BadyMainActivity;
import com.example.childrenmusic.badi.datamodel.BadyDataModel;

import java.util.List;


public class BadyAdapter extends RecyclerView.Adapter<BadyAdapter.AlbumViewHolder> {
    private Context context;
    private List<BadyDataModel> models;

     private OnItemClickListener listener;

    public BadyAdapter(Context context , List<BadyDataModel> models , OnItemClickListener listener) {
        this.context = context;
        this.models = models;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_inner_rv_item,viewGroup,false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder albumViewHolder, int i) {

        albumViewHolder.onBind(models.get(albumViewHolder.getAdapterPosition()));
        int h=albumViewHolder.img.getHeight();
        /*BadyDataModel main=models.get(i);
        albumViewHolder.img.setImageDrawable(main.getImage());*/
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

     class AlbumViewHolder extends RecyclerView.ViewHolder
    {

        private ImageView img;

        AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_inner);

         /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition()==0)
                    {
                        Intent intent=new Intent(context, QerneActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==1)
                    {
                        Intent intent=new Intent(context, SurnaActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==2)
                    {
                        Intent intent=new Intent(context, NeyJoftiActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==3)
                    {
                        Intent intent=new Intent(context, NeyActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==4)
                    {
                        Intent intent=new Intent(context, BoqActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==5)
                    {
                        Intent intent=new Intent(context, NeyAnbanonActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==6)
                    {
                        Intent intent=new Intent(context, KornaActivity.class);
                        context.startActivity(intent);
                    }
                }
            });*/
        }

        void onBind(BadyDataModel model){
            img.setImageDrawable(model.getImage());
            itemView.setOnClickListener(view -> listener.onClick(model));
        }
    }

    public interface OnItemClickListener{
        void onClick(BadyDataModel model );
    }
}
