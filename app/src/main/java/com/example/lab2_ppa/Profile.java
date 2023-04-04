package com.example.lab2_ppa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lab2_ppa.user.User;

public class Profile extends AppCompatActivity {

    private TextView mail;
    private TextView password;
    private Button button;

    private User user;
    private void getParameters(){

        Bundle extras=getIntent().getExtras();
        try{
            user.setMail(extras.getString("email"));

            user.setPassword(extras.getString("password"));
        }catch (NullPointerException e){
            Log.e("Profile", "getParameters: ",e );

        }


    }
    @Override


    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mail=findViewById(R.id.email_TextView);
        password=findViewById(R.id.PasswordLength_TextView);
        button=findViewById(R.id.button);

        user=new User();

        getParameters();

        mail.setText(user.getMail());
        password.setText(user.getPassword().length());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}