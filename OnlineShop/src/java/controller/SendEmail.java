/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.Account;

/**
 *
 * @author MSI
 */
public class SendEmail {

    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    //send email to the user email
    public boolean sendResetPass(String toEmail, String pass) {

        boolean test = false;
        //create an instance of Properties Class   
        Properties prop = new Properties();

        /* Specifies the IP address of your default mail server
     	   for e.g if you are using gmail server as an email sever
           you will pass smtp.gmail.com as value of mail.smtp host. 
           As shown here in the code. 
           Change accordingly, if your email id is not a gmail id
         */
        prop.put("mail.smtp.host", "smtp.gmail.com");
        //below mentioned mail.smtp.port is optional
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        
//        prop.setProperty("mail.smtp.host", "smtp.mail.com");
//        prop.setProperty("mail.smtp.port", "587");
//        prop.setProperty("mail.smtp.auth", "true");
//        prop.setProperty("mail.smtp.starttls.enable", "true");
//        prop.put("mail.smtp.socketFactory.port", "587");
//        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        String fromEmail = "phundhe151425@fpt.edu.vn";
        String password = "0982060701";
        
        /* Pass Properties object(props) and Authenticator object   
           for authentication to Session instance 
         */
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {

            /* Create an instance of MimeMessage, 
 	      it accept MIME types and headers 
             */
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Request to reset password");
            message.setText("This message is in response to your request to reset your account password.\n"
                    + "Your password: " + pass);

            /* Transport class is used to deliver the message to the recipients */
            Transport.send(message);

            test = true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return test;
    }
}
