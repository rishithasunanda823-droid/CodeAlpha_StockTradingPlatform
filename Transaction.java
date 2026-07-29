import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String stockName;
    private String type; // BUY or SELL
    private int quantity;
    private double price;
    private String dateTime;

    public Transaction(String stockName, String type, int quantity, double price) {
        this.stockName = stockName;
        this.type = type;
        this.quantity = quantity;
        this.price = price;

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.dateTime = LocalDateTime.now().format(formatter);
    }

    public String getStockName() {
        return stockName;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "---------------------------------\n" +
               "Transaction Type : " + type + "\n" +
               "Stock            : " + stockName + "\n" +
               "Quantity         : " + quantity + "\n" +
               "Price            : ₹" + String.format("%.2f", price) + "\n" +
               "Date & Time      : " + dateTime + "\n" +
               "---------------------------------";
    }
}
