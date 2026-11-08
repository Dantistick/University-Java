package Lab7.Storage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Storage<T> {

    private final List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public List<T> filter(Predicate<T> predicate) {
        return items.stream()
                .filter(predicate)
                .toList();
    }

    public Optional<T> find(Predicate<T> predicate) {
        return items.stream()
                .filter(predicate)
                .findFirst();
    }

    public List<T> sort(Comparator<T> comparator) {
        return items.stream()
                .sorted(comparator)
                .toList();
    }

    public boolean remove(Predicate<T> predicate) {
        return items.removeIf(predicate);
    }
}
