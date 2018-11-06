package com.example.gor.gyumrimedicalcenter.packagelist;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.gor.gyumrimedicalcenter.R;
import com.example.gor.gyumrimedicalcenter.dentiststype.TypesOfDantists;
import com.example.gor.gyumrimedicalcenter.packagelist.RowPachageItem;
import com.example.gor.gyumrimedicalcenter.packagelist.PachageListAdapter;

import java.util.ArrayList;
import java.util.List;


public class PachageListFragment extends ListFragment implements AdapterView.OnItemClickListener {

    String[] menutitles;
    TypedArray menuIcons;

    PachageListAdapter adapter;
    private List<RowPachageItem> rowItems;


    public PachageListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_forum, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        menutitles = getResources().getStringArray(R.array.pachage_name);
        menuIcons = getResources().obtainTypedArray(R.array.pchg_profile_logs);


        rowItems = new ArrayList<>();

        for (int i = 0; i < menutitles.length; i++) {
            RowPachageItem items = new RowPachageItem(menutitles[i], menuIcons.getResourceId(i, -1));
            rowItems.add(items);
        }

        adapter = new PachageListAdapter(getActivity(), rowItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getContext(), TypesOfDantists.class);
        RowPachageItem rowItem = rowItems.get(position);
        String str = rowItem.getTitle();
        intent.putExtra("stomName",str);
        startActivity(intent);
    }

}




