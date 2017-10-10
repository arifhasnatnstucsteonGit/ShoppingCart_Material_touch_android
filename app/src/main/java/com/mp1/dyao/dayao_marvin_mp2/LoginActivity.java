package com.mp1.dyao.dayao_marvin_mp2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static TextView attempt;
    private static Button login_btn;
    int attempt_counter=5;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mContext = LoginActivity.this;

        LoginButton();
        username.setText("admin");
        password.setText("12345");



    }


    public void LoginButton(){
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        attempt = (TextView)findViewById(R.id.attempt);
        login_btn = (Button)findViewById(R.id.login_btn);

        attempt.setText(Integer.toString(attempt_counter));

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equalsIgnoreCase("admin")&& password.getText().toString().equals("12345")) {
                    Toast.makeText(mContext, "Username and password is correct",
                            Toast.LENGTH_SHORT).show();

                   /*
                   * to declare intent use this format .
                   * MainActivity.this -> current activity
                   * SecondActivity.class-> Second activity where we want to go . But mind it SecondActivity.class is an Activity not just java class .
                   *
                   * */


                    Intent intent = new Intent(mContext,MainActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(mContext, "Username and password is NOT correct",
                            Toast.LENGTH_SHORT).show();
                    attempt_counter--;
                    attempt.setText(Integer.toString(attempt_counter));
                    if (attempt_counter == 0)
                        login_btn.setEnabled(false);
                }
            }
        });

    }

}
