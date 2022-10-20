package sshukla.java.threads.executorservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 'Seemant Shukla' on '20/10/2022'
 */
public class RunAsyncExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RunAsyncExample runAsyncExample = new RunAsyncExample();
        runAsyncExample.fetchAndSaveEmployeeWithForkJoinPoolExecutor(new File("src/main/resources/employees.json"));
        System.out.println("+==========+++++++++++++>>>>>>>>>>>");
        runAsyncExample.fetchAndSaveEmployeeWithCustomExecutor(new File("src/main/resources/employees.json"));
    }

    private Void fetchAndSaveEmployeeWithForkJoinPoolExecutor(File fileName) throws ExecutionException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            //Fetch the data from json file
            TypeReference<List<Employee>> listTypeReference = new TypeReference<>() {
            };
            try {
                List<Employee> employeeList = objectMapper.readValue(fileName, listTypeReference);
                System.out.println("Thread - fetchAndSaveEmployeeWithForkJoinPoolExecutor() - " + Thread.currentThread().getName());
//                employeeList.forEach(System.out::println);
                //Now save this list of employee to DB --  For practice instead of saving we are printing on console
                System.out.println("Saving Employee List in DB : " + employeeList.size());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return completableFuture.get();
    }

    private Void fetchAndSaveEmployeeWithCustomExecutor(File fileName) throws ExecutionException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            //Fetch the data from json file
            TypeReference<List<Employee>> listTypeReference = new TypeReference<>() {
            };
            try {
                List<Employee> employeeList = objectMapper.readValue(fileName, listTypeReference);
                System.out.println("Thread - fetchAndSaveEmployeeWithCustomExecutor() - " + Thread.currentThread().getName());
                //Now save this list of employee to DB --  For practice instead of saving we are printing on console
//                employeeList.forEach(System.out::println);
                System.out.println("Saving Employee List in DB : " + employeeList.size());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, executorService);
        executorService.shutdown();
        return completableFuture.get();
    }

}
