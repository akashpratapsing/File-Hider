package org.example.services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Transport;


public class SendOTPService {

    public static void sendOTP(String email, String genOTP){

        String to = email;

        String from = "aakashprataps832@gmail.com";

        String host = "smtp.gmail.com";

        String pass = "xfii kzbb nccc hymj";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");


        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, pass);
            }
        });

        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(from)));

            message.setSubject("File enc ka OTP");

            message.setText("Your one time OTP for file encryption is : " + genOTP);

            System.out.println("sending...");

            Transport.send(message);

            System.out.println("Message sent successfully....");

        }catch (MessagingException e){
            e.printStackTrace();
        }



    }
}
