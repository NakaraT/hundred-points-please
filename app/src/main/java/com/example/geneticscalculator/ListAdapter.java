package com.example.geneticscalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter<ListItem> {

    private final LayoutInflater inflater;
    private final int layout;
    private final List<ListItem> items;

    public ListAdapter(@NonNull Context context, int resource, @NonNull List<ListItem> objects) {
        super(context, resource, objects);
        this.items = objects;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        TextView textView = view.findViewById(R.id.relativeTitle);
        ImageView imageView = view.findViewById(R.id.relativeLogo);
        ListItem item = items.get(position);
        textView.setText(item.getRelativeTitle());
        imageView.setImageResource(item.getResource());
        return view;
    }
}
