package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rahul.donationtrackerapp.Model.Item;
import com.example.rahul.donationtrackerapp.Model.Model;


import java.util.List;

public class DonationList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_list);
        View recyclerView = findViewById(R.id.donationitem_list);
        assert recyclerView != null;

        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(Model.INSTANCE.getDonations()));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<Item> mValues;

        public SimpleItemRecyclerViewAdapter(List<Item> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.donationitem_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final DonationList.SimpleItemRecyclerViewAdapter.ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mContentView.setText(mValues.get(position).getShortDescription());
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DonationItemDetail.class);
                    intent.putExtra(DonationItemDetailFragment.ARG_ITEM_ID, holder.mItem.getKey());
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mContentView;
            public Item mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mContentView = view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }


    public void addItemOnPressed(View view) {
        Intent intent = new Intent(this, UpdateInventory.class);
        setContentView(R.layout.activity_update_inventory);
        startActivity(intent);
    }
}
