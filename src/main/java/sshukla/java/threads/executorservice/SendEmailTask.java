package sshukla.java.threads.executorservice;

import java.util.concurrent.Callable;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */
public class SendEmailTask implements Callable<Order> {

    private Order order;

    public SendEmailTask() {
    }

    public SendEmailTask(Order order) {
        this.order = order;
    }

    @Override
    public Order call() throws Exception {
        System.out.println("SendEmailTask.call() - " + Thread.currentThread().getName());
        return new Order();
    }
}
