package com.example.rahul.donationtrackerapp.Controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import Model.SimpleModel;

public class LocationItemDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";

    private Location mItem;

    public LocationItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            int item_id = getArguments().getInt(ARG_ITEM_ID);
            mItem = SimpleModel.INSTANCE.findItemById(item_id);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.locationitem_detail, container, false);
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.name)).setText(mItem.getName());
            ((TextView) rootView.findViewById(R.id.type)).setText("Type: " + mItem.getType());
            ((TextView) rootView.findViewById(R.id.longitude)).setText("Longitude: " + String.valueOf(mItem.getLongitude()));
            ((TextView) rootView.findViewById(R.id.latitude)).setText("Latitude: " +String.valueOf(mItem.getLatitude()));
            ((TextView) rootView.findViewById(R.id.address)).setText("Address: " +mItem.getAddress());
            ((TextView) rootView.findViewById(R.id.phone)).setText("Phone Number: " +mItem.getPhone());
        }
        return rootView;
    }
}

























