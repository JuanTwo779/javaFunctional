package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args){
        // Function; 1 argument and produce 1 result
        int increment = incrementOne(1);
        System.out.println(increment);

        int increment2 = decrementOneFunction.apply(10);
        System.out.println(increment2);

        int squared = square.apply(increment2);
        System.out.println(squared);


        // Chaining functions
        Function<Integer, Integer> decrementThenSquare = decrementOneFunction.andThen(square);
        System.out.println(decrementThenSquare.apply(16));

        // BiFunction ; 2 arguments and produce 1 result
        System.out.println(incrementThenMultiply.apply(7,2));
    }

    //Imperative
    private static int incrementOne(int number){
        return number + 1;
    }
    private static int incrementAndMultiply(int num, int num2){ return (num +1) * num2; }

    //Declarative
    private static Function<Integer, Integer> decrementOneFunction = num -> num -1;

    private static Function<Integer, Integer> square = num -> num * num;

    private static BiFunction<Integer, Integer, Integer> incrementThenMultiply =
            (numberToIncrement, numberToMultiply) ->
                    (numberToIncrement + 1) * numberToMultiply;
}
