package com.example.udacity_miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ListView listView=  findViewById(R.id.list_item_View);


        //an ArrayList of words
        ArrayList<Word> listOfNumbers=new ArrayList<Word>();

        listOfNumbers.add(new Word("Where are you going?","minto wuksui"));
        listOfNumbers.add(new Word("What is your name?","tinna oyaase'na"));
        listOfNumbers.add(new Word("My name is...","oyaaset..."));
        listOfNumbers.add(new Word("How are you feeling?","michaksas"));
        listOfNumbers.add(new Word("I'm feeling good","kuchi achit"));
        listOfNumbers.add(new Word("Are you coming?","aanas'aa"));
        listOfNumbers.add(new Word("Yes I'm coming","bam aanam"));





        WordAdapter adapter=
                new WordAdapter(this,listOfNumbers);
        listView.setAdapter(adapter);
    }
}
