package com.example.a11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public boolean Started = false;
    public boolean Finished = false;
    Button button, button2, button3;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            setContentView(R.layout.activity_main);

            button2 = findViewById(R.id.button2);
            button2.setOnClickListener(this);

            button = findViewById(R.id.button);
            button.setOnClickListener(this);

            button3 = findViewById(R.id.button3);
            button3.setOnClickListener(this);

            textView = findViewById(R.id.textView);

        
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button2:
                if (!Finished) {
                    if (!Started) {
                        button2.setBackgroundColor(Color.RED); //red
                        button2.setText("Пауза");
                        Started = true;
                    } else {
                        button2.setBackgroundColor(Color.GREEN); //green
                        button2.setText("Старт");
                        Started = false;
                    }
                } else {
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.button:
                View Car = findViewById(R.id.button);
                if (Started && !Finished) {
                    ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams) Car.getLayoutParams();
                    margin.leftMargin += 40;
                    margin.rightMargin += 40;
                    Car.requestLayout();
                    if (margin.leftMargin >= 100) {
                        textView.setText("Победа 1 игрока");
                        button2.setText("Заново");
                        textView.setTextColor(0xffe91E63);
                        Finished = true;
                        Started = false;
                    }
                }
                break;
            case R.id.button3:
                View Car2 = findViewById(R.id.button3);
                if (Started && !Finished) {
                    ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams) Car2.getLayoutParams();
                    margin.leftMargin += 40;
                    margin.rightMargin += 40;

                    Car2.requestLayout();
                    if (margin.leftMargin >= 100) {
                        textView.setText("Победа 2 игрока");
                        button2.setText("Заново");
                        textView.setTextColor(0xfff00000);
                        Finished = true;
                        Started = false;
                    }
                }
                break;
        }
        }
}