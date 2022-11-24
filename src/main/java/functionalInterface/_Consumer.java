package functionalInterface;

import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args){
        //normal
        addToStock(new Stock("Banana", 9));

        //consumer
        addToStockConsumer.accept(new Stock("Apple", 10));
    }


    //Normal
    private static void addToStock(Stock stock){
        System.out.println(stock.itemName + " added to stock. Item ID: " + stock.itemId);
    }

    //Functional
    //mimics a void method
    private static Consumer<Stock> addToStockConsumer =
            stock -> System.out.println(stock.itemName + " added to stock. Item ID: " + stock.itemId);




    static class Stock{
        private final String itemName;
        private final int itemId;

        Stock(String itemName, int itemId) {
            this.itemName = itemName;
            this.itemId = itemId;
        }
    }
}
