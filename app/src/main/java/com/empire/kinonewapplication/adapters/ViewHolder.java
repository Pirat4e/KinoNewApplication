package com.empire.kinonewapplication.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.empire.kinonewapplication.R;

/**
 * Created by Ivanco on 04.05.2015.
 */
public class ViewHolder {
    public TextView text;
    public ImageView image;
    public ViewHolder (View convertView){
        text = (TextView) convertView.findViewById(R.id.txt_tittle);
        image = (ImageView) convertView.findViewById(R.id.img_poster);
    }
}
