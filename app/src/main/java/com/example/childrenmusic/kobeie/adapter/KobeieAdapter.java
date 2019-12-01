package com.example.childrenmusic.kobeie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.childrenmusic.R;
import com.example.childrenmusic.badi.datamodel.BadyDataModel;
import com.example.childrenmusic.kobeie.datamodel.KobeieDataModel;

import java.util.List;


public class KobeieAdapter extends RecyclerView.Adapter<KobeieAdapter.AlbumViewHolder> {
    private Context context;
     List<KobeieDataModel> models;
    KobeieOnClick onClick;

    public KobeieAdapter(Context context, List<KobeieDataModel> models,KobeieOnClick onClick) {
        this.context = context;
        this.models = models;
        this.onClick=onClick;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_inner_rv_item,viewGroup,false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder albumViewHolder, int i) {
        /*KobeieDataModel main=models.get(i);
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

        /*    itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition()==0)
                    {
                        Intent intent=new Intent(context, QavalPlayerActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==1)
                    {
                        Intent intent=new Intent(context, NaqarePlayerActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==2)
                    {
                        Intent intent=new Intent(context, DoholPlayerActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==3)
                    {
                        Intent intent=new Intent(context, SenjPlayerActivity.class);
                        context.startActivity(intent);
                    }
                }
            });*/
        }

        void onBind(KobeieDataModel model){
            img.setImageDrawable(model.getImage());
            itemView.setOnClickListener(view -> onClick.onClick(model));
        }
    }
    public interface KobeieOnClick{
        void onClick(KobeieDataModel model);
    }
}
