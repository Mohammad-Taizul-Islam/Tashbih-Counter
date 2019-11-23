package com.example.dday.tasbihcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //vars

    private static final String TAG=MainActivity.class.getSimpleName();
    private TextView countView;
    private String texts;
    private int number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countView=findViewById(R.id.textView);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        texts=countView.getText().toString();
        outState.putCharSequence("saveState",texts);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        texts= String.valueOf(savedInstanceState.getCharSequence("saveState"));
        countView.setText(texts);
    }

    public void countMe(View view) {
        texts=countView.getText().toString();
        number=Integer.parseInt(texts);
        number++;
        countView.setText(String.valueOf(number));
    }
}
