package com.example.bewell.Email;



import android.os.StrictMode;
import android.util.Log;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail extends AppCompatActivity {

    public void send(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        final String username="bewellnoreply@gmail.com";
        final String password="D93X8wnTRsRrSPH";
        String text = "Hello user!";
        Properties props= new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.strattls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");
        Session session=Session.getInstance(props,
                new javax.mail.Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication(username,password);
                    }
                });
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("bakoss998@gmail.com"));
            message.setSubject("Test email");
            message.setText(text);
            Thread gfgThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try  {
                        Transport.send(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            gfgThread.start();
            //Toast.makeText(getApplicationContext(),"Ugyes vagy",Toast.LENGTH_LONG).show();

        }catch (MessagingException e){
            throw new RuntimeException(e);

        }

    }
}
