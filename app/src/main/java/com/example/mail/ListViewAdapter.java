package com.example.mail;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private ArrayList<ContactNames> arraylist;

    List<ContactNames> contacts;

    public ListViewAdapter(Context context ) {
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<ContactNames>();
        this.arraylist.addAll(MainActivity.namesArrayList);
    }

    public class ViewHolder {
        TextView fullname;
        TextView title;
        TextView description;
        TextView text_round;
        TextView time;
        ImageView image_avatar;

    }

    @Override
    public int getCount() {
        return MainActivity.namesArrayList.size();
    }

    @Override
    public ContactNames getItem(int position) {
        return MainActivity.namesArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.fullname = (TextView) view.findViewById(R.id.fullname);
            holder.time = (TextView) view.findViewById(R.id.time);
            holder.image_avatar = (ImageView) view.findViewById(R.id.image_avatar);
            holder.text_round = (TextView) view.findViewById(R.id.text_round);
            holder.title = (TextView) view.findViewById(R.id.title);
            holder.description = (TextView) view.findViewById(R.id.description);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.fullname.setText(MainActivity.namesArrayList.get(position).getFullname());

        holder.text_round.setText(MainActivity.namesArrayList.get(position).getTextRound());
        holder.title.setText(MainActivity.namesArrayList.get(position).getTitle());
        holder.description.setText(MainActivity.namesArrayList.get(position).getDes());
        holder.time.setText(MainActivity.namesArrayList.get(position).getTime());


        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        MainActivity.namesArrayList.clear();
        if (charText.length() == 0) {
            MainActivity.namesArrayList.addAll(arraylist);
        } else {
            for (ContactNames wp : arraylist) {
                if (wp.getFullname().toLowerCase(Locale.getDefault()).contains(charText)) {
                    MainActivity.namesArrayList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}