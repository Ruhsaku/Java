public class Electronics extends Product{
    String manufacturer;
    String model;

    public Electronics(int inventoryNumber, double price, int quantity, Provider provider,
                       String manufacturer, String model) throws WrongPhoneNumberException {
        super(inventoryNumber, price, quantity, provider);
        this.manufacturer = manufacturer;
        this.model = model;
    }

    @Override
    public double getPromotionalPrice(int percent) {
        return getPrice() * 0.9;
    }

    @Override
    public boolean sellProduct(int piece) throws NoMoreProductsException {
        if (getQuantity() >= piece) {
            setQuantity(getQuantity() - piece);
            return true;
        } else {
            throw new NoMoreProductsException();
        }
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
