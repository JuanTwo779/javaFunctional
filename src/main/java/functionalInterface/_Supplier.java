package functionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        //RETURN method
        System.out.println(getDBConnectionUrl());

        //Supplier
        System.out.println(getDBUrl.get());
        System.out.println(getList.get());
    }

    private static String getDBConnectionUrl(){
        return "jdbc://localhost:1234/user/Juan";
    }

    private static Supplier<String> getDBUrl = () ->
            "jdbc://localhost:1234/user/Juan";

    private static Supplier<List<String>> getList = () ->
            List.of(
                    "1. Reiss Nelson",
                    "2. Bukayo Saka",
                    "3. Eddie Nketiah"
            );
}
