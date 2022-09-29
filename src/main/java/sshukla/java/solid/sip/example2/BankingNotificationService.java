package sshukla.java.solid.sip.example2;

/**
 * @author 'Seemant Shukla' on '25/09/2022'
 */
public class BankingNotificationService {

    public void sendOTP(String medium) {
        if (medium.equals("email")) {
            //write email related logic
            //use JavaMailSenderAPI
        }
        if (medium.equals("mobile")) {
            //write logic using twillio API
        }
    }

}
