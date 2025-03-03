package Product;

public class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean isReserved;

    public Product(String name, String productionDate, String manufacturer, String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void printInfo() {
        System.out.printf("Название: %s%n", name);
        System.out.printf("Дата производства: %s%n", productionDate);
        System.out.printf("Производитель: %s%n", manufacturer);
        System.out.printf("Страна происхождения: %s%n", countryOfOrigin);
        System.out.printf("Цена: %.2f%n", price);

    }
}