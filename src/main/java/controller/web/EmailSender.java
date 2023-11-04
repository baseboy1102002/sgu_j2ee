package controller.web;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    public static void sendActivationCode(String recipientEmail, String recipientName, String activationCode) {
        // SMTP server configuration
        String smtpHost = "smtp.gmail.com";
        String smtpPort = "587";
        final String email = "nienhope.sociala@gmail.com";
		final String password = "egoj nivj yotj abtn";
		
        // Email properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);

        // Create a session with your SMTP server
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, password);
                    }
                });
        session.setDebug(true);

        try {
            // Create a MimeMessage
            MimeMessage msg = new MimeMessage(session);

            // Set the email header
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");

            // Set the recipient and sender email addresses
            msg.setFrom(new InternetAddress(email));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));

            // Set the email subject
            msg.setSubject("Your Activation Code");

            // Set the email content (body)
            String message = "<html><body style='font-size: 16px;'>"
                    + "<p>Dear " + recipientName + ",</p>"
                    + "<p>Thank you for signing up. Your activation code is: <strong>" + activationCode + "</strong></p>"
                    + "<p>Please use this code to activate your account.</p>"
                    + "<p>Best regards,<br>From NienHope</p>"
                    + "</body></html>";

            msg.setContent(message, "text/html; charset=utf-8");

            // Send the email
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
