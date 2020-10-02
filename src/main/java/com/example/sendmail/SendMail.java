package com.example.sendmail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class SendMail {
    // The email address.
    private String to = "";
    // Sender's email.
    private String from = "";
    // Sender's password.
    private String password = "";
    // Assuming you are sending email from through gmails smtp
    private String host = "";
    //A brief summary of the topic of the message.
    private String subject = "";
    //File path of attachment
    private String urlAttach = "";
    // Body
    private String msg = "";
    // The body is in html format?
    private boolean isHTML = false;
    //Status delivery.
    private boolean isSendOK = false;

    public SendMail(String to, String from, String password, String host, String subject, String urlAttach, String msg, boolean isHTML) {
        this.to = to;
        this.from = from;
        this.password = password;
        this.host = host;
        this.subject = subject;
        this.urlAttach = urlAttach;
        this.msg = msg;
        this.isHTML = isHTML;

    }

    public boolean sendMail() {


        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, password);

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From
            message.setFrom(new InternetAddress(from));

            // Set To
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject
            message.setSubject(subject);

            Multipart multipart = new MimeMultipart();
            // Set Msg/Body
            MimeBodyPart msgPart = new MimeBodyPart();
            if(isHTML){
                msgPart.setContent(msg, "text/html; charset=utf-8");
            }
            else{
                msgPart.setText(msg, "utf-8");
            }
            multipart.addBodyPart(msgPart);

            //If it exists, file is attached
            if (urlAttach.length() > 0) {
                MimeBodyPart attachmentPart = new MimeBodyPart();
                try {
                    File attach = new File(urlAttach);
                    attachmentPart.attachFile(attach);
                    multipart.addBodyPart(attachmentPart);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //The different contents (body and attach) are added to the message
            message.setContent(multipart);

            System.out.println("Sending email");

            // Send message
            Transport.send(message);

            System.out.println("Sent successfully!");
            isSendOK = true;

        } catch (MessagingException ex) {
            ex.printStackTrace();
        } finally {
            //
            return isSendOK;
        }

    }
}
