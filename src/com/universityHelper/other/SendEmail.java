package com.universityHelper.other;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {
	public static boolean sendMailTO(String email, String recoveryToekn) {
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", true); // added this line
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.user", "universityhelperhs");
		props.put("mail.smtp.password", "19920810");
		props.put("mail.smtp.port", "587");

		props.put("mail.smtp.auth", true);

		Session session = Session.getInstance(props, null);
		MimeMessage message = new MimeMessage(session);

		System.out.println("Port: " + session.getProperty("mail.smtp.port"));

		// Create the email addresses involved
		try {
			InternetAddress from = new InternetAddress("universityhelperhs@gmail.com");
			message.setSubject("Recovery password for university helper");
			message.setFrom(from);
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

			// Create a multi-part to combine the parts
			Multipart multipart = new MimeMultipart("alternative");

			// Create your text message part
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Recovery password");

			// Add the text part to the multipart
			multipart.addBodyPart(messageBodyPart);

			// Create the html part
			messageBodyPart = new MimeBodyPart();
			String htmlMessage = recoveryToekn;
			messageBodyPart.setContent(htmlMessage, "text/html");

			// Add html part to multi part
			multipart.addBodyPart(messageBodyPart);

			// Associate multi-part with message
			message.setContent(multipart);

			// Send message
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", "universityhelperhs@gmail.com", "19920810");
			System.out.println("Transport: " + transport.toString());
			transport.sendMessage(message, message.getAllRecipients());
			return true;

		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
