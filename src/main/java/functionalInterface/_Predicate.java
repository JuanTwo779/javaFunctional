package functionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        //Without predicate
        System.out.println(isPhoneNumberValid("0481988967"));

        //With predicate
            //.test()
        System.out.println(validPhone.test("0419529560"));
        //Two separate predicates
            //.and() .or()
        System.out.println(validPhone.and(has3).test("1300655506"));
        System.out.println(validPhone.or(has3).test("5"));

        //BiPredicate
        System.out.println(validLengthAndDivisible.test("0481988966", 3));
    }


    private static boolean isPhoneNumberValid (String phoneNo){
        return phoneNo.startsWith("04") && phoneNo.length() == 10;
    }

    //Predicate
    private static Predicate<String> validPhone = phoneNo ->
            phoneNo.startsWith("04")|phoneNo.startsWith("13") && phoneNo.length() == 10;

    private static Predicate<String> has3 = phoneNo -> phoneNo.contains("5");

    private static BiPredicate<String, Integer> validLengthAndDivisible = (phoneNo, num) ->
            phoneNo.length() == 10 && (Integer.parseInt(phoneNo)%num) ==0;
}
