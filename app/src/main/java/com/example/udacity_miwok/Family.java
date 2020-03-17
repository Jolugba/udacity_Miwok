package com.example.udacity_miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Family extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);



        ListView listView=  findViewById(R.id.list_item_View);


        //an ArrayList of words
        ArrayList<Word> listOfNumbers=new ArrayList<Word>();

        listOfNumbers.add(new Word(R.drawable.family_father,"father","epa"));
        listOfNumbers.add(new Word(R.drawable.family_mother,"mother","eta"));
        listOfNumbers.add(new Word(R.drawable.family_son,"son","angsi"));
        listOfNumbers.add(new Word(R.drawable.family_daughter,"daughter","tune"));
        listOfNumbers.add(new Word(R.drawable.family_older_brother,"older brother","taachi"));
        listOfNumbers.add(new Word(R.drawable.family_younger_brother,"younger brother","chalitti"));
        listOfNumbers.add(new Word(R.drawable.family_older_sister,"older sister","tete"));
        listOfNumbers.add(new Word(R.drawable.family_younger_sister,"younger sister","kolliti"));
        listOfNumbers.add(new Word(R.drawable.family_grandmother,"grandmother","ama"));
        listOfNumbers.add(new Word(R.drawable.family_grandfather,"grandfather","paapa"));




        WordAdapter adapter=
                new WordAdapter(this,listOfNumbers,R.color.category_family);
        listView.setAdapter(adapter);

    }
}
