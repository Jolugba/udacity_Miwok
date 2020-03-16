package com.example.udacity_miwok;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

//
public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, ArrayList<Word> languageTranslanlation) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, languageTranslanlation);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWordTranslation = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID defaultTranslation
        TextView defaultTextView =  listItemView.findViewById(R.id.engLang);
        // Get the defaultTranslation from the current WORD object and
        // set this text on the name TextView
        defaultTextView.setText(currentWordTranslation.getMdefaultTranslation());

        // Find the TextView in the list_item.xml layout with the ID miwokTranslation
        TextView miwokTextView =  listItemView.findViewById(R.id.miwokLang);
        // Get the miwokTranslation from the current WORD object and

        // set this text on the number TextView
        miwokTextView.setText(currentWordTranslation.getmMiworkTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.imageResource);

        // Get the image resource ID from the current Word object and
        // set the image to iconView
       iconView.setImageResource(currentWordTranslation.getmImageResources());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
