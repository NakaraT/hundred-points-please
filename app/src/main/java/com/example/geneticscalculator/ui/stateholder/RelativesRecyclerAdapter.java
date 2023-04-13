package com.example.geneticscalculator.ui.stateholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.geneticscalculator.R;
import com.example.geneticscalculator.data.models.RelativesListItem;

import java.util.List;

public class RelativesRecyclerAdapter extends RecyclerView.Adapter<RelativesRecyclerAdapter.RelativesViewHolder> {
    public OnRelativesListClickListener onRelativesListItemListener = null;
    private List<RelativesListItem> items;

    public RelativesRecyclerAdapter(List<RelativesListItem> items){
        this.items = items;

    }
    @NonNull
    @Override
    public RelativesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycle, parent, false);

        return new RelativesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RelativesViewHolder holder, int position) {
        RelativesListItem item = items.get(position);
        holder.textView.setText(RelativesListItem.getRelativesType());
        holder.textView2.setText(RelativesListItem.getEyeColor());
        holder.textView3.setText(RelativesListItem.getHairColor());
        holder.textView4.setText(RelativesListItem.getSkinColor());
        holder.textView5.setText(RelativesListItem.getBloodType());
        holder.imageView.setImageResource(R.drawable.relative);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRelativesListItemListener.onRelativesItemListClickListener(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class RelativesViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView information1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        ImageView imageView;
        public RelativesViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textView = itemView.findViewById(R.id.relativesType);
            textView2 = itemView.findViewById(R.id.eyeColor);
            textView3 = itemView.findViewById(R.id.hairColor);
            textView4 = itemView.findViewById(R.id.skinColor);
            textView5 = itemView.findViewById(R.id.bloodType);
            imageView = itemView.findViewById(R.id.relativeLogo);
        }

    }
    public interface OnRelativesListClickListener {
        void onRelativesItemListClickListener(int position);
    }
}
