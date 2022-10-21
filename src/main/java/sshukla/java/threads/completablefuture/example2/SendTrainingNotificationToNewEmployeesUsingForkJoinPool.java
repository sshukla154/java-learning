package sshukla.java.threads.completablefuture.example2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import sshukla.java.threads.completablefuture.Employee;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author 'Seemant Shukla' on '20/10/2022'
 */
public class SendTrainingNotificationToNewEmployeesUsingForkJoinPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        sendReminderToEmployees();

    }

    private static Void sendReminderToEmployees() throws InterruptedException, ExecutionException {
        Supplier<List<Employee>> getEmployeesFromDBSupplier = () -> {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                System.out.println("Fetch Data From DB Thread - " + Thread.currentThread().getName());
                return objectMapper.readValue(Paths.get("src/main/resources/employees.json").toFile(), new TypeReference<>() {
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        Function<List<Employee>, List<Employee>> filterOutOldEmployeesFunction = employees -> {
            System.out.println("Filter Out OLd Thread - " + Thread.currentThread().getName());
            return employees.stream().filter(employee -> "TRUE".equals(employee.getNewJoiner())).collect(Collectors.toList());
        };
        Function<List<Employee>, List<Employee>> isTrainingDoneForOldEmployeesFunction = employees -> {
            System.out.println("Training Pending Check Thread - " + Thread.currentThread().getName());
            return employees.stream().filter(employee -> "TRUE".equals(employee.getLearningPending())).collect(Collectors.toList());
        };
        Function<List<Employee>, List<String>> trainingPendingEmployeesFunction = employees -> {
            System.out.println("Training Pending List Thread - " + Thread.currentThread().getName());
            return employees.stream().map(Employee::getEmail).collect(Collectors.toList());
        };
        Consumer<List<String>> sendNotificationToPendingEmployeesConsumer = emailIdList -> {
            System.out.println("Notification Thread - " + Thread.currentThread().getName());
            emailIdList.forEach(emailId -> System.out.println("Email Notification sent to : " + emailId));
        };
        CompletableFuture<Void> completableFuture = CompletableFuture
                .supplyAsync(getEmployeesFromDBSupplier)
                .thenApply(filterOutOldEmployeesFunction)
                .thenApply(isTrainingDoneForOldEmployeesFunction)
                .thenApply(trainingPendingEmployeesFunction)
                .thenAccept(sendNotificationToPendingEmployeesConsumer);

        return completableFuture.get();
    }


}
