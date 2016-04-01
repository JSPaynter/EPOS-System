package Classes;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public final class Email {

    private String username = "IntergratedProjectJSP";  // GMail user name (just the part before "@gmail.com")
    private String password = "Project304"; // GMail password
    private String[] to;
    private String subject, body;

    public Email(String[] to, String subject, String body) throws MessagingException {
        this.to = to;
        this.subject = subject;
        this.body = body;
        sendFromGMail();
    }
    
    public void sendFromGMail() throws MessagingException {
        Properties props = System.getProperties();
        
        //settings for tls, doesn't worth on uni campus, port 587 blocked
//        String host = "smtp.gmail.com";
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.user", username);
//        props.put("mail.smtp.password", password);
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth", "true");

        //setting for ssl, use for uni campus
        String host = "smtp.gmail.com";
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port", "465");
	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(username));
        InternetAddress[] toAddress = new InternetAddress[to.length];

        // To get the array of addresses
        for( int i = 0; i < to.length; i++ ) {
            toAddress[i] = new InternetAddress(to[i]);
        }

        for (InternetAddress x : toAddress) {
            message.addRecipient(Message.RecipientType.TO, x);
        }

        message.setSubject(subject);
        message.setText(body);
        Transport transport = session.getTransport("smtp");
        transport.connect(host, username, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();        
    }
}