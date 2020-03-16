package com.example.udacity_miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ListView listView=  findViewById(R.id.list_item_View);


        //an ArrayList of words
        ArrayList<Word> listOfNumbers=new ArrayList<Word>();

        listOfNumbers.add(new Word(R.drawable.color_red,"red","wetetti"));
        listOfNumbers.add(new Word(R.drawable.color_mustard_yellow,"mustard yellow","chiwiite"));
        listOfNumbers.add(new Word(R.drawable.color_dusty_yellow,"dusty yellow","topiisa"));
        listOfNumbers.add(new Word(R.drawable.color_green,"green","chokokki"));
        listOfNumbers.add(new Word(R.drawable.color_brown,"brown","takaakki"));
        listOfNumbers.add(new Word(R.drawable.color_gray,"gray","topoppi"));
        listOfNumbers.add(new Word(R.drawable.color_black,"black","kululli"));
        listOfNumbers.add(new Word(R.drawable.color_black,"white","kelelli"));




        WordAdapter adapter=
                new WordAdapter(this,listOfNumbers);
        listView.setAdapter(adapter);

    }
}
