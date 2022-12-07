package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidator {

    public boolean isEmailValid(String email) {
        return email.contains("@");
    }

    public boolean isPhoneValid(String phoneNum) {
        return phoneNum.startsWith("+0");
    }

    public boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() >  16;
    }

    public boolean isValid (Customer customer) {
        return isEmailValid(customer.getEmail()) &&
                isPhoneValid(customer.getPhoneNum()) &&
                isAdult(customer.getDob());
    }

}
