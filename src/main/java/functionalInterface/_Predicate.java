package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        validPhone.test("0419529560");
    }


    private static boolean isPhoneNumberValid (String phoneNo){
        return phoneNo.startsWith("04") && phoneNo.length() == 8;
    }

    //Predicate
    private static Predicate<String> validPhone = phoneNo ->
            phoneNo.startsWith("04") && phoneNo.length() == 8;
}
