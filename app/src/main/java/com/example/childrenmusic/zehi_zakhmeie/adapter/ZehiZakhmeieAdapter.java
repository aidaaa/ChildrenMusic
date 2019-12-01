package com.example.childrenmusic.zehi_zakhmeie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.childrenmusic.R;
import com.example.childrenmusic.zehi_zakhmeie.datamodel.ZehiZakhmeieDataModel;

import java.util.List;


public class ZehiZakhmeieAdapter extends RecyclerView.Adapter<ZehiZakhmeieAdapter.AlbumViewHolder> {
    private Context context;
     List<ZehiZakhmeieDataModel> models;
    ZehiZakhmeieOnclick onclick;

    public ZehiZakhmeieAdapter(Context context, List<ZehiZakhmeieDataModel> models,ZehiZakhmeieOnclick onclick) {
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
     /*   ZehiZakhmeieDataModel main=models.get(i);
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

           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition()==0)
                    {
                        Intent intent=new Intent(context, OodPlayerActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==1)
                    {
                        Intent intent=new Intent(context, RobabPlayerActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==2)
                    {
                        Intent intent=new Intent(context, BanjoPlayerActivity.class);
                        context.startActivity(intent);
                    }
                    if (getAdapterPosition()==3)
                    {
                        Intent intent=new Intent(context, ZanborakPlayerActivity.class);
                        context.startActivity(intent);
                    }
                }
            });*/
        }
        void onBind(ZehiZakhmeieDataModel model)
        {
            img.setImageDrawable(model.getImage());
            itemView.setOnClickListener(view -> onclick.onClick(model));
        }
    }
    public interface ZehiZakhmeieOnclick{
        void onClick(ZehiZakhmeieDataModel model);
    }
}
