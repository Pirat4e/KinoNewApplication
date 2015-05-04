package com.empire.kinonewapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.empire.kinonewapplication.R;
import com.empire.kinonewapplication.model.Post;
import com.squareup.picasso.Picasso;

/**
 * Created by Ivanco on 04.05.2015.
 */
public class KinoAdapter extends ArrayAdapter<Post> {

    public KinoAdapter(Context context, int resource) {super(context, resource);}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_view, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        final Post p = getItem(position);
        viewHolder.text.setText(p.getTitle());
        Picasso.with(this.getContext())
                .load(String.valueOf(p.getAttachments().get(0).getUrl()))
                .tag(getContext())
                .resize(900, 350)
                .into(viewHolder.image);

        return convertView;
    }
}
