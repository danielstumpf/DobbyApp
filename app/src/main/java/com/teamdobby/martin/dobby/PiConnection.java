package com.teamdobby.martin.dobby;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.ByteArrayOutputStream;
import java.util.Properties;


public class PiConnection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pi_connection);

        final Button ersterButton;
        final Button zweiterButton;
        ersterButton = (Button) findViewById(R.id.button2);
        zweiterButton = (Button) findViewById(R.id.button3);
        String message23On = "sudo echo \"1\" > /sys/class/gpio/gpio23/value";
        String message23Off = "sudo echo \"1\" > /sys/class/gpio/gpio23/value";
        String message24On = "sudo echo \"1\" > /sys/class/gpio/gpio23/value";
        String message24Off = "sudo echo \"1\" > /sys/class/gpio/gpio23/value";

        ersterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v == ersterButton) {
                    //ACTION 1
                    new AsyncTask<Integer, Void, Void>(){
                        @Override
                        protected Void doInBackground(Integer... params) {
                            try {
                                String msg = "sudo echo \"1\" > /sys/class/gpio/gpio23/value";
                                executeRemoteCommand("pi", "raspberry", "192.168.2.45", msg);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                    }.execute(1);
                }
            }
        });


        zweiterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v == zweiterButton) {
                    //ACTION 2

                    new AsyncTask<Integer, Void, Void>(){
                        @Override
                        protected Void doInBackground(Integer... params) {
                            try {
                                String msg = "sudo echo \"0\" > /sys/class/gpio/gpio23/value";
                                executeRemoteCommand("pi", "raspberry", "192.168.2.45", msg);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                    }.execute(1);
                }
            }
        });
    }


    public static String executeRemoteCommand(String user, String password, String host, String msg) throws Exception {
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, 22);
        session.setPassword(password);


        // Avoid asking for key confirmation
        Properties prop = new Properties();
        prop.put("StrictHostKeyChecking", "no");
        session.setConfig(prop);

        session.connect();

        // SSH Channel
        ChannelExec channelssh = (ChannelExec)
                session.openChannel("exec");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        channelssh.setOutputStream(baos);

        // Execute command
        channelssh.setCommand(msg);
        channelssh.connect();
        channelssh.disconnect();

        return baos.toString();
    }
}