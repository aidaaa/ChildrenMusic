package com.example.childrenmusic.kobeie.generator;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;


import com.example.childrenmusic.R;
import com.example.childrenmusic.kobeie.datamodel.KobeieDataModel;

import java.util.ArrayList;
import java.util.List;


public class KobeieDataGenerator
{
    public static List<KobeieDataModel> getKobeieDataModel(Context context)
    {
        List<KobeieDataModel> models=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            KobeieDataModel main=new KobeieDataModel();
            switch (i){
                case 0:
                    main.setId(0);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.qavaal,null));
                    break;
                case 1:
                    main.setId(1);
                        main.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.naqare,null));
                    break;
                case 2:
                    main.setId(2);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.dohol,null));
                    break;
                case 3:
                    main.setId(3);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.senj,null));
                    break;
            }
            models.add(main);
        }
            return models;
    }
}
