package com.smsapi.rehan.todolist;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by MUSHAHID KHAN on 4/19/2015.
 */
public class CustomAdapter extends BaseAdapter implements View.OnClickListener {
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater = null;
    public Resources resources;
    ListModal model;


    public CustomAdapter(Activity a,ArrayList d,Resources r){
        activity = a;
        data = d;
        resources = r;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        if(data.size()<=0){
            return  1;
        }
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public static class ViewHolder{
        public TextView text;
        public Button btn;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder viewholder;
        if(convertView == null){
            vi = inflater.inflate(R.layout.tabitem,null);
            viewholder = new ViewHolder();
            viewholder.text = (TextView)vi.findViewById(R.id.text);
            viewholder.btn = (Button)vi.findViewById(R.id.btn);
            vi.setTag(viewholder);
            viewholder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("POSITION", String.valueOf(position));
                }
            });
        }
        else
            viewholder= (ViewHolder)vi.getTag();
        if(data.size()<=0){
            viewholder.text.setText("No data Found");
        }
        else{
            model = (ListModal)data.get(position);
            viewholder.text.setText(model.getTitle());
            //viewholder.text.setText(model.getSecondTitle());
            viewholder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("position",String.valueOf(position));
                }
            });
        }
        return  vi;
    }

    @Override
    public void onClick(View v) {

    }
}
