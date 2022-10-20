package sshukla.java.threads.executorservice;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 * <p>
 * Each Order has 5 task: Fetch Order, Enrich Order, Payment, Dispatch, Send Email
 * <p>
 * Each Order has 5 task: Fetch Order, Enrich Order, Payment, Dispatch, Send Email
 * <p>
 * Each Order has 5 task: Fetch Order, Enrich Order, Payment, Dispatch, Send Email
 * <p>
 * Each Order has 5 task: Fetch Order, Enrich Order, Payment, Dispatch, Send Email
 * <p>
 * Each Order has 5 task: Fetch Order, Enrich Order, Payment, Dispatch, Send Email
 * <p>
 * Each Order has 5 task: Fetch Order, Enrich Order, Payment, Dispatch, Send Email
 * <p>
 * Each Order has 5 task: Fetch Order, Enrich Order, Payment, Dispatch, Send Email
 **/

/**
 * Each Order has 5 task: Fetch Order, Enrich Order, Payment, Dispatch, Send Email
 **/

/** In below example the dependent flow.
 *
 * As it has for loop at a time only one order is being processed. Which mean, till be complete one order we cannot process another other
 * i.e. Each order is in sequential processing, and It's for all the order.
 *
 * Order-1 : Fetch Order-1, Enrich Order-1, Payment-1, Dispatch-1, Send Email-1
 * Order-2 : Fetch Order-2, Enrich Order-2, Payment-2, Dispatch-2, Send Email-2
 * Order-3 : Fetch Order-3, Enrich Order-3, Payment-3, Dispatch-3, Send Email-3
 * Order-4 : Fetch Order-4, Enrich Order-4, Payment-4, Dispatch-4, Send Email-4
 * Order-5 : Fetch Order-5, Enrich Order-5, Payment-5, Dispatch-5, Send Email-5
 *
 * Processing order in this case: Fetch Order-1, Enrich Order-1, Payment-1, Dispatch-1, Send Email-1, Fetch Order-2, Enrich Order-2, Payment-2, Dispatch-2, Send Email-2, Fetch Order-3, Enrich Order-3, Payment-3, Dispatch-3, Send Email-3, Fetch Order-4, Enrich Order-4, Payment-4, Dispatch-4, Send Email-4, Fetch Order-5, Enrich Order-5, Payment-5, Dispatch-5, Send Email-5
 * While each task is possible blocking i.e. if stuck at any point no further processing. This will result in BLOCKing the main thread.
 *
 * So, we need to make the above example to flow independent. This can be achieved by using CompletableFuture
 *
 * See example "MultiFutureBlockingScenarioProblem"
 *
 **/

//https://www.youtube.com/watch?v=ImtZgX1nmr8
public class MultiFutureBlockingScenarioSolution {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Create a Thread Pool with 10 threads
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //Consider each integer i.e from 1 to 10 is corresponding to one order
        for (Integer i : IntStream.range(1, 11).toArray()) {

            CompletableFuture.supplyAsync(() -> getOrderTask())
                    .thenApply(newOrder -> enrichTask(newOrder))
                    .thenApply(order -> performPaymentTask(order))
                    .thenApply(order -> dispatchTask(order))
                    .thenApply(order -> sendEmailTask(order));

//            System.out.println("Order : " + order.toString());
            System.out.println("MultiFutureBlockingScenarioExample.main() - " + Thread.currentThread().getName());
        }

        executorService.shutdown();
    }



    private static Order getOrderTask() {
        return new Order();
    }

    private static Order enrichTask(Order order) {
        return new Order();
    }

    private static Order performPaymentTask(Order order) {
        return new Order();
    }

    private static Order dispatchTask(Order order) {
        return new Order();
    }

    private static Order sendEmailTask(Order order) {
        return new Order();
    }

}
