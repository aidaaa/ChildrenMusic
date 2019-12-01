package com.example.childrenmusic.main.generator;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;


import com.example.childrenmusic.R;
import com.example.childrenmusic.main.datamodel.MainDataModel;

import java.util.ArrayList;
import java.util.List;

public class MainDataGenarator
{
    public static List<MainDataModel> getMainDataModel(Context context)
    {
        List<MainDataModel> models=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MainDataModel main=new MainDataModel();
            switch (i)
            {
                case 0:
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.bady_menu,null));
                    break;
                case 1:
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.koobei_menu,null));
                    break;
                case 2:
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.radifi_menu,null));
                    break;
                case 3:
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.zehi_kamani_menu,null));
                    break;
                case 4:
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.zehi_zakhme_menu,null));
                   break;
            }
            models.add(main);
        }
        return models;
    }
}
