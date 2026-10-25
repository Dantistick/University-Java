package Lab2.Invoice;

public class InvoiceTest {

     static void main() {

        Invoice invoice = new Invoice(
                "12345",
                "Молоток",
                2,
                15.50
        );

        System.out.println("Номер детали: " + invoice.getPartNumber());
        System.out.println("Описание: " + invoice.getDescription());
        System.out.println("Количество: " + invoice.getQuantity());
        System.out.println("Цена за единицу: " + invoice.getPricePerItem());
        System.out.println("Сумма счёта: " + invoice.getInvoiceAmount());

        invoice.setQuantity(-5);
        invoice.setPricePerItem(-10);

        System.out.println();
        System.out.println("После установки отрицательных значений:");
        System.out.println("Количество: " + invoice.getQuantity());
        System.out.println("Цена за единицу: " + invoice.getPricePerItem());
        System.out.println("Сумма счёта: " + invoice.getInvoiceAmount());
    }

}
