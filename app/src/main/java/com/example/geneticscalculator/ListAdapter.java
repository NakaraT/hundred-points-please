package com.example.geneticscalculator;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter<ListItem> {

    private LayoutInflater inflater;
    private int layout;
    private List<ListItem> items;

    public ListAdapter(@NonNull Context context, int resource, @NonNull List<ListItem> objects) {
        super(context, resource, objects);
        this.items = objects;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        TextView textView = view.findViewById(R.id.relativeTitle);
        ImageView imageView = view.findViewById(R.id.relativeLogo);
        ListItem item = items.get(position);
        textView.setText(item.getRelativeTitle());
        imageView.setImageResource(item.getResource());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Relative " + (position + 1), Toast.LENGTH_SHORT).show();
                Log.d("listView", "Relative" + (position + 1));
            }
        });
        return view;
    }
}
