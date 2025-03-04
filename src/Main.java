import Product.Product;
import Park.Park;

public class Main {
    public static void main(String[] args) {
        Product laptop = new Product("Ноутбук",
                "2022-03-03",
                "Linovo",
                "Китай",
                180000,
                false);
        laptop.printInfo();

        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S10 plus", "03.10.2017", "Samsung", "Korea", 170000, true);
        productsArray[1] = new Product("Samsung S23", "11.08.2020", "Samsung", "Korea", 210000, true);
        productsArray[2] = new Product("Samsung S20", "03.09.2019", "Samsung", "Korea", 200000, true);
        productsArray[3] = new Product("Samsung S24", "01.09.2021", "Samsung", "Korea", 230000, false);
        productsArray[4] = new Product("Samsung S23 plus", "10.03.2021", "Samsung", "Korea", 220000, true);

        for (Product product : productsArray) {
            product.printInfo();
            System.out.println();
        }

        printPark();
    }

    private static void printPark() {
        Park myPark = new Park("Парк аттракционов");

        Park.Attraction carousel = myPark.new Attraction("Карусель", "12:00 - 17:00", 1250);
        Park.Attraction roomFear = myPark.new Attraction("Комната страха", "12:00 - 17:00", 1450);

        carousel.showInfo();
        roomFear.showInfo();
    }
}
