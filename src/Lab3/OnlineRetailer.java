package Lab3;

import java.util.*;

public class OnlineRetailer {

    private static final int PRODUCTS_COUNT = 5;
    private static final int SENTINEL = 0;

    static void main() {

        Scanner scanner = new Scanner(System.in);

        List<RetailInfo> goods = new ArrayList<>();

        for (int i = 1; i <= PRODUCTS_COUNT; i++)
            goods.add(new RetailInfo(getPrice(i)));

        while (true) {

            System.out.print("Введите попарно (номер товара 1-5) (количество), " + SENTINEL + " - завершить ввод: ");
            int goodNumber = scanner.nextInt();

            if (goodNumber == SENTINEL)
                break;

            int quantity = scanner.nextInt();

            if (getPrice(goodNumber) < 0) {
                System.out.println("Товара с номером " + goodNumber + " не существует.");
                continue;
            }

            goods.get(goodNumber - 1).addQuantity(quantity);
        }

        System.out.printf("%-10s %-12s %-12s %-12s%n",
                "Товар", "Цена", "Количество", "Сумма");
        System.out.println("----------------------------------------------");

        double grandTotal = 0;

        for (int i = 0; i < goods.size(); i++) {
            RetailInfo good = goods.get(i);

            double total = good.getPrice() * good.getQuantity();
            grandTotal += total;

            System.out.printf("%-10d %-12.2f %-12d %-12.2f%n",
                    i + 1,
                    good.getPrice(),
                    good.getQuantity(),
                    total);
        }

        System.out.println("----------------------------------------------");
        System.out.printf("Общая стоимость всех проданных товаров: $%.2f%n", grandTotal);
    }

    private static double getPrice(int goodNumber) {
        switch (goodNumber) {
            case 1:
                return 2.98;
            case 2:
                return 4.50;
            case 3:
                return 9.98;
            case 4:
                return 4.49;
            case 5:
                return 6.87;
            default:
                return -1;
        }
    }
}
