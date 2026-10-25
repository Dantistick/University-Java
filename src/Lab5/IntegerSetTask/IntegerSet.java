package Lab5.IntegerSetTask;

public class IntegerSet {

    public static final int SIZE = 101;

    private final boolean[] values = new boolean[SIZE];

    public IntegerSet() { }

    public static IntegerSet union(IntegerSet a, IntegerSet b) {
        IntegerSet set = new IntegerSet();

        for (int i = 0; i < SIZE; ++i) {
            set.values[i] = a.values[i] || b.values[i];
        }

        return set;
    }

    public static IntegerSet intersection(IntegerSet a, IntegerSet b) {
        IntegerSet set = new IntegerSet();

        for (int i = 0; i < SIZE; ++i) {
            set.values[i] = a.values[i] && b.values[i];
        }

        return set;
    }

    public boolean insertElement(int k)
    {
        if(k > 100 || k < 0)
            return false;

        values[k] = true;

        return true;
    }

    public boolean deleteElement(int m)
    {
        if(m > 100 || m < 0)
            return false;

        values[m] = false;

        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < SIZE; ++i) {
            if (values[i]) {
                result.append(i).append(" ");
            }
        }

        if (result.isEmpty())
            return "---";

        return result.toString().trim();
    }

    public boolean isEqualTo(IntegerSet other) {
        for (int i = 0; i < SIZE; ++i) {
            if (values[i] != other.values[i])
                return false;
        }

        return true;
    }
}