package com.example.rahul.donationtrackerapp.Controllers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rahul.donationtrackerapp.Model.Model;
import com.example.rahul.donationtrackerapp.Model.Location;
import com.example.rahul.donationtrackerapp.Model.locationType;

/**
 * Fragment used by LocationItemDetail.java to display location
 * details. Populates layout with location specific information
 * based on the location key that is passed in.
 */
public class LocationItemDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private Location location;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if ((bundle != null) && bundle.containsKey(ARG_ITEM_ID)) {
            int item_id = bundle.getInt(ARG_ITEM_ID);
            location = Model.INSTANCE.findLocationByKey(item_id);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.locationitem_detail, container, false);
        if (location != null) {
            ((TextView) rootView.findViewById(R.id.name)).setText(location.getName());
            locationType type = location.getType();
            String stringType = type + "";

            ((TextView) rootView.findViewById(R.id.type)).setText(stringType);
            ((TextView) rootView.findViewById(R.id.longitude)).
                    setText(String.valueOf(location.getLongitude()));
            ((TextView) rootView.findViewById(R.id.latitude)).
                    setText(String.valueOf(location.getLatitude()));
            ((TextView) rootView.findViewById(R.id.address)).setText(location.getAddress());
            ((TextView) rootView.findViewById(R.id.phone)).setText(location.getPhone());
        }
        return rootView;
    }
}

























