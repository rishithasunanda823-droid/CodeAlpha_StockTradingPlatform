import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    private HashMap<String, Integer> holdings;

    public Portfolio() {
        holdings = new HashMap<>();
    }

    // Buy Stock
    public void buyStock(String stockName, int quantity) {
        if (holdings.containsKey(stockName)) {
            holdings.put(stockName, holdings.get(stockName) + quantity);
        } else {
            holdings.put(stockName, quantity);
        }

        System.out.println(quantity + " shares of " + stockName + " purchased successfully.");
    }

    // Sell Stock
    public boolean sellStock(String stockName, int quantity) {

        if (!holdings.containsKey(stockName)) {
            System.out.println("You don't own this stock.");
            return false;
        }

        int available = holdings.get(stockName);

        if (quantity > available) {
            System.out.println("Not enough shares to sell.");
            return false;
        }

        if (quantity == available) {
            holdings.remove(stockName);
        } else {
            holdings.put(stockName, available - quantity);
        }

        System.out.println(quantity + " shares of " + stockName + " sold successfully.");
        return true;
    }

    // Display Portfolio
    public void displayPortfolio() {

        if (holdings.isEmpty()) {
            System.out.println("\nPortfolio is Empty.");
            return;
        }

        System.out.println("\n========== MY PORTFOLIO ==========");

        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
            System.out.println("Stock : " + entry.getKey());
            System.out.println("Shares: " + entry.getValue());
            System.out.println("------------------------------");
        }
    }

    // Check quantity
    public int getQuantity(String stockName) {
        return holdings.getOrDefault(stockName, 0);
    }

    public HashMap<String, Integer> getHoldings() {
        return holdings;
    }
}
