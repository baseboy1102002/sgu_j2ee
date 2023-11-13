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
            msg.setSubject("Mã Xác Nhận Tài Khoản");

            // Set the email content (body)
            String message = "<html><body style='font-size: 16px;'>"
                    + "<p>Xin chào " + recipientName + ",</p>"
                    + "<p>Cảm ơn bạn đã đăng kí tài khoản tại NienHope. Mã xác nhận tài khoản của bạn là: <strong>" + activationCode + "</strong></p>"
                    + "<p>Hãy sử dụng mã trên để kích hoạt tài khoản của mình.</p>"
                    + "<p>Gửi bạn lời chào trân trọng nhất,<br>từ NienHope Sociala</p>"
                    + "</body></html>";

            msg.setContent(message, "text/html; charset=utf-8");

            // Send the email
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    public static void sendChangedPassword(String recipientEmail, String recipientName, String newPassword) {
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
            msg.setSubject("Cảnh báo thay đổi mật khẩu");

            // Set the email content (body)
            String message = "<html><body style='font-size: 16px;'>"
                    + "<p>Chào " + recipientName + ",</p>"
                    + "<p>Tài khoản NienHope của bạn vừa thay mật khẩu thành <strong>" + newPassword + "</strong></p>"
                    + "<p>Nếu đây không phải là bạn vui lòng thay đổi lại mật khẩu</p>"
                    + "<p>Gửi bạn lời chào trân trọng nhất,<br>từ NienHope Sociala</p>"
                    + "</body></html>";

            msg.setContent(message, "text/html; charset=utf-8");

            // Send the email
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    public static void sendForgetPassword(String recipientEmail, String recipientName, String newPassword) {
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
            msg.setSubject("Gửi Mật Khẩu");

            // Set the email content (body)
            String message = "<html><body style='font-size: 16px;'>"
                    + "<p>Chào " + recipientName + ",</p>"
                    + "<p>Chúng tôi vừa nhận được yêu cầu gửi lại mật khẩu do quên mật khẩu tài khoản NienHope. Mật khẩu cho tài khoản sử dụng email này là: <strong>" + newPassword + "</strong></p>"
                    + "<p>Nếu mật khẩu hiện tại của bạn dễ quên quá, hãy đổi mật khẩu tại cài đặt.</p>"
                    + "<p>Gửi bạn lời chào trân trọng nhất,<br>từ NienHope Sociala</p>"
                    + "</body></html>";

            msg.setContent(message, "text/html; charset=utf-8");

            // Send the email
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
