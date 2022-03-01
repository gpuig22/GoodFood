// https://www.innofied.com/portfolio-item/goodfood-on-demand-food-delivery-app/


package com.multimediatgna.goodfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button myloginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();

            myloginbutton = (Button) findViewById(R.id.myloginbutton);


        }
    }

    @Override
    public void onClick(View view) {


    }
}