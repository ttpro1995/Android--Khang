package com.ttpro.haha.khang;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by haha on 1/8/2015.
 */
public class CustomMenuView extends LinearLayout {
    public ImageView imageView;

    public CustomMenuView(Context context) {
        super(context);

        //layout inflater
        LayoutInflater li = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.drawer_item,this,true);

        //bind
        imageView = (ImageView)findViewById(R.id.DrawerImageView);


    }
}
