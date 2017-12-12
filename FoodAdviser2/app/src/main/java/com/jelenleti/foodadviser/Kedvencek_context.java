package com.jelenleti.foodadviser;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Jenni on 2017. 12. 10..
 */

public class Kedvencek_context extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.kedvencek, container, false);
        ListView list = (ListView)rootView.findViewById(R.id.listview2);

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

                Toast.makeText(Kedvencek_context.this.getActivity(), message, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void populateListView(ListView listViewToPopulate) {
        String[] myItems = {"egy", "ketto", "harom", "negy"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), R.layout.da_item,myItems);

        listViewToPopulate.setAdapter(adapter);

    }

}
