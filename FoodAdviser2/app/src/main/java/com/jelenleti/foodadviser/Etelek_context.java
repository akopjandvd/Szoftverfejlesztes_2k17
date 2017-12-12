package com.jelenleti.foodadviser;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jenni on 2017. 12. 10..
 */

public class Etelek_context extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.etelek, container, false);
        ListView list = (ListView)rootView.findViewById(R.id.listview1);

        List myList = new ArrayList();

        for (int i=0;i<15;i++)
        {
            myList.add(i);
        }

        populateListView(list);
        registerClickCallback(list);

        return rootView;
    }

    private void registerClickCallback(ListView listViewToPopulate) {
        listViewToPopulate.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textview = (TextView) viewClicked;
                String message = "You clicked " + position + " , which is string: " + textview.getText().toString();

                Toast.makeText(Etelek_context.this.getActivity(), message, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void populateListView(ListView listViewToPopulate) {
        String[] myItems = {"egy", "ketto", "harom", "negy", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), R.layout.da_item,myItems);

        listViewToPopulate.setAdapter(adapter);

    }


}
