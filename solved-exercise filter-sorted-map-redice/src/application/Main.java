/*
Program to read one set of products from one
file in .csv format (assume there is at least one product).
Then show the average price of the products. Then show the
names, in descending order, of products that have a price
lower than average price
 */

package application;

import model.entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("Enter a full file path: ");
        String path = scanner.nextLine();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            List<Product> list = new ArrayList<>();

            String line = bufferedReader.readLine();
            while(line != null) {
                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));

                line = bufferedReader.readLine();
            }

            double avarage = list.stream()
                    .map(p -> p.getPrice())
                    .reduce(0.0, (x,y) -> x+y) / list.size();

            System.out.println("Avarage price: " + String.format("%.2f", avarage));

        } catch (IOException e ) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
