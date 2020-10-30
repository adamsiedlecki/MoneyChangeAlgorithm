import java.math.BigDecimal;
import java.util.List;

public class MoneyChangeUnlimitedAmount {

    private static final List<BigDecimal> coinsBanknotesDenominations = List.of(
            new BigDecimal("0.01"),
            new BigDecimal("0.02"),
            new BigDecimal("0.05"),
            new BigDecimal("0.1"),
            new BigDecimal("0.2"),
            new BigDecimal("0.5"),
            new BigDecimal("1"),
            new BigDecimal("2"),
            new BigDecimal("5"),
            new BigDecimal("10"),
            new BigDecimal("20"),
            new BigDecimal("50"),
            new BigDecimal("100"),
            new BigDecimal("200"),
            new BigDecimal("500")
    );

    public static void main(String[] args) {
        String textChange = "127.99";
        BigDecimal change = new BigDecimal(textChange);

        System.out.println("Giving change of: " + textChange);

        for (int i = coinsBanknotesDenominations.size() - 1; i >= 0; i--) {
            while (change.compareTo(coinsBanknotesDenominations.get(i)) >= 0) {
                System.out.println("\t Change: " + coinsBanknotesDenominations.get(i));
                change = change.subtract(coinsBanknotesDenominations.get(i));
            }
        }

    }
}
