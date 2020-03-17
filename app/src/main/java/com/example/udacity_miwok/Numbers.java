package com.example.udacity_miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ListView listView=  findViewById(R.id.list_item_View);

        //an ArrayList of words
        ArrayList<Word>  listOfNumbers=new ArrayList<Word>();

        listOfNumbers.add(new Word(R.drawable.number_one,"one","lutti"));
        listOfNumbers.add(new Word(R.drawable.number_two,"two","otiiko"));
        listOfNumbers.add(new Word(R.drawable.number_three,"three","tolookosu"));
        listOfNumbers.add(new Word(R.drawable.number_four,"four","oyyisa"));
        listOfNumbers.add(new Word(R.drawable.number_five,"five","massoka"));
        listOfNumbers.add(new Word(R.drawable.number_six,"six","temmokka"));
        listOfNumbers.add(new Word(R.drawable.number_seven,"seven","kenekaku"));
        listOfNumbers.add(new Word(R.drawable.number_eight,"eight","kawinta"));
        listOfNumbers.add(new Word(R.drawable.number_nine,"nine","wo'e"));
        listOfNumbers.add(new Word(R.drawable.number_ten,"ten","na'aacha"));


        WordAdapter adapter=
                new WordAdapter(this,listOfNumbers,R.color.category_numbers);
        listView.setAdapter(adapter);

    }
}
