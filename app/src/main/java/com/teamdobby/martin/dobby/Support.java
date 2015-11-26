package com.teamdobby.martin.dobby;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Support extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        setTitle("Send a Support-Mail");
        final Button confirm;
        confirm = (Button)findViewById(R.id.ButtonSubmit);
        final EditText MsgText = (EditText) findViewById(R.id.inputMessage);
        final EditText MailText = (EditText) findViewById(R.id.inputEmail);
        confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence text = "YOLO";
                if (v == confirm) {
                    String tmptext = MsgText.getText().toString();
                    String tmpmail = MailText.getText().toString();
                    if (android.util.Patterns.EMAIL_ADDRESS.matcher(tmpmail).matches()) {
                        if (tmptext.length()>10) {
                            text = "Support-Mail successfully sent";
                            Intent myIntent = new Intent(Support.this, ConnectDrawer.class);
                            Support.this.startActivity(myIntent);

                            try {
                                GMailSender sender = new GMailSender("username@gmail.com", "password");
                                sender.sendMail("This is Subject",
                                        "This is Body",
                                        "user@gmail.com",
                                        "user@yahoo.com");
                            } catch (Exception e) {
                                Log.e("SendMail", e.getMessage(), e);
                            }

                        } else {
                            text = "Please enter a longer message";
                        }
                    } else {
                        text = "Please enter a valid E-Mail-Adress";
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
