package com.merrick.tmalmstrom.rocketleagueboosttimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // class instance variables:
    private ImageView boost1;
    private ImageView boost2;
    private ImageView boost3;
    private ImageView boost4;
    private ImageView boost5;
    private ImageView boost6;

    private TextView timer1;
    private TextView timer2;
    private TextView timer3;
    private TextView timer4;
    private TextView timer5;
    private TextView timer6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting the layout for the activity:
        setContentView(R.layout.activity_main);

        // connecting all the components to the view:
        connectImage();
        // pressed the top left boost image:
        boost1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonTimer(timer1,boost1);
            }
        });
        boost2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonTimer(timer2,boost2);
            }
        });
        boost3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonTimer(timer3,boost3);
            }
        });
        boost4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonTimer(timer4,boost4);
            }
        });
        boost5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonTimer(timer5,boost5);     q
            }
        });
        boost6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonTimer(timer6,boost6);
            }
        });

    }

    // connecting the imageview's and textviews:
    public void connectImage(){
        // connecting the imageviews:
        boost1 = (ImageView) findViewById(R.id.boostTL);
        boost2 = (ImageView) findViewById(R.id.boostML);
        boost3 = (ImageView) findViewById(R.id.boostBL);
        boost4 = (ImageView) findViewById(R.id.boostTR);
        boost5 = (ImageView) findViewById(R.id.boostMR);
        boost6 = (ImageView) findViewById(R.id.boostBR);
        // connecting the textviews:
        timer1 = (TextView) findViewById(R.id.timerTL);
        timer2 = (TextView) findViewById(R.id.timerML);
        timer3 = (TextView) findViewById(R.id.timerBL);
        timer4 = (TextView) findViewById(R.id.timerTR);
        timer5 = (TextView) findViewById(R.id.timerMR);
        timer6 = (TextView) findViewById(R.id.timerBR);
    }

    // method that will encapsulate all the timing for the buttons:
    public void buttonTimer(final TextView cTimer, final ImageView cImage){
        new CountDownTimer(10000, 1000){
            public void onTick(long millisUntilFinished){
                cImage.setImageResource(R.drawable.boost_down);
                cTimer.setText("Time: " +  millisUntilFinished / 1000);
            }
            public void onFinish(){
                cImage.setImageResource(R.drawable.boost_up);
                cTimer.setText("");
                Toast.makeText(MainActivity.this, "BOOST IS BACK. GRAB THAT BOI!", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    // button to give the game caption!
    public void gameCaption(View v){
        Toast.makeText(MainActivity.this, "Timer for all the boosts on the arena (classical maps)", Toast.LENGTH_LONG).show();
    }

}