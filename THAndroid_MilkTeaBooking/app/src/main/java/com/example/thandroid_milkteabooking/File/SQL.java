package com.example.thandroid_milkteabooking.File;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.util.IslamicCalendar;

public class SQL {
    public static Bitmap convertBitMap(byte[] base64converted){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(base64converted,0,base64converted.length,options);
        int h=(int) Math.ceil(options.outHeight/(float)500);
        int w=(int) Math.ceil(options.outWidth/(float)500);

        if(h>1 || w>1){
            if(h>w){
                options.inSampleSize=h;

            }else{
                options.inSampleSize=w;
            }
        }
        options.inJustDecodeBounds = false;
        Bitmap bmp1=BitmapFactory.decodeByteArray(base64converted,0,base64converted.length,options);
        return bmp1;
    }
}
