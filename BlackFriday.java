import java.io.IOException;
public class BlackFriday {
    private static Electronics[] electronicsArray;
    private static Book[] bookArray;

    public static void processSales() {
        try {
            ProductLoader productLoader = new ProductLoader();
            Object[] products = productLoader.importDataFromFile();

            separateProducts(products);

            System.out.println("Electronics for Black Friday:");
            for (Electronics electronics : electronicsArray) {
                System.out.println("Model: " + electronics.getModel() + ", Price: " + electronics.getPrice());
            }

            System.out.println("\nBooks for Black Friday:");
            for (Book book : bookArray) {
                System.out.println("Title: " + book.getTitle() + ", Price: " + book.getPrice());
            }

        } catch (IOException | WrongPhoneNumberException e) {
            e.printStackTrace();
        }
    }
    private static void separateProducts(Object[] products) {
        int electronicsCount = 0;
        int bookCount = 0;

        for (Object product : products) {
            if (product instanceof Electronics) {
                electronicsCount++;
            } else if (product instanceof Book) {
                bookCount++;
            }
        }

        electronicsArray = new Electronics[electronicsCount];
        bookArray = new Book[bookCount];

        int electronicsIndex = 0;
        int bookIndex = 0;
        for (Object product : products) {
            if (product instanceof Electronics) {
                electronicsArray[electronicsIndex++] = (Electronics) product;
            } else if (product instanceof Book) {
                bookArray[bookIndex++] = (Book) product;
            }
        }
    }
}