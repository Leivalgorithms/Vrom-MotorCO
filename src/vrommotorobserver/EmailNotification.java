/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vrommotorobserver;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
/**
 *
 * @author leiva
 */
public class EmailNotification implements Observer {
    private String emailAddress;

    public EmailNotification(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void notify(String message) {
        // Configuración para Mailtrap
        final String username = "USUARIO"; // Reemplaza con tu usuario SMTP de Mailtrap
        final String password = "password"; // Reemplaza con tu contraseña SMTP de Mailtrap

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.mailtrap.io");
        props.put("mail.smtp.port", "2525");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(username));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddress));
            mimeMessage.setSubject("Email de prueba");
            mimeMessage.setText("Message: " + message);

            Transport.send(mimeMessage);

            System.out.println("Sent email to " + emailAddress + ": " + message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
