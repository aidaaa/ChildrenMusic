package com.example.childrenmusic.zehi_kamani.generator;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;

import com.example.childrenmusic.R;
import com.example.childrenmusic.zehi_kamani.datamodel.ZehiKamaniDataModel;

import java.util.ArrayList;
import java.util.List;


public class ZehiKamaniDataGenerator
{
    public static List<ZehiKamaniDataModel> getZehiKamaniDataModel(Context context)
    {
        List<ZehiKamaniDataModel> models=new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ZehiKamaniDataModel main=new ZehiKamaniDataModel();
            switch (i){
                case 0:
                    main.setId(0);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.kamanche,null));
                    break;
                case 1:
                    main.setId(1);
                        main.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.qoychak,null));
                    break;
            }
            models.add(main);
        }
            return models;
    }
}
