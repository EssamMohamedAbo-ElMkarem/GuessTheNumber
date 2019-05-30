package com.examples.helloandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Date;
import java.text.SimpleDateFormat;

public class SecondaryActivity extends AppCompatActivity {

    TextView score = null;
    TextView time = null;
    TextView response = null;
    Button guess = null;
    Button back = null;
    EditText input = null;
    byte counter = 0;
    public int scoreValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_layout);
        String timeText;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        timeText = formatter.format(date);
        time = (TextView) findViewById(R.id.time);
        time.setText(timeText + " You have only 5 Wrong Tries");
        score = (TextView) findViewById(R.id.score);
        score.setText("YourScore: " + 0);
        guess = (Button) findViewById(R.id.button);
        back = (Button) findViewById(R.id.back);
        response = (TextView) findViewById(R.id.response);
        guess.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(counter < 4) {
                    input = (EditText) findViewById(R.id.input);
                    double double_possibility = Math.random() * 10;
                    int possibility = (int) double_possibility;
                    int i = new Integer(input.getText().toString());
                    if (i <= 10) {
                        if (i == possibility) {
                            scoreValue = scoreValue + 10;
                            response.setText("Congratulations :)");
                            response.setTextColor(R.color.Green);
                        } else {
                            scoreValue = scoreValue - 1;
                            counter += 1;
                            response.setText("Try again!");
                            response.setTextColor(R.color.Red);
                        }
                        score.setText("YourScore: " + scoreValue);
                    } else {
                        response.setText("Enter a a valid value x_x");
                        response.setTextColor(R.color.Red);
                    }
                }else{
                    response.setText("Your Score is " + (scoreValue - 1));
                    score.setText("YourScore: " + (scoreValue - 1));
                    response.setTextColor(R.color.black);
                    guess.setEnabled(false);
                    input.setEnabled(false);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}
