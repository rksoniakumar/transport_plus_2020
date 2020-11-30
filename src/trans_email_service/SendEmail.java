package trans_email_service;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*; 
import javax.mail.internet.*; 
//import javax.activation.*; 
import javax.mail.Session; 
import javax.mail.Transport; 

public class SendEmail {

	   public static void main(String [] args)  
	   {
		   //from,password,to,subject,message  
//		     send("rksoniakumar@gmail.com","wziwauaaxijvblhl","rksoniakumar@gmail.com","Hello Testing 333","How r u?");  
		     //change from, password and to  
	   }
//	   void addRecipients(Message.RecipientType type, Address[] addresses) 
//			   throws MessagingException
//			   {
//
//			   }
	   public static void send(String from,String password,String to,String sub,String msg){  
	          //Get properties object    
	          Properties props = new Properties();    
	          props.put("mail.smtp.host", "smtp.gmail.com");    
	          props.put("mail.smtp.socketFactory.port", "465");    
	          props.put("mail.smtp.socketFactory.class",    
	                    "javax.net.ssl.SSLSocketFactory");    
	          props.put("mail.smtp.auth", "true");    
	          props.put("mail.smtp.port", "465");    
	          //465
	          //Port: 465 (SSL required) or 587 (TLS required)
	          //get Session   
	          Session session = Session.getDefaultInstance(props,    
	           new javax.mail.Authenticator() {    
	           protected PasswordAuthentication getPasswordAuthentication() {    
	           return new PasswordAuthentication(from,password);  
	           }    
	          });    
	          //compose message  
	       // create a new String array 
	          String[] recipients = new String[2]; 
	            
	          // add email addresses 
	          recipients[0] = "first@gmail.com";
	          recipients[1] = "second@gmail.com";
//	          recipients[2] = third@gmail.com 
//	          recipients[3] = fourth@gmail.com 
	         
	          // inside of try block instead of using addRecipient()  
	          // use addRecipients() 
	            
	          // specify the type of field(TO, CC ,BCC) 
	          // pass the array of email ids of recipients 
	          String[] toList = { "rksoniakumar@gmail.com",  "grama.0827@gmail.com", "chethana4631@gmail.com","laljit31@gmail.com"
	        		  }; // list of recipient email addresses
	          try {    
	           MimeMessage message = new MimeMessage(session);    
	         // to one person
//	            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to)); 
//	           message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipients)); 
// to multiple person 
	            

//		          		message.addRecipients(Message.RecipientType.TO, cc);
	           message.addRecipients(Message.RecipientType.TO, 
	                      InternetAddress.parse("rksoniakumar@gmail.com,grama.0827@gmail.com"
	                      		+ ",chethana4631@gmail.com"
	                    		  ));
	           message.addRecipients(Message.RecipientType.CC, 
	                      InternetAddress.parse("rksoniakumar@gmail.com,grama.0827@gmail.com"));
	           message.setSubject(sub); 
	           // just text
//	           message.setText(msg);   

	           // set body of the email html format
	          // message.setContent("<h1>This is a HTML text</h1>","text/html"); 
	        // creating first MimeBodyPart object 
	            BodyPart messageBodyPart1 = new MimeBodyPart();  
//	            messageBodyPart1.setText(msg); 
	            messageBodyPart1.setContent("<h1>"+msg+"</h1>"
	            		+ "<h4>Driver X is allocated from Quincy to Boston </h4>",
	            		"text/html"); 
	              
	            // creating second MimeBodyPart object for one file
//	            BodyPart messageBodyPart2 = new MimeBodyPart();  
//	            String filename = "E:\\TransProj\\maildoc.txt";
//	            DataSource source = new FileDataSource(filename);   
//	            messageBodyPart2.setDataHandler(new DataHandler(source));   
//	            messageBodyPart2.setFileName(filename);   
	              
	            // creating MultiPart object 
	            Multipart multipartObject = new MimeMultipart();   
	            multipartObject.addBodyPart(messageBodyPart1); 
	         // creating second MimeBodyPart object for one file
//	            multipartObject.addBodyPart(messageBodyPart2); 
	            // creating second MimeBodyPart object for multiple files
	            String[] attachFiles = new String[2];
	            attachFiles[0] = "E:\\TransProj\\maildoc.txt";
	            attachFiles[1] = "E:\\TransProj\\mutlipleattach.txt";

	            if(attachFiles != null && attachFiles.length > 0){
	                for (String filePath : attachFiles) {
	                    MimeBodyPart attachPart = new MimeBodyPart();
	                    try {
	                        attachPart.attachFile(filePath);
	                    } catch (IOException ex) {
	                        ex.printStackTrace();
	                    }
	                    multipartObject.addBodyPart(attachPart);
	                }
	            }
//	            BodyPart messageBodyPart2 = new MimeBodyPart();  
//	            String filename = "E:\\TransProj\\maildoc.txt";
//	            DataSource source = new FileDataSource(filename);   
//	            messageBodyPart2.setDataHandler(new DataHandler(source));   
//	            messageBodyPart2.setFileName(filename); 
//	            multipartObject.addBodyPart(messageBodyPart2); 
	      
	      
	      
	            // set body of the email. 
	            message.setContent(multipartObject); 
	           //send message  
	           Transport.send(message);    
	           System.out.println("message sent successfully");    
	          } catch (MessagingException e) {throw new RuntimeException(e);}    
	             
	    }  

}
