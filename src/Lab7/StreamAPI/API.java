package Lab7.StreamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class API {

    static void main() {

        List<User> users = new ArrayList<>();

        users.add(new User("Lesha", 22, "Calarasi", List.of(
                Tags.sport,
                Tags.gaming,
                Tags.music
                ))
        );
        users.add(new User("Alesha", 16, "Chisinau", List.of(
                Tags.travel,
                Tags.sport
                ))
        );
        users.add(new User("Aleksei", 9, "Cahul", List.of(
                Tags.music,
                Tags.travel
                ))
        );
        users.add(new User("Leshik", 25, "Calarasi", List.of(
                Tags.music,
                Tags.gaming,
                Tags.movie
                ))
        );

        // filter
        List<User> adults = users.stream()
                .filter(user -> user.getAge() > 18)
                .toList();

        List<User> calarasiUsers = users.stream()
                .filter(user -> user.getCity().equals("Calarasi"))
                .toList();

        List<User> sportTags = users.stream()
                .filter(user -> user.getTags().contains(Tags.sport))
                .toList();

        // sorting
        List<User> ageSorting = users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .toList();

        List<User> nameSorting = users.stream()
                .sorted(Comparator.comparing(User::getName))
                .toList();

        List<User> cityNameSorting = users.stream()
                .sorted(Comparator.comparing(User::getCity)
                        .thenComparing(User::getName))
                .toList();

        // map
        List<String> names = users.stream()
                .map(User::getName)
                .toList();

        List<Integer> nameLength = users.stream()
                .map(user -> user.getName().length())
                .toList();

        List<Integer> uni = users.stream()
                .flatMap()
                .toList();
    }
}
