package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegoValidator.*;
import static combinatorpattern.CustomerRegoValidator.ValidationResult.SUCCESS;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Juan",
                "juan@email.com",
                "+0987987987",
                LocalDate.of(2000, 8, 11)
        );

//        CustomerValidator cv = new CustomerValidator();
//        System.out.println(cv.isValid(customer));
//        System.out.println(new CustomerValidator().isValid(customer));
        //We can't tell what is wrong unless we put in a lot more code i.e. if()

        //Combinator pattern
        ValidationResult result =
        isEmailValid().and(isPhoneValid().and(isAdult())).apply(customer);
        System.out.println(result);

        if (result != SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
