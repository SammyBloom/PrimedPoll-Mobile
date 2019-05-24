package com.primedsoft.primedpoll.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.primedsoft.primedpoll.Models.Data;
import com.primedsoft.primedpoll.Models.Interest;
import com.primedsoft.primedpoll.R;

import java.util.ArrayList;

public class AddInterestAdapter extends RecyclerView.Adapter<AddInterestAdapter.DataHolder> {
    private ArrayList<Interest> dataArrayList;

    public AddInterestAdapter(ArrayList<Interest> dataList) {
        this.dataArrayList = dataList;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.add_interest_item, viewGroup, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DataHolder dataHolder, int i) {
        final Interest model = dataArrayList.get(i);
        dataHolder.setTitle(model.getTitle());
    }

    @Override
    public int getItemCount() {
        return dataArrayList == null ? 0 : dataArrayList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {
        Button addInterestButton;

        public DataHolder(@NonNull View itemView) {
            super(itemView);
            addInterestButton = itemView.findViewById(R.id.add_new_interest_button);
        }

        public void setTitle(String interest) {
            addInterestButton.setText(interest);
        }

    }
}
