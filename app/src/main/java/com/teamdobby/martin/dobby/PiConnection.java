package com.teamdobby.martin.dobby;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PiConnection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pi_connection);

        final Button ersterButton;
        final Button zweiterButton;
        ersterButton = (Button)findViewById(R.id.button2);
        zweiterButton = (Button)findViewById(R.id.button3);


        ersterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v == ersterButton) {
                    //ACTION 1
                }
            }
        });
        zweiterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v == zweiterButton) {
                    //ACTION 2
                }
            }
        });

    }
}
