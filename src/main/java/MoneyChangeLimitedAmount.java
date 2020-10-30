import java.math.BigDecimal;
import java.util.List;

public class MoneyChangeLimitedAmount {

    private static final List<Pair<BigDecimal, Integer>> coinsBanknotesDenominations = List.of(
            new Pair<>(new BigDecimal("0.01"), 10),
            new Pair<>(new BigDecimal("0.02"), 10),
            new Pair<>(new BigDecimal("0.05"), 2),
            new Pair<>(new BigDecimal("0.1"), 10),
            new Pair<>(new BigDecimal("0.2"), 10),
            new Pair<>(new BigDecimal("0.5"), 10),
            new Pair<>(new BigDecimal("1"), 10),
            new Pair<>(new BigDecimal("2"), 10),
            new Pair<>(new BigDecimal("5"), 10),
            new Pair<>(new BigDecimal("10"), 10),
            new Pair<>(new BigDecimal("20"), 10),
            new Pair<>(new BigDecimal("100"), 0),
            new Pair<>(new BigDecimal("200"), 10),
            new Pair<>(new BigDecimal("500"), 10)
    );

    public static void main(String[] args) {
        String textChange = "127.99";
        BigDecimal change = new BigDecimal(textChange);

        System.out.println("Giving change of: " + textChange);

        for (int i = coinsBanknotesDenominations.size() - 1; i >= 0; i--) {
            while (change.compareTo(coinsBanknotesDenominations.get(i).key) >= 0 && coinsBanknotesDenominations.get(i).value > 0) {
                System.out.println("\t Change: " + coinsBanknotesDenominations.get(i).key);
                change = change.subtract(coinsBanknotesDenominations.get(i).key);
                coinsBanknotesDenominations.get(i).value--;
            }
        }

    }

    public static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
