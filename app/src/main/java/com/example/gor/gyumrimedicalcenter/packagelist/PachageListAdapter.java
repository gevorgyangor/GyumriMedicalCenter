package com.example.gor.gyumrimedicalcenter.packagelist;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.gor.gyumrimedicalcenter.R;

import java.util.List;
import com.example.gor.gyumrimedicalcenter.packagelist.RowPachageItem;

public class PachageListAdapter extends BaseAdapter {
    Context context;
    List<RowPachageItem> rowItem;

    PachageListAdapter(Context context, List<RowPachageItem> rowItem) {
        this.context = context;
        this.rowItem = rowItem;

    }

    @Override
    public int getCount() {

        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {

        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {

        return rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.pachage_list, null);
        }

       ImageView imgIcon = (ImageView) convertView.findViewById(R.id.pchg_icon);
       TextView txtTitle = (TextView) convertView.findViewById(R.id.pchg_title);



        RowPachageItem row_pos = rowItem.get(position);
        imgIcon.setImageResource(row_pos.getIcon());
        txtTitle.setText(row_pos.getTitle());

        return convertView;

    }

}
