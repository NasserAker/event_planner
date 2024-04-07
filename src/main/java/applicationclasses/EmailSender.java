package applicationclasses;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import static applicationclasses.ServiceProvider.logger;


public class EmailSender {


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
