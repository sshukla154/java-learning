package sshukla.java.threads.completablefuture.example1;

import java.util.concurrent.Callable;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */
public class EnrichOrderTask implements Callable<Order> {

    private Order order;

    public EnrichOrderTask() {
    }

    public EnrichOrderTask(Order order) {
        this.order = order;
    }

    @Override
    public Order call() throws Exception {
        System.out.println("EnrichOrderTask.call() - " + Thread.currentThread().getName());
        return new Order();
    }
}
