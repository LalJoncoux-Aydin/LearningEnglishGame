package com.example.learnenglishgame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AnswerAdapter extends ArrayAdapter<String> {

    public AnswerAdapter(Context context, ArrayList<String> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        String answer = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.answer_item, parent, false);
        }
        // Lookup view for data population
        TextView button_name = convertView.findViewById(R.id.button_id);

        // Populate the data into the template view using the data object
        button_name.setText(answer);

        // Return the completed view to render on screen
        return convertView;
    }
}
