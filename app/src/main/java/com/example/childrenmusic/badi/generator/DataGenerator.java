package com.example.childrenmusic.badi.generator;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;


import com.example.childrenmusic.R;
import com.example.childrenmusic.badi.datamodel.BadyDataModel;

import java.util.ArrayList;
import java.util.List;


public class DataGenerator
{
    public static List<BadyDataModel> getAlbumDataModel(Context context)
    {
        List<BadyDataModel> models=new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            BadyDataModel main=new BadyDataModel();
            switch (i){
                case 0:
                    main.setId(0);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.qarne,null));
                    break;
                case 1:
                    main.setId(1);
                        main.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.sorna,null));
                    break;
                case 2:
                    main.setId(2);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.ney_jofti,null));
                    break;
                case 3:
                    main.setId(3);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.ney,null));
                    break;
                case 4:
                    main.setId(4);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.boogh,null));
                    break;
                case 5:
                    main.setId(5);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.ney_anboon,null));
                    break;
                case 6:
                    main.setId(6);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.korna,null));
                    break;
            }
            models.add(main);
        }
            return models;
    }
}
