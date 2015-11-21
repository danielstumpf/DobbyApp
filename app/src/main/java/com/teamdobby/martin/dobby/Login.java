package com.teamdobby.martin.dobby;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logindata.main();

        final Button confirm;
        confirm = (Button)findViewById(R.id.loginConfirm);

        final EditText NameText = (EditText) findViewById(R.id.inputName);
        final EditText PassText = (EditText) findViewById(R.id.inputPassword);


        confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence text = "YOLO";
                if(v==confirm){
                    String tmpname=NameText.getText().toString();
                    String tmppass=PassText.getText().toString();
                    if(logindata.isValidName(tmpname)){
                        if(logindata.isValidPass(tmpname,tmppass)){
                            text="Successfully logged in";
                            Intent myIntent = new Intent(Login.this, ConnectDrawer.class);
                            Login.this.startActivity(myIntent);
                            logindata.setCurrUser(tmpname);
                            logindata.setLogged();
                        }
                        else {
                            text="Wrong Password";
                        }
                    }
                    else {
                        text = "User not found";
                    }

                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
}
