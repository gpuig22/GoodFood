// https://www.innofied.com/portfolio-item/goodfood-on-demand-food-delivery-app/
// https://firebase.google.com/docs/auth/android/start?hl=es-419#java_4



package com.multimediatgna.goodfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        startActivity(new Intent(AuthActivity.this,SecondActivity.class));
        finish();

    }




}