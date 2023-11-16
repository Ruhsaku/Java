public class Book extends Product{
    String author;
    String title;

    public Book(int inventoryNumber, double price, int quantity, Provider provider,
                String author, String title) throws WrongPhoneNumberException {
        super(inventoryNumber, price, quantity, provider);
        this.author = author;
        this.title = title;
    }

    @Override
    public double getPromotionalPrice(int percent) {
        return getPrice() * 0.5;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
