
package help;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.swing.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class Way4wardHelper {

   
    public String TodaysDate(){
        String TodayDate;
         Date today = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return TodayDate = dateFormat.format(today);     
    }
      public static String STodaysDate(){
      String TodayDate;
      Date today = new Date();
      DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
      return TodayDate = dateFormat.format(today);     
    }
    public void JOpane(String text){
        JOptionPane.showMessageDialog(null, text);
    }
    public  String time;
    public String  timeAndDate(){
        Calendar  cal = new GregorianCalendar();
        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
       
         time = (hour +":" +minute+":"+second);
     
       return time;
              
    }
     
    
      public void AlertBoxError(String title , String header , String content){
        Alert nAlert = new Alert(Alert.AlertType.ERROR);
        nAlert.setTitle(title);
        nAlert.setHeaderText(header);
         nAlert.setContentText(content);
                nAlert.show();
    }
     public void AlertBoxInformation(String title , String header , String content){
        Alert nAlert = new Alert(Alert.AlertType.INFORMATION);
                nAlert.setTitle(title);
                nAlert.setHeaderText(header);
                nAlert.setContentText(content);
                nAlert.show();
    }
    public void AlertBoxConfirmation(String title , String header , String content){
        Alert nAlert = new Alert(Alert.AlertType.CONFIRMATION);
                nAlert.setTitle(title);
                nAlert.setHeaderText(header);
                nAlert.setContentText(content);
                nAlert.show();
    }
     public void AlertBoxWarning(String title , String header , String content){
        Alert nAlert = new Alert(Alert.AlertType.WARNING);
                nAlert.setTitle(title);
                nAlert.setHeaderText(header);
                nAlert.setContentText(content);
                nAlert.show();
    }
    public static void SJOpane(String text){
        JOptionPane.showMessageDialog(null, text);
    }
    public void Sop(String text){
        System.out.println(text);
    } 
      public static void SSop(String text){
        System.out.println(text);
    } 


    public int LongRandomNo(){
        Random rd = new Random();
       return rd.nextInt(999999999)+1;
    }
    
      
public void JMsgBoxStackPane(StackPane stick ,String Title, String Msg){
     stick.setVisible(true);
      JFXDialogLayout content =  new JFXDialogLayout();
  content.setHeading(new Text(Title)); // Header of the Dialog
  content.setBody(new Text(Msg)); // Text in the dialog
 JFXDialog dialog = new JFXDialog(stick, content,JFXDialog.DialogTransition.CENTER);
  JFXButton btn = new JFXButton("Close"); // Button to close Dialog

  btn.setOnAction(new EventHandler <ActionEvent>(){
      @Override
      public void handle(ActionEvent event) {
          dialog.close();
          stick.setVisible(false);
      }
      
  });
  content.setActions(btn);
     
     dialog.show();  
       
       }
public Connection connH2;
public Connection getConnectionH2(String DBName, String Username , String Password) {
try {
    Class.forName("org.h2.Driver");
connH2 = DriverManager.getConnection("jdbc:h2:~/"+DBName+"",Username,Password);
} catch (Exception ex) {
Logger.getLogger(Way4wardHelper.class.getName()).log(Level.SEVERE, null, ex);
}
return connH2;
    }

public Connection connMYSQL;
public Connection getConnectionMYSQL(String DBName ,String Username , String Password) {
try {
 Class.forName("com.mysql.jdbc.Driver");
connMYSQL = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName+"",Username,Password);
}       catch (Exception ex) {
            Logger.getLogger(Way4wardHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
return connMYSQL;
    }
public Connection connSQLITE;
public Connection getConnectionSQLITE(String DBName ,String SQLiteLocation ) {
try {
     Class.forName("com.sqlite.JDBC");
connSQLITE = DriverManager.getConnection("jdbc:sqlite:"+SQLiteLocation+"");
} catch (Exception ex) {
Logger.getLogger(Way4wardHelper.class.getName()).log(Level.SEVERE, null, ex);
}
return connSQLITE;
    }


 public void changeSceneWithJFXDecorator(Node PresentPane , String location , boolean setAlwayOnTop ,boolean setResizable){
      try {
       Parent root = null;
       root = FXMLLoader.load(getClass().getResource(location));
      Stage stage = new Stage();
       JFXDecorator decorator=new JFXDecorator(stage, root, false, false, true);
       decorator.setCustomMaximize(false);
       decorator.setBorder(Border.EMPTY);  
       Scene scene = new Scene(decorator);
      stage.setResizable(setResizable);
        stage.setScene(scene);
        stage.setAlwaysOnTop(setAlwayOnTop);
        stage.show();
       PresentPane.getScene().getWindow().hide();
          } catch (IOException ex) {
                    Logger.getLogger(Way4wardHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
 }
 public void changeScene(Node PresentPane , String location , boolean setAlwayOnTop ,boolean setResizable){
      try {
       Parent root = null;
       root = FXMLLoader.load(getClass().getResource(location));
      Stage stage = new Stage(); 
       Scene scene = new Scene(root);
      stage.setResizable(setResizable);
        stage.setScene(scene);
        stage.setAlwaysOnTop(setAlwayOnTop);
        stage.show();
       PresentPane.getScene().getWindow().hide();
          } catch (IOException ex) {
                    Logger.getLogger(Way4wardHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
 }
 public void changeSceneUndecorated(Node PresentPane , String location , boolean setAlwayOnTop ,boolean setResizable){
      try {
       Parent root = null;
       root = FXMLLoader.load(getClass().getResource(location));
      Stage stage = new Stage(); 
       Scene scene = new Scene(root);
      stage.setResizable(setResizable);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(setAlwayOnTop);
        stage.show();
       PresentPane.getScene().getWindow().hide();
          } catch (IOException ex) {
                    Logger.getLogger(Way4wardHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
 }
 
 

public void Rotation(RotateTransition rt1,Node loader, int setAngle, int setCircleTime, int setSeconds , boolean setAutoReverse){
     loader.setVisible(true);
            rt1.setCycleCount(setCircleTime);
            rt1.setAutoReverse(setAutoReverse);
            rt1.setDuration(Duration.seconds(setSeconds));
            rt1.setFromAngle(setAngle);
            rt1.setToAngle(0);
            rt1.setNode(loader);
           rt1.play();
         
}

 
     public void moveup(TranslateTransition tUP ,Node object, int setSeconds , int setCircleTime, int speed , boolean setRevesable){
        tUP.setDuration(Duration.seconds(setSeconds));
        tUP.setAutoReverse(setRevesable);
        tUP.setCycleCount(setCircleTime);
        tUP.setToY(-speed);
        tUP.setNode(object);
        tUP.playFromStart();
     }
      public void movedown(TranslateTransition DTname , Node object, int setSeconds , int setCircleTime , int speed , boolean setRevesable){
        DTname.setDuration(Duration.seconds(setSeconds));
        DTname.setAutoReverse(setRevesable);
        DTname.setCycleCount(setCircleTime);
        DTname.setToY(speed);
        DTname.setNode(object);
        DTname.playFromStart();  
      }
        public void moveright(TranslateTransition RTname ,Node object, int setSeconds , int setCircleTime, int speed , boolean setRevesable){
        RTname.setDuration(Duration.seconds(setSeconds));
        RTname.setAutoReverse(setRevesable);
        RTname.setCycleCount(setCircleTime);
        RTname.setToX(speed);
        RTname.setNode(object);
        RTname.playFromStart();   
    }
        
         public void moveleft(TranslateTransition LTname,Node object, int setSeconds , int setCircleTime , int speed , boolean setRevesable){
        LTname.setDuration(Duration.seconds(setSeconds));
        LTname.setAutoReverse(setRevesable);
        LTname.setCycleCount(setCircleTime);
        LTname.setToX(-speed);
        LTname.setNode(object);
        LTname.playFromStart();
         }
         
         public void FadeTransition(FadeTransition FTName , Node object, int setFromValue , int setToValue, int setCircleCount ,int setSeconds){
          FTName.setNode(object);
          FTName.setDuration(Duration.seconds(setSeconds));    
          FTName.setFromValue(setFromValue);
          FTName.setToValue(setToValue);
          FTName.setCycleCount(setCircleCount);
          FTName.play();
            
         }
         
         public void ScaleTransition(ScaleTransition STName , Node object , int setToX , int setToY){
        STName.setNode(object);
        STName.setToX(setToX);
        STName.setToY(setToY);
        STName.setCycleCount(Timeline.INDEFINITE);
        STName.setAutoReverse(true);
        STName.play();
         }
         public String sigFig(double DoubleValue , int SigFigure){
              String aa = String.format("%."+SigFigure+"f", DoubleValue);
              Sop(aa);
              return null;
         }
       public String randomRange(int min , int max){
       double range =  min + (int)(Math.random() * ((max - min) + 1));
       return sigFig(range,0);
    }
      public String Imagepath; 
      public File Imagefile;
       public void ImageUploader(ImageView imageViewer){
         
           Image image;
         FileChooser filechooser = new FileChooser();
        filechooser.getExtensionFilters().addAll(
         new FileChooser.ExtensionFilter("images","*.jpg","*.png"),
                  new FileChooser.ExtensionFilter("Text files","*.txt"));
     Imagefile = filechooser.showOpenDialog(null);
 if(Imagefile != null){
       Imagepath = Imagefile.getAbsoluteFile().toString();      
     image  = new Image(Imagefile.getAbsoluteFile().toURI().toString());
     imageViewer.setImage(image);   
 }
 }
       
     public int value;
    public void SendMail(String from , String password, String to , String subject, String msg,int value1){
         
    this.value = value1;
        String From = from;
     String To = to;
     String Subject = subject;
     String Msg = msg;
     Properties props = new Properties();
     props.put("mail.smtp.host", "smtp.gmail.com");
     props.put("mail.smtp.socketFactory.port","465");
     props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
     props.put("mail.smtp.auth","true");
     props.put("mail.smtp.port","465");
     Session session = Session.getDefaultInstance(props,
             new javax.mail.Authenticator() {
             protected PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication(from,to);  
             }   
             }
             );
     try{
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(From));
         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
         message.setSubject(Subject);
         message.setText(Msg);
         Transport.send(message);
        switch(value){
            case 1:
                JOptionPane.showMessageDialog(null , "MESSAGE SENT");
            break;
            case 0:
                System.out.println("MESSAGE SENT");
            break;
        }
     }catch(Exception e){
       switch(value){
            case 1:
                 JOptionPane.showMessageDialog(null , "MESSAGE NOT SENT"+e);
            break;
            case 0:
                  System.out.println("MESSAGE SENT"+e);
            break;
        }
     }
    }
    
    
    
     public static String algo = "AES";
     public byte[] keyValue  = new byte[] {'T','h','e','B','e','s','t','S','e','c','r','e','t','K','e','y'};
 
     public Key generateKey() throws Exception{
         Key key = new SecretKeySpec(keyValue , algo);
         return key;
     }
     
     public String encrypt(String msg) throws Exception{
       Key key  = generateKey();
       Cipher c = Cipher.getInstance(algo);
       c.init(Cipher.ENCRYPT_MODE, key);
       byte[] encVal = c.doFinal(msg.getBytes());
       String encryptedValue = new BASE64Encoder().encode(encVal);
       return encryptedValue;
       
     }
      public String decrypt(String msg) throws Exception{
       Key key  = generateKey();
       Cipher c = Cipher.getInstance(algo);
       c.init(Cipher.DECRYPT_MODE, key);
       byte[] decordedValue = new BASE64Decoder().decodeBuffer(msg);
       byte[] decValue = c.doFinal(decordedValue);
       String decryptedValue = new String(decValue);
       return decryptedValue;  
       
     }
 
}


