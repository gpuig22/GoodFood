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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthActivity extends AppCompatActivity implements View.OnClickListener{


    Button myloginbutton;
    EditText myname;
    EditText mypassword;
    private FirebaseAuth mAuth;
    Intent myIntent;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            startActivity(getIntent());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(500);
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

        switch (view.getId()){
            case R.id.myloginbutton:


                if (myname.getText().toString() != null && !myname.getText().toString().isEmpty() && mypassword.getText().toString() != null && !mypassword.getText().toString().isEmpty()) {
                    myIntent = new Intent(this, Login.class);
                    mAuth.signInWithEmailAndPassword(myname.getText().toString(), mypassword.getText().toString())
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        myIntent.putExtra("myname", myname.getText().toString()); //Optional parameters
                                        myIntent.putExtra("mypassword", mypassword.getText().toString()); //Optional parameters
                                        startActivity(myIntent);

                                    } else {
                                        Toast.makeText(AuthActivity.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }


                break;

            case R.id.mysignuptextview:
                mAuth = FirebaseAuth.getInstance();
                myIntent = new Intent(this, Login.class);
                if (myname.getText().toString() != null && !myname.getText().toString().isEmpty() && mypassword.getText().toString() != null && !mypassword.getText().toString().isEmpty()) {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(myname.getText().toString(),mypassword.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                myIntent.putExtra("myname", myname.getText().toString()); //Optional parameters
                                myIntent.putExtra("mypassword", mypassword.getText().toString()); //Optional parameters
                                startActivity(myIntent);
                            } else {
                                Toast.makeText(AuthActivity.this, "Authentication failed.",Toast.LENGTH_SHORT).show();

                            }
                        }

                    });
                }


                break;


        }
        Intent myIntent = new Intent(this, Login.class);
        myIntent.putExtra("myname", myname.getText().toString()); //Optional parameters
        myIntent.putExtra("mypassword", mypassword.getText().toString()); //Optional parameters
        startActivity(myIntent);
    }
}