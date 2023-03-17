package com.example.geneticscalculator;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<RecycleItem> items;

    public RecycleAdapter(Context context, List<RecycleItem> items) {
        this.inflater = LayoutInflater.from(context);
        this.items = items;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecycleItem item = items.get(position);
        holder.textView.setText(item.getRelativeTitle());
        holder.imageView.setImageResource(item.getResource());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Relative " + (holder.getAdapterPosition() + 1), Toast.LENGTH_SHORT).show();
                Log.d("recyclerView", "Relative" + (holder.getAdapterPosition() + 1));
            }
        });
    }

    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        final ImageView imageView;
        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.relativeTitle);
            imageView = view.findViewById(R.id.relativeLogo);
        }
    }

}