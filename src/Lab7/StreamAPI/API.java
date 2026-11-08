package Lab7.StreamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class API {

    static void main() {

        List<User> users = new ArrayList<>();

        users.add(new User("Lesha", 22, "Calarasi", List.of(Tags.sport, Tags.gaming, Tags.music)));
        users.add(new User("Alesha", 16, "Chisinau", List.of(Tags.travel, Tags.sport)));
        users.add(new User("Aleksei", 9, "Cahul", List.of(Tags.music, Tags.travel)));
        users.add(new User("Leshik", 25, "Calarasi", List.of(Tags.music, Tags.gaming, Tags.movie)));
        users.add(new User("Maria", 31, "Berlin", List.of(Tags.travel, Tags.movie)));
        users.add(new User("Ivan", 45, "Chisinau", List.of(Tags.sport)));
        users.add(new User("Elena", 13, "Balti", List.of(Tags.gaming, Tags.music)));
        users.add(new User("Hans", 38, "Berlin", List.of(Tags.sport, Tags.travel)));
        users.add(new User("Olga", 18, "Cahul", List.of(Tags.movie)));
        users.add(new User("Dima", 7, "Balti", List.of(Tags.gaming)));
        users.add(new User("Anna", 52, "Berlin", List.of(Tags.music, Tags.travel)));
        users.add(new User("Victor", 17, "Chisinau", List.of(Tags.sport, Tags.gaming)));

        // ---------------- filter ----------------
        List<User> adults = users.stream()
                .filter(user -> user.getAge() > 18)
                .toList();
        print("Пользователи старше 18", adults);

        List<User> berlinUsers = users.stream()
                .filter(user -> user.getCity().equals("Berlin"))
                .toList();
        print("Пользователи из Berlin", berlinUsers);

        List<User> sportUsers = users.stream()
                .filter(user -> user.getTags().contains(Tags.sport))
                .toList();
        print("Пользователи с тегом sport", sportUsers);

        // ---------------- sorted ----------------
        List<User> ageSorting = users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .toList();
        print("Сортировка по возрасту", ageSorting);

        List<User> nameSorting = users.stream()
                .sorted(Comparator.comparing(User::getName))
                .toList();
        print("Сортировка по имени", nameSorting);

        List<User> cityNameSorting = users.stream()
                .sorted(Comparator.comparing(User::getCity)
                        .thenComparing(User::getName))
                .toList();
        print("Сортировка по городу, затем по имени", cityNameSorting);

        // ---------------- map ----------------
        List<String> names = users.stream()
                .map(User::getName)
                .toList();
        System.out.println("\n=== Имена ===\n" + names);

        List<Integer> nameLengths = users.stream()
                .map(user -> user.getName().length())
                .toList();
        System.out.println("\n=== Длины имён ===\n" + nameLengths);

        List<Tags> uniqueTags = users.stream()
                .flatMap(user -> user.getTags().stream())
                .distinct()
                .toList();
        System.out.println("\n=== Уникальные теги ===\n" + uniqueTags);

        // ---------------- groupingBy ----------------
        Map<String, List<User>> byCity = users.stream()
                .collect(Collectors.groupingBy(User::getCity));
        System.out.println("\n=== Группировка по городу ===");
        byCity.forEach((city, list) -> System.out.println(city + " -> " + list));

        Map<String, List<User>> byAgeCategory = users.stream()
                .collect(Collectors.groupingBy(API::ageCategory));
        System.out.println("\n=== Группировка по возрастной категории ===");
        byAgeCategory.forEach((category, list) -> System.out.println(category + " -> " + list));

        // ---------------- reduce ----------------
        int totalAge = users.stream()
                .map(User::getAge)
                .reduce(0, Integer::sum);

        double averageAge = (double) totalAge / users.size();

        Optional<User> oldestByReduce = users.stream()
                .reduce((a, b) -> a.getAge() >= b.getAge() ? a : b);

        Optional<User> oldestByMaxBy = users.stream()
                .max(Comparator.comparingInt(User::getAge));

        Optional<User> youngest = users.stream()
                .min(Comparator.comparingInt(User::getAge));

        System.out.println("\n=== reduce ===");
        System.out.println("Суммарный возраст: " + totalAge);
        System.out.printf("Средний возраст: %.2f%n", averageAge);
        System.out.println("Самый старший (reduce): " + oldestByReduce.orElse(null));
        System.out.println("Самый старший (maxBy): " + oldestByMaxBy.orElse(null));
        System.out.println("Самый молодой (minBy): " + youngest.orElse(null));
    }

    private static String ageCategory(User user) {
        if (user.getAge() <= 12)
            return "child";

        if (user.getAge() <= 17)
            return "teen";

        return "adult";
    }

    private static void print(String title, List<User> users) {
        System.out.println("\n=== " + title + " ===");
        users.forEach(System.out::println);
    }
}
