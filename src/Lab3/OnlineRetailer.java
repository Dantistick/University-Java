package Lab3;

import java.util.*;

public class OnlineRetailer {

    static void main() {

        Scanner scanner = new Scanner(System.in);

        List<RetailInfo> goods = new ArrayList<>();

        goods.add(new RetailInfo(2.98));
        goods.add(new RetailInfo(4.50));
        goods.add(new RetailInfo(9.98));
        goods.add(new RetailInfo(4.49));
        goods.add(new RetailInfo(6.87));

        int goodNumber = 0;

        while (true) {

            System.out.print("Введите попарно (номер товара) (колличество товара): ");
            goodNumber = scanner.nextInt();

            if (goodNumber <= 0 || goodNumber > goods.size())
                break;

            int quantity = scanner.nextInt();

           goods.get(goodNumber-1).addQuantity(quantity);
        }

        System.out.printf("%-10s %-12s %-12s %-12s%n",
                "Товар", "Цена", "Количество", "Сумма");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < goods.size(); i++) {
            RetailInfo good = goods.get(i);

            double total = good.getPrice() * good.getQuantity();

            System.out.printf("%-10d %-12.2f %-12d %-12.2f%n",
                    i + 1,
                    good.getPrice(),
                    good.getQuantity(),
                    total);
        }

    }
}