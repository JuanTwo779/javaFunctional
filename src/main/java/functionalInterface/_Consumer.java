package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args){
        //normal
        addToStock(new Stock("Banana", 9));

        //consumer
        addToStockConsumer.accept(new Stock("Apple", 10));

        //BiConsumer
        addTwoToStock.accept(new Stock("Peach", 11), new Stock("Orange", 12));
        Stock eggplant = new Stock("Eggplant", 12);
        addSecretStock.accept(eggplant, false);

        iDPrivate(new Stock("water", 1), false);
    }


    //Normal
    private static void addToStock(Stock stock){
        System.out.println(stock.itemName + " added to stock. Item ID: " + stock.itemId);
    }

    private static void iDPrivate(Stock stock, boolean yeahNa){
        System.out.println("The item ID of " + stock.itemName + " is " +
                (yeahNa ? stock.itemId : "***********"));
    }

    //Functional
    //mimics a void method
    private static Consumer<Stock> addToStockConsumer =
            stock -> System.out.println(stock.itemName + " added to stock. Item ID: " + stock.itemId);

    private static BiConsumer<Stock, Stock> addTwoToStock = (stock1, stock2) ->
            System.out.println(stock1.itemName + " added to stock. Item ID: " + stock1.itemId + "\n" +
                    stock2.itemName + " added to stock. Item ID: " + stock2.itemId);

    private static BiConsumer<Stock, Boolean> addSecretStock = (stock, showPhone) ->
            System.out.println(stock.itemName + " added to stock. Item ID: " +
                    (showPhone ? stock.itemId : "*********"));





    static class Stock{
        private final String itemName;
        private final int itemId;

        Stock(String itemName, int itemId) {
            this.itemName = itemName;
            this.itemId = itemId;
        }
    }
}
