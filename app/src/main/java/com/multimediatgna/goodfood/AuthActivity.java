// https://www.innofied.com/portfolio-item/goodfood-on-demand-food-delivery-app/


package com.multimediatgna.goodfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AuthActivity extends AppCompatActivity implements View.OnClickListener{


    Button myloginbutton;
    EditText myname;
    EditText mypassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setTheme(R.style.Theme_GoodFood);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        myloginbutton = (Button) findViewById(R.id.myloginbutton);
        myloginbutton.setOnClickListener(this);
        myname = findViewById(R.id.myname);
        mypassword = findViewById(R.id.mypassword);

    }

    @Override
    public void onClick(View view) {
        Intent myIntent = new Intent(this, Login.class);
        myIntent.putExtra("myname", myname.getText().toString()); //Optional parameters
        myIntent.putExtra("mypassword", mypassword.getText().toString()); //Optional parameters
        startActivity(myIntent);
    }
}