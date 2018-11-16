package com.example.rahul.donationtrackerapp.Controllers;

import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rahul.donationtrackerapp.Model.Item;
import com.example.rahul.donationtrackerapp.Model.Model;
import com.example.rahul.donationtrackerapp.Model.donationType;

//import java.util.Objects;

//import java.util.Locale;

/**
 * Fragment used by DonationItemDetail to help display the donation item details
 */
public class DonationItemDetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private Item donation;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if ((args != null) && args.containsKey(ARG_ITEM_ID)) {
            int item_id = args.getInt(ARG_ITEM_ID);
            donation = Model.INSTANCE.findDonationByKey(item_id);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.donationitem_detail, container, false);
        if (donation != null) {
            ((TextView) rootView.findViewById(R.id.name)).setText(donation.getShortDescription());
            ((TextView) rootView.findViewById(R.id.value))
                    .setText(String.valueOf("$" + donation.getValue()));
            donationType category = donation.getCategory();
            String categoryString = category + "";
            ((TextView) rootView.findViewById(R.id.category)).setText(categoryString);
            ((TextView) rootView.findViewById(R.id.location)).setText(donation.getLocation());
            ((TextView) rootView.findViewById(R.id.description))
                    .setText(donation.getFullDescription());
            ((TextView) rootView.findViewById(R.id.timestamp)).setText(donation.getTimeStamp());
        }
        return rootView;
    }
}
