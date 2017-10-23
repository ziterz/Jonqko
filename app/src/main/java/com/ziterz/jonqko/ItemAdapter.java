package com.ziterz.jonqko;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ziterz on 10/21/2017.
 */

public class ItemAdapter extends BaseAdapter {

    Context context;
    ArrayList<Item> arrayList;

    public ItemAdapter(Context context, ArrayList<Item> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder = new ViewHolder();

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item, null);
        }

        holder.img = (ImageView) view.findViewById(R.id.img);

        Item item = arrayList.get(position);
        holder.img.setImageResource(item.getImg());

        return view;
    }

    static class ViewHolder {
        ImageView img;
    }
}
