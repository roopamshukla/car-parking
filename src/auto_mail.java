import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class auto_mail
{
   public void send_mail(String recipient,int slot_no,String input_id)
   {    

      Properties properties = System.getProperties();

      properties.setProperty("mail.smtp.host", "localhost");

      Session session = Session.getDefaultInstance(properties);

      try{
         
         MimeMessage message = new MimeMessage(session);
         
         message.setFrom(new InternetAddress("roopam@roopamshukla"));

         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

         message.setSubject("Parking Management System");
         BodyPart messageBodyPart = new MimeBodyPart();

         messageBodyPart.setText("Dear "+input_id+",\nYou have booking confirmation with User ID "+input_id+ " having slot number "+slot_no+".");

         Multipart multipart = new MimeMultipart();

         multipart.addBodyPart(messageBodyPart);

         messageBodyPart = new MimeBodyPart();
         DataSource source = new FileDataSource("ERS_Ticket.txt");
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName("ERS_Ticket.txt");
         multipart.addBodyPart(messageBodyPart);
         message.setContent(multipart );

         Transport.send(message);
         System.out.println("Sent message successfully to "+recipient+" with user ID "+input_id+" having slot "+slot_no+".");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}