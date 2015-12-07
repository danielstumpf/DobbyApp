package com.teamdobby.martin.dobby;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.ByteArrayOutputStream;
import java.util.Properties;

/**
 * Created by Daniel on 06.12.2015.
 */
public class SSHConnection {

    public static String executeRemoteCommand(String username, String password, String hostname, int port) throws Exception{
        JSch jsch = new JSch();
        Session session = jsch.getSession("pi", "192.168.2.45", 22);
        session.setPassword("raspberry");


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
        channelssh.setCommand("sudo reboot");
        channelssh.connect();
        channelssh.disconnect();

        return baos.toString();
    }
}