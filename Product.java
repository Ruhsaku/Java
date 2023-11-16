public abstract class Product {
    private int inventoryNumber;
    private double price;
    private int quantity;
    private Provider provider;

    public Product(int inventoryNumber, double price, int quantity, Provider provider) throws WrongPhoneNumberException{
        this.inventoryNumber = inventoryNumber;
        this.price = price;
        this.quantity = quantity;
        this.provider = provider;
    }

    public abstract double getPromotionalPrice(int percent);
    public abstract boolean sellProduct(int piece) throws NoMoreProductsException;

    public int getInventoryNumber() {
        return inventoryNumber;
    }
    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Provider getProvider() {
        return provider;
    }
    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
