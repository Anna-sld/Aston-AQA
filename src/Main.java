import Product.Product;

public class Main {
    public static void main(String[] args) {
        Product laptop = new Product("Ноутбук",
                "2022-03-03",
                "Linovo",
                "Китай",
                180000,
                false);
        laptop.printInfo();

    }
}