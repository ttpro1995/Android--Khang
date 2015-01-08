package com.ttpro.haha.khang;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by haha on 1/8/2015.
 */
public class CustomMenuAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<Drawable> objects;
    public CustomMenuAdapter(Context context, int resource, ArrayList<Drawable> objects) {
        super(context, resource, objects);

        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View retView = convertView;
        if (retView==null)
            retView = new CustomMenuView(getContext());

         Drawable image = objects.get(position);

        ImageView imageView = ((CustomMenuView)retView).imageView;

        imageView.setImageDrawable(image);


        return retView;
        //return super.getView(position, convertView, parent);
    }
}
