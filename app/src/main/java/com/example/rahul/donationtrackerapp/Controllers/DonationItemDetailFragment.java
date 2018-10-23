package com.example.rahul.donationtrackerapp.Controllers;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rahul.donationtrackerapp.Model.Item;
import com.example.rahul.donationtrackerapp.Model.Model;


public class DonationItemDetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private Item donation;

    public DonationItemDetailFragment() {  }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            int item_id = getArguments().getInt(ARG_ITEM_ID);
            donation = Model.INSTANCE.findDonationByKey(item_id);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.donationitem_detail, container, false);
        if (donation != null) {
            ((TextView) rootView.findViewById(R.id.name)).setText(donation.getShortDescription());
        }
        return rootView;
    }
}
