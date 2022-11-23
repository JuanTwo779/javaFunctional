package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args){
        int increment = incrementOne(1);
        System.out.println(increment);

        int increment2 = decrementOneFunction.apply(10);
        System.out.println(increment2);

        int squared = square.apply(increment2);
        System.out.println(squared);


        Function<Integer, Integer> decrementThenSquare =
                decrementOneFunction.andThen(square);

        //chaining functions
        System.out.println(decrementThenSquare.apply(16));
    }

    private static int incrementOne(int number){
        return number + 1;
    }
    private static int incrementAndMultiply(int num, int num2){ return (num +1) * num2; }

    private static Function<Integer, Integer> decrementOneFunction = num -> num -1;

    private static Function<Integer, Integer> square = num -> num * num;

    private static BiFunction<Integer, Integer, Integer> incrementThenMultiply =
            (numberToIncrement, numberToMultiply) ->
                    (numberToIncrement + 1) * numberToMultiply;
}
