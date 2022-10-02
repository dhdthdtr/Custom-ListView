package com.example.listview_custom_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomListView extends BaseAdapter {
    private ArrayList<Country> listCountry;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListView(Context context, ArrayList<Country> listCountry) {
        this.listCountry = listCountry;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return listCountry.size();
    }

    @Override
    public Object getItem(int position) {
        return listCountry.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            // tạo ra 1 lớp trung gian giữa layout với dữ liệu
            view = layoutInflater.inflate(R.layout.activity_custom_list_view, null);
            holder = new ViewHolder();
            holder.flagView = (ImageView) view.findViewById(R.id.image_flag);
            holder.nameView = (TextView) view.findViewById(R.id.textview_name);
            holder.populationView = (TextView) view.findViewById(R.id.textView_population);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Country country = this.listCountry.get(position);
        holder.nameView.setText(country.getName());
        holder.populationView.setText("Population: " + country.getPopulation());
        int imageID = this.getMipmapResID(country.getFlag());
        holder.flagView.setImageResource(imageID);
        return view;
    }

    public int getMipmapResID(String resName){
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName, "mipmap", pkgName);
        return resID;
    }

    static class ViewHolder{
        ImageView flagView;
        TextView nameView;
        TextView populationView;
    }
}