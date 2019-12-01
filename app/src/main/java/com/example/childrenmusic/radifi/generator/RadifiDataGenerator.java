package com.example.childrenmusic.radifi.generator;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;


import com.example.childrenmusic.R;
import com.example.childrenmusic.radifi.datamodel.RadifiDataModel;

import java.util.ArrayList;
import java.util.List;


public class RadifiDataGenerator
{
    public static List<RadifiDataModel> getRadifiDataModel(Context context)
    {
        List<RadifiDataModel> models=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            RadifiDataModel main=new RadifiDataModel();
            switch (i){
                case 0:
                    main.setId(0);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.se_tar,null));
                    break;
                case 1:
                    main.setId(1);
                        main.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.tar,null));
                    break;
                case 2:
                    main.setId(2);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.tonbak,null));
                    break;
                case 3:
                    main.setId(3);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.qanoon,null));
                    break;
                case 4:
                    main.setId(4);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.santoor,null));
                    break;
            }
            models.add(main);
        }
            return models;
    }
}
