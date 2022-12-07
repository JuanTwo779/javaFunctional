package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorpattern.CustomerRegoValidator.*;
import static combinatorpattern.CustomerRegoValidator.ValidationResult.*;

public interface CustomerRegoValidator extends Function <Customer, ValidationResult> {

    static CustomerRegoValidator isEmailValid(){
        return customer -> customer.getEmail().contains("@") ?
                SUCCESS : EMAIL_NUMBER_NOT_VALID;
    }

    static CustomerRegoValidator isPhoneValid(){
        return customer -> customer.getPhoneNum().startsWith("+0") ?
                SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegoValidator isAdult(){
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                SUCCESS : IS_NOT_AN_ADULT;
    }

    default CustomerRegoValidator and (CustomerRegoValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NUMBER_NOT_VALID,
        IS_NOT_AN_ADULT;
    }
}
