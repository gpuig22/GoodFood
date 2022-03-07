package com.multimediatgna.goodfood;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    Button myloginbutton;
    EditText myname;
    EditText mypassword;
    private FirebaseAuth mAuth;
    Intent myIntent;
    TextView mysignuptextview;

    FirebaseUser currentUser;

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_auth);
        myloginbutton = (Button) findViewById(R.id.myloginbutton);
        myloginbutton.setOnClickListener(this);
        myname = findViewById(R.id.myname);
        mypassword = findViewById(R.id.mypassword);
        mysignuptextview = findViewById(R.id.mysignupbutton);
        mysignuptextview.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.myloginbutton:
                if (myname.getText().toString() != null && !myname.getText().toString().isEmpty() && mypassword.getText().toString() != null && !mypassword.getText().toString().isEmpty()) {
                    myIntent = new Intent(this, Login.class);
                    mAuth.signInWithEmailAndPassword(myname.getText().toString(), mypassword.getText().toString())
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        if (currentUser.isEmailVerified()) {
                                            myIntent.putExtra("myname", myname.getText().toString()); //Optional parameters
                                            myIntent.putExtra("mypassword", mypassword.getText().toString()); //Optional parameters
                                            startActivity(myIntent);
                                        } else {
                                            Toast.makeText(SecondActivity.this, getString(R.string.email_not_verified), Toast.LENGTH_LONG).show();
                                        }
                                    } else {
                                        Toast.makeText(SecondActivity.this, getString(R.string.account_not_found), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(SecondActivity.this, "Enter your user and password", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.mysignupbutton:
                Log.d("GoodFood", "onClick mysignuptextview executed");
                mAuth = FirebaseAuth.getInstance();
                myIntent = new Intent(this, Login.class);
                myname.getText().toString();
                if (!myname.getText().toString().isEmpty() && mypassword.getText().toString() != null && !mypassword.getText().toString().isEmpty()) {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(myname.getText().toString(), mypassword.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                currentUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(SecondActivity.this,getString(R.string.email_verification_sent),Toast.LENGTH_LONG).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(SecondActivity.this,getString(R.string.email_verification_failure),Toast.LENGTH_LONG).show();
                                    }
                                });

                            } else {
                                Toast.makeText(SecondActivity.this,getString(R.string.registration_failure),Toast.LENGTH_LONG).show();

                            }
                        }

                    });
                }
                break;





        }

    }
}

