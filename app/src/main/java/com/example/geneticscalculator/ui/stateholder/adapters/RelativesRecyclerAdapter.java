package com.example.geneticscalculator.ui.stateholder.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.geneticscalculator.data.database.entity.RelativesEntity;
import com.example.geneticscalculator.databinding.ItemRecycleBinding;
import com.example.geneticscalculator.ui.stateholder.OnRelativesListClickListener;
import com.example.geneticscalculator.ui.stateholder.RelativesViewHolder;

import java.util.ArrayList;
import java.util.List;

public class RelativesRecyclerAdapter extends Adapter<RelativesViewHolder> {

    private final OnRelativesListClickListener onRelativesListItemListener;
    private List<RelativesEntity> items = new ArrayList<>();

    public RelativesRecyclerAdapter(OnRelativesListClickListener onRelativesListItemListener) {
        this.onRelativesListItemListener = onRelativesListItemListener;
    }

    @NonNull
    @Override
    public RelativesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemRecycleBinding binding = ItemRecycleBinding.inflate(inflater, parent, false);
        return new RelativesViewHolder(binding, onRelativesListItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RelativesViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<RelativesEntity> items) {
        int count = getItemCount();
        this.items = new ArrayList<>(items);
        notifyItemRangeChanged(0, Math.max(count, getItemCount()));
    }
}
