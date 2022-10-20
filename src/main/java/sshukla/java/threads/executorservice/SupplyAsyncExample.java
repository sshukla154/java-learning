package sshukla.java.threads.executorservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * @author 'Seemant Shukla' on '20/10/2022'
 */
public class SupplyAsyncExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SupplyAsyncExample supplyAsyncExample = new SupplyAsyncExample();
        Supplier<List<Employee>> employeeSupplier = () -> getFromDB(new File("src/main/resources/employees.json"), new TypeReference<>() {
        });
        System.out.println(supplyAsyncExample.getAllEmployeeWithForkJoinPoolExecutor(employeeSupplier).size());
        System.out.println("+==========+++++++++++++>>>>>>>>>>>");
        System.out.println(supplyAsyncExample.getAllEmployeeWithCustomExecutor(employeeSupplier).size());
    }

    private Collection<Employee> getAllEmployeeWithCustomExecutor(Supplier<List<Employee>> employeeSupplier) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<List<Employee>> completableFuture = CompletableFuture.supplyAsync(employeeSupplier, executorService);
        executorService.shutdown();
        return completableFuture.get();
    }

    public List<Employee> getAllEmployeeWithForkJoinPoolExecutor(Supplier<List<Employee>> employeeSupplier) throws ExecutionException, InterruptedException {
        CompletableFuture<List<Employee>> completableFuture = CompletableFuture.supplyAsync(employeeSupplier);
        return completableFuture.get();
    }

    private static List<Employee> getFromDB(File fileName, TypeReference<List<Employee>> typeReference) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Employee> employeeList;
        try {
            employeeList = objectMapper.readValue(fileName, typeReference);
            System.out.println("Thread - getFromDB() - " + Thread.currentThread().getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }


}
