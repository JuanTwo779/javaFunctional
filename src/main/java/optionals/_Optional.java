package optionals;

import java.util.Optional;
import java.util.Scanner;

public class _Optional {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("Enter name:");
        String name = scan.nextLine();


        Object test = Optional.ofNullable(name)
                .orElseGet(() -> "trash name");
        System.out.println(test);

        Optional.ofNullable(null)
                 .ifPresentOrElse(value -> System.out.println(value), () -> System.out.println("Wheres your name?"));
                //.ifPresent(value -> System.out.println(value)

    }
}
