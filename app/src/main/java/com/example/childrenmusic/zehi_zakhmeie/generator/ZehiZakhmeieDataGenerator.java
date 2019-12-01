package com.example.childrenmusic.zehi_zakhmeie.generator;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;

import com.example.childrenmusic.R;
import com.example.childrenmusic.zehi_zakhmeie.datamodel.ZehiZakhmeieDataModel;

import java.util.ArrayList;
import java.util.List;


public class ZehiZakhmeieDataGenerator
{
    public static List<ZehiZakhmeieDataModel> getZehiZakhmeieDataModel(Context context)
    {
        List<ZehiZakhmeieDataModel> models=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ZehiZakhmeieDataModel main=new ZehiZakhmeieDataModel();
            switch (i) {
                case 0:
                    main.setId(0);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.ood, null));
                    break;
                case 1:
                    main.setId(1);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.robab, null));
                    break;
                case 2:
                    main.setId(2);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.banjo, null));
                    break;
                case 3:
                    main.setId(3);
                    main.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.zanboorak, null));
                    break;
            }
                models.add(main);
            }
            return models;
    }
}
