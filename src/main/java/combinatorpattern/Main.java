package combinatorpattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Juan",
                "juan@email.com",
                "+0987987987",
                LocalDate.of(2000, 8, 11)
        );

        CustomerValidator cv = new CustomerValidator();
        System.out.println(cv.isValid(customer));
    }
}
