package Lab5.IntegerSetTask;

public class IntegerSetTest {

    static void main() {

        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        System.out.println("=== Пустые множества ===");
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        System.out.println("\n=== insertElement ===");

        set1.insertElement(1);
        set1.insertElement(5);
        set1.insertElement(10);

        System.out.println("Set 1: " + set1);

        System.out.println("Добавление -1: " + set1.insertElement(-1));
        System.out.println("Добавление 101: " + set1.insertElement(101));

        set2.insertElement(5);
        set2.insertElement(10);
        set2.insertElement(20);

        System.out.println("\nSet 2: " + set2);

        System.out.println("\n=== union ===");

        IntegerSet union = IntegerSet.union(set1, set2);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Union: " + union);

        System.out.println("\n=== intersection ===");

        IntegerSet intersection = IntegerSet.intersection(set1, set2);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Intersection: " + intersection);

        System.out.println("\n=== isEqualTo ===");

        IntegerSet set3 = new IntegerSet();

        set3.insertElement(1);
        set3.insertElement(5);
        set3.insertElement(10);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 3: " + set3);
        System.out.println("Set 1 == Set 3: " + set1.isEqualTo(set3));
        System.out.println("Set 1 == Set 2: " + set1.isEqualTo(set2));

        System.out.println("\n=== deleteElement ===");

        System.out.println("До удаления: " + set1);

        set1.deleteElement(5);

        System.out.println("После удаления 5: " + set1);

        System.out.println("Удаление -1: " + set1.deleteElement(-1));
        System.out.println("Удаление 101: " + set1.deleteElement(101));

        System.out.println("\n=== Итоговое множество ===");
        System.out.println("Set 1: " + set1);
        System.out.println("Set 3: " + set3);
        System.out.println("Set 1 == Set 3: " + set1.isEqualTo(set3));
    }
}