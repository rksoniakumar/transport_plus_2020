package trans_email_service;

import java.util.Properties;
import javax.mail.Session; 
import javax.mail.Transport; 
import javax.mail.*; 
import javax.mail.internet.*; 

public class TestEmail {
	final String username;
	final String password;
	public TestEmail(final String username,final String password){
	    this.username=username;
	    this.password=password;

	}
	 public static void main(String [] args)  
	   {
		 TestEmail m = new TestEmail("rksoniakumar@gmail.com", "wziwauaaxijvblhl");
		 m.sendMail("Test", "Testing", "rksoniakumar@gmail.com", "grama.0827@gmail.com", "rksoniakumar@gmail.com");
	   }
	 public void sendMail(String Sub,String msg,String sender,String cc,String to) {
		    Properties props = new Properties();
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.port", "587");

		    Session session = Session.getInstance(props,
		      new javax.mail.Authenticator() {
		        protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(username, password);
		        }
		      });

		    try {

		        Message message = new MimeMessage(session);
		        message.setFrom(new InternetAddress(sender));
		        message.setRecipients(Message.RecipientType.TO,
		            InternetAddress.parse(to));
		        message.setSubject(Sub);
		        message.setText(msg);

		        Transport.send(message);

		        System.out.println("Done");

		    } catch (MessagingException e) {
		        throw new RuntimeException(e);
		    }
		}

}
