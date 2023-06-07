package com.example.geneticscalculator.ui.stateholder.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.geneticscalculator.data.database.entity.DatesEntity;
import com.example.geneticscalculator.databinding.ItemDatesBinding;
import com.example.geneticscalculator.ui.stateholder.DatesViewHolder;
import com.example.geneticscalculator.ui.stateholder.OnDatesListClickListener;

import java.util.ArrayList;
import java.util.List;

public class DatesRecyclerAdapter extends Adapter<DatesViewHolder> {

    private final OnDatesListClickListener onDatesListItemListener;
    private List<DatesEntity> items = new ArrayList<>();

    public DatesRecyclerAdapter(OnDatesListClickListener onDatesListItemListener) {
        this.onDatesListItemListener = onDatesListItemListener;
    }

    @NonNull
    @Override
    public DatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemDatesBinding binding = ItemDatesBinding.inflate(inflater, parent, false);
        return new DatesViewHolder(binding, onDatesListItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DatesViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<DatesEntity> items) {
        int count = getItemCount();
        this.items = new ArrayList<>(items);
        notifyItemRangeChanged(0, Math.max(count, getItemCount()));
    }
}
