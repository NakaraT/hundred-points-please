package com.example.geneticscalculator.ui.stateholder;

import androidx.recyclerview.widget.RecyclerView;

import com.example.geneticscalculator.R;
import com.example.geneticscalculator.data.database.entity.RelativesEntity;

public class RelativesViewHolder extends RecyclerView.ViewHolder {

    private final com.example.geneticscalculator.databinding.ItemRecycleBinding binding;
    private final OnRelativesListClickListener onRelativesListItemListener;

    public RelativesViewHolder(
            com.example.geneticscalculator.databinding.ItemRecycleBinding binding,
            OnRelativesListClickListener onRelativesListItemListener
    ) {
        super(binding.getRoot());
        this.binding = binding;
        this.onRelativesListItemListener = onRelativesListItemListener;
    }

    public void bind(RelativesEntity item) {
        binding.getRoot().setOnClickListener(v -> onRelativesListItemListener.onClick(item.getId()));
        binding.relativeLogo.setImageResource(R.drawable.relative);
        binding.relativesType.setText(item.getRelativesType());
//        binding.eyeColor.setText(item.getEyeColor());
        binding.dateofBirth.setText(item.getDateofBirth());
//        binding.bloodType.setText(item.getBloodType());
//        binding.hairColor.setText(item.getHairColor());
    }
}
