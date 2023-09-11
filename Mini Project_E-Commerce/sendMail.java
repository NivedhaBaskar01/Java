package Ecommerce;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class sendMail
{


    

	public void sendPlainTextEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message) throws AddressException,
            MessagingException {

        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.user", userName);

        // creates a new session, no Authenticator (will connect() later)
        Session session = Session.getDefaultInstance(properties);


        // creates a new e-mail message
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        //msg.setSentDate(new Date());
        // set plain text message
        //msg.setText(message);
        
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        msg.setSentDate(new Date());
        // set plain text message
        //msg.setText(message);
        
        messageBodyPart.setText(message);

        // Create a multipar message
        MimeMultipart multipart = new MimeMultipart();

        // Set text message part
        multipart.addBodyPart(messageBodyPart);

        // Part two is attachment
        messageBodyPart = new MimeBodyPart();
        String filename = "D:\\Receipt.png";
        FileDataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filename);
        multipart.addBodyPart(messageBodyPart);

        // Send the complete message parts
        msg.setContent(multipart);

        Transport t = session.getTransport("smtp");
        t.connect(userName, password);
        t.sendMessage(msg, msg.getAllRecipients());
        t.close();

    }	
	//public static void main(String[] args) {
	public sendMail(String mailTo,String subject,String message) {
        // SMTP server information
        String host = "smtp.gmail.com";
        String port = "587";
        
        String mailFrom = "ecommerce.shippingjava2023@gmail.com";
        String password = "fdhbefwvqukowyri";
       

        //sendMail mailer = new sendMail();

        try {
            sendPlainTextEmail(host, port, mailFrom, password, mailTo,
                    subject, message);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
            ex.printStackTrace();
        }
      
    }
//	public static void main(String[] args) {
//		sendMail m=new sendMail("srijag0602@gmail.com","Hi","Hello");
//	}

}

