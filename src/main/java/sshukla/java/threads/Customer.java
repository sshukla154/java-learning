package sshukla.java.threads;

/**
 * @author 'Seemant Shukla' on '17/10/2022'
 */
public class Customer {
    Double amount = 5000.00;

    public synchronized void withdrawAmount(Double amount) {
        if (this.amount < amount) {
            try {
                System.out.println("Deposit 10000 in account and notify this withdraw process");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.amount -= amount;
            System.out.println(amount + " withdraw completed... And " + this.amount + " is remaining in your account");
        } else {
            System.out.println(amount + " withdrawn successfully!!");
        }
    }

    public synchronized void depositAmount(Double amount) {
        this.amount += amount;
        System.out.println(amount + " deposited successfully in account!! Now total amount in your account is " + this.amount);
        notify();
    }

}

class CustomerTransaction {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Thread t1 = new Thread(() -> customer.withdrawAmount(6000.00));
        t1.start();
        Thread t2 = new Thread(() -> customer.depositAmount(10000.00));
        t2.start();
    }
}
