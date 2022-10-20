package sshukla.java.threads.completablefuture.example1;

import lombok.*;

/**
 * @author 'Seemant Shukla' on '19/10/2022'
 */

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    private Long id;
    private String name;
    private String email;
    private String address;
    private Boolean isPaymentDone;
    private Double paymentAmount;

}
