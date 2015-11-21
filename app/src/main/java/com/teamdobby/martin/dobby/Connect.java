package com.teamdobby.martin.dobby;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Connect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        TextView userIDdisplay;
        userIDdisplay= (TextView) findViewById(R.id.textUserID);
        String curruser=logindata.getCurrUser();
        String foottext = "You are logged in as "+curruser+".";
        userIDdisplay.setText(foottext);

        Button logoutButton;
        logoutButton = (Button)findViewById(R.id.buttonLogout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                logindata.notLogged();
                logindata.setCurrUser("");
                CharSequence text = "Successfully logged out";
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                Intent myIntent = new Intent(Connect.this, MainActivity.class);
                Connect.this.startActivity(myIntent);
            }
        });
    }
    @Override
    public void onBackPressed() {
    }
}
