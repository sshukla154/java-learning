package sshukla.java.solid.sip.example2;

/**
 * @author 'Seemant Shukla' on '25/09/2022'
 */
public class BankService_NON_SRP {

    /**
     * Banking Transaction Services
     **/
    public long deposit(long amount, String accountNo) {
        //deposit amount
        return 0;
    }

    public long withDraw(long amount, String accountNo) {
        //withdraw amount
        return 0;
    }

    /**
     * Banking Printing Services
     **/
    public void printPassbook() {
        //update transaction info in passbook
    }

    /**
     * Banking Notification Services
     **/
    public void sendOTP(String medium) {
        if (medium.equals("email")) {
            //write email related logic
            //use JavaMailSenderAPI
        }
        if (medium.equals("mobile")) {
            //write logic using twillio API
        }
    }

    /**
     * Banking Loan Services
     **/
    public void getLoanInterestInfo(String loanType) {
        if (loanType.equals("homeLoan")) {
            //do some job
        }
        if (loanType.equals("personalLoan")) {
            //do some job
        }
        if (loanType.equals("car")) {
            //do some job
        }
    }

}
