package Lab3;

public class RetailInfo {
    private int quantity = 0;
    private double price;

    public RetailInfo(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
}