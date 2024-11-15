package application;

import model.entities.Product;
import model.entities.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        double min = 100.0;

        // Predicate<Product> predicate = product -> product.getPrice() >= min;

        list.removeIf(product -> product.getPrice() >= min);

        list.forEach(System.out::println);
    }
}