package applicationclasses;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.logging.Level;
import static applicationclasses.ServiceProvider.logger;


public class EmailSender {
//    public static boolean sendEmail(String recipientEmail, String subject, String body) {
//        // Sender's email address and password
//        String senderEmail = "";
//        String password = "";
//
//        // Set the properties for Gmail SMTP server
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "587");
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//
//        // Create a Session object
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(senderEmail, password);
//            }
//        });
//
//        try {
//            // Create a MimeMessage object
//            Message message = new MimeMessage(session);
//            // Set sender email address
//            message.setFrom(new InternetAddress(senderEmail));
//            // Set recipient email address
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
//            // Set email subject
//            message.setSubject(subject);
//            // Set email body
//            message.setText(body);
//
//            // Send the email
//            Transport.send(message);
//            logger.log(Level.INFO, "Email sent successfully.");
//            return true;
//        } catch (MessagingException e) {
//            logger.log(Level.SEVERE, "Failed to send email.", e);
//            return false;
//        }}
//
//    public static void main(String[] args) {
//        // Example usage
//        String recipientEmail = "s12028604@stu.najah.edu";
//        String subject = "Test Email";
//        String body = "This is a test email.";
//        sendEmail(recipientEmail, subject, body);
//fnul mvky vmmj ljqr
    //}

    public void email(String recipient,String s) {


        try {
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("s12112519@stu.najah.edu\n", "fnul mvky vmmj ljqr");
                }
            });

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("s12112519@stu.najah.edu\n"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient, false));

            message.setSubject("event planner project");
            message.setText(s);
            Transport.send(message);
        } catch (MessagingException m) {
            logger.info("MessagingException");
        }
    }
}
