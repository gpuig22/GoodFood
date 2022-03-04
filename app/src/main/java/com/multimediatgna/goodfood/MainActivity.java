// https://www.innofied.com/portfolio-item/goodfood-on-demand-food-delivery-app/


package com.multimediatgna.goodfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.multimediatgna.goodfood.ui.main.LoginFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


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
        setContentView(R.layout.activity_main);
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