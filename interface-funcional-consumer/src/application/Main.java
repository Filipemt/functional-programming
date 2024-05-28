package application;

import model.entities.PriceUpdate;
import model.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        double factor = 1.1;

        Consumer<Product> consumer = product -> {
            product.setPrice(product.getPrice() * factor);
        };

        list.forEach(consumer);
        list.forEach(System.out::println);
    }
}