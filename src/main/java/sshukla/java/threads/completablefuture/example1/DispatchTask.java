package sshukla.java.threads.completablefuture.example1;

import java.util.concurrent.Callable;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */
public class DispatchTask implements Callable<Order> {

    private Order order;

    public DispatchTask() {
    }

    public DispatchTask(Order order) {
        this.order = order;
    }

    @Override
    public Order call() throws Exception {
        System.out.println("DispatchTask.call() - " + Thread.currentThread().getName());
        return new Order();
    }
}
