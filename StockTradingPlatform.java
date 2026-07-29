import java.util.*;

public class StockTradingPlatform {

    static Scanner sc = new Scanner(System.in);

    static HashMap<String, Stock> market = new HashMap<>();
    static ArrayList<Transaction> history = new ArrayList<>();

    static Portfolio portfolio = new Portfolio();
    static User user;

    public static void main(String[] args) {

        market.put("TCS", new Stock("TCS", 3500));
        market.put("INFOSYS", new Stock("INFOSYS", 1600));
        market.put("RELIANCE", new Stock("RELIANCE", 2900));
        market.put("WIPRO", new Stock("WIPRO", 550));
        market.put("HDFC", new Stock("HDFC", 1800));

        System.out.println("==================================");
        System.out.println("   STOCK TRADING PLATFORM");
        System.out.println("==================================");

        System.out.print("Enter User Name : ");
        String name = sc.nextLine();

        user = new User(name, 100000);

        int choice;

        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Show Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Wallet Balance");
            System.out.println("6. Transaction History");
            System.out.println("7. Search Stock");
            System.out.println("8. Refresh Market");
            System.out.println("9. Exit");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    showMarket();
                    break;

                case 2:
                    buyStock();
                    break;

                case 3:
                    sellStock();
                    break;

                case 4:
                    portfolio.displayPortfolio();
                    break;

                case 5:
                    user.displayUserDetails();
                    break;

                case 6:
                    showHistory();
                    break;

                case 7:
                    searchStock();
                    break;

                case 8:
                    refreshMarket();
                    break;

                case 9:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 9);
    }
    public static void showMarket() {

    System.out.println("\n===== LIVE MARKET =====");

    for (Stock stock : market.values()) {
        System.out.println(stock);
    }
}
public static void searchStock() {

    sc.nextLine();

    System.out.print("Enter Stock Name : ");
    String name = sc.nextLine().toUpperCase();

    if (market.containsKey(name)) {
        System.out.println(market.get(name));
    } else {
        System.out.println("Stock Not Found.");
    }
}
public static void refreshMarket() {

    Random random = new Random();

    for (Stock stock : market.values()) {

        double price = stock.getPrice();

        double change = random.nextInt(401) - 200;

        stock.setPrice(price + change);
    }

    System.out.println("Market Updated Successfully.");
}
public static void buyStock() {

    sc.nextLine();

    System.out.print("Enter Stock Name : ");
    String name = sc.nextLine().toUpperCase();

    if (!market.containsKey(name)) {
        System.out.println("Stock Not Found.");
        return;
    }

    System.out.print("Enter Quantity : ");
    int quantity = sc.nextInt();

    Stock stock = market.get(name);

    double totalAmount = stock.getPrice() * quantity;

    if (user.withdraw(totalAmount)) {

        portfolio.buyStock(name, quantity);

        history.add(new Transaction(
                name,
                "BUY",
                quantity,
                stock.getPrice()));

        System.out.printf("Total Amount Paid : ₹%.2f%n", totalAmount);

    } else {

        System.out.println("Purchase Failed!");
    }
}
public static void sellStock() {

    sc.nextLine();

    System.out.print("Enter Stock Name : ");
    String name = sc.nextLine().toUpperCase();

    if (!market.containsKey(name)) {
        System.out.println("Stock Not Found.");
        return;
    }

    System.out.print("Enter Quantity : ");
    int quantity = sc.nextInt();

    if (portfolio.sellStock(name, quantity)) {

        Stock stock = market.get(name);

        double amount = stock.getPrice() * quantity;

        user.deposit(amount);

        history.add(new Transaction(
                name,
                "SELL",
                quantity,
                stock.getPrice()));

        System.out.printf("Amount Credited : ₹%.2f%n", amount);
    }
}
public static void showHistory() {

    if (history.isEmpty()) {

        System.out.println("No Transactions Yet.");
        return;
    }

    System.out.println("\n===== TRANSACTION HISTORY =====");

    for (Transaction transaction : history) {

        System.out.println(transaction);
    }
   }
}
