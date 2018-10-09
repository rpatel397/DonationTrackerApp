package com.example.rahul.donationtrackerapp.Controllers;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LocationItemDetailFragment extends Fragment {

    /**
     * A fragment representing a single DataItem detail screen.
     * This fragment is either contained in a {@link DataItemListActivity}
     * in two-pane mode (on tablets) or a {@link DataItemDetailActivity}
     * on handsets.
     */
            /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        public static final String ARG_ITEM_ID = "item_id";

        /**
         * The dummy content this fragment is presenting.
         */
        private LocationItem mItem;

        /**
         * Mandatory empty constructor for the fragment manager to instantiate the
         * fragment (e.g. upon screen orientation changes).
         */
        public LocationItemDetailFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            if (getArguments().containsKey(ARG_ITEM_ID)) {
                int item_id = getArguments().getInt(ARG_ITEM_ID);
                mItem = SimpleModel.INSTANCE.findItemById(item_id);

                Activity activity = this.getActivity();
                CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
                if (appBarLayout != null) {
                    appBarLayout.setTitle(mItem.getName());
                }
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.locationitem_detail, container, false);
            if (mItem != null) {
                ((TextView) rootView.findViewById(R.id.name)).setText(mItem.getName());
                ((TextView) rootView.findViewById(R.id.type)).setText(mItem.getType());
                ((TextView) rootView.findViewById(R.id.longitude)).setText(String.valueOf(mItem.getLongitude()));
                ((TextView) rootView.findViewById(R.id.latitude)).setText(String.valueOf(mItem.getLatitude()));
                ((TextView) rootView.findViewById(R.id.address)).setText(mItem.getAddress());
                ((TextView) rootView.findViewById(R.id.phone)).setText(mItem.getPhone());
            }

            return rootView;
        }
    }

























