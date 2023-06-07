package com.example.geneticscalculator.ui.stateholder;

import androidx.recyclerview.widget.RecyclerView;

import com.example.geneticscalculator.R;
import com.example.geneticscalculator.data.database.entity.DatesEntity;

public class DatesViewHolder extends RecyclerView.ViewHolder {

    private final com.example.geneticscalculator.databinding.ItemDatesBinding binding;
    private final OnDatesListClickListener onDatesListItemListener;

    public DatesViewHolder(
            com.example.geneticscalculator.databinding.ItemDatesBinding binding,
            OnDatesListClickListener onDatesListItemListener
    ) {
        super(binding.getRoot());
        this.binding = binding;
        this.onDatesListItemListener = onDatesListItemListener;
    }

    public void bind(DatesEntity item) {
        binding.getRoot().setOnClickListener(v -> onDatesListItemListener.onClick(item.getId()));
        binding.datesLogo.setImageResource(R.drawable.ic_baseline_access_time_24);
        binding.datesType.setText(item.getDatesType());
        binding.datesText.setText(item.getDatesText());
        binding.datesInfo.setText(item.getDatesInfo());
    }
}
