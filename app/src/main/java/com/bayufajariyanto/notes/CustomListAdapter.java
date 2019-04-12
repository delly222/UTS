package com.bayufajariyanto.notes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Modal> items;

    public CustomListAdapter(Activity activity, List<Modal> items){
        this.activity = activity;
        this.items=items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(convertView==null){
                convertView=inflater.inflate(R.layout.custom_list,null);

                TextView text = (TextView) convertView.findViewById(R.id.text);

                Modal m = items.get(position);

                text.setText(m.getText());
            }

        return convertView;
    }
}
