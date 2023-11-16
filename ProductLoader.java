import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ProductLoader implements ImportData {
    private static final String FILE_PATH = "salesproducts.txt";

    @Override
    public Object[] importDataFromFile() throws IOException, WrongPhoneNumberException {
        int numberOfRows = getNumberOfRows();

        Object[] products = new Object[numberOfRows];

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int index = 0;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("#");

                if (data.length > 0) {
                    int objectType = Integer.parseInt(data[0]);
                    if (objectType == 1) {
                        // Electronics
                        products[index] = new Electronics(
                                Integer.parseInt(data[3]),
                                Double.parseDouble(data[4]),
                                Integer.parseInt(data[5]),
                                new Provider(data[1], data[2]), data[6], data[7]);
                    } else if (objectType == 2) {
                        // Book
                        products[index] = new Book(
                                Integer.parseInt(data[3]),
                                Double.parseDouble(data[4]),
                                Integer.parseInt(data[5]),
                                new Provider(data[1], data[2]), data[6], data[7]);
                    }
                    index++;
                }
            }
        }

        return products;
    }

    public int getNumberOfRows() throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            while (reader.readLine() != null) {
                count++;
            }
        }
        return count;
    }
}