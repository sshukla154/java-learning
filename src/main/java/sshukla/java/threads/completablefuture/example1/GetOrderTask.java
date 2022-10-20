package sshukla.java.threads.completablefuture.example1;

import java.util.concurrent.Callable;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */
public class GetOrderTask implements Callable<Order> {

    public GetOrderTask() {
    }

    @Override
    public Order call() throws Exception {
        System.out.println("GetOrderTask.call() - " + Thread.currentThread().getName());
        return new Order();
    }
}
