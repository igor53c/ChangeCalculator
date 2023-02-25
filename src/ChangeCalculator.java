import java.util.*;

public class ChangeCalculator {
    private final List<Integer> coins;

    public ChangeCalculator(List<Integer> coins) {
        this.coins = coins;
    }

    public List<Integer> computeMostEfficientChange(Integer amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (amount == 0) {
            return new ArrayList<>();
        }
        if (!canSplitIntoValue(amount)) {
            throw new IllegalArgumentException("Coins cannot be split into the value");
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int i = amount;
        while (i > 0) {
            for (int j = coins.size() - 1; j >= 0; j--) {
                int coin = coins.get(j);
                if (i - coin >= 0 && dp[i - coin] + 1 == dp[i]) {
                    result.add(coin);
                    i -= coin;
                    break;
                }
            }
        }

        Collections.sort(result);

        return result;
    }

    private boolean canSplitIntoValue(int value) {

        if (coins.size() == 1) {
            return value % coins.get(0) == 0;
        }

        for (Integer coin : coins) {
            if (coin == value) {
                return true;
            } else if (coin > value) {
                return false;
            } else {
                if (canSplitIntoValue(value - coin)) {
                    return true;
                }
            }
        }

        return false;
    }
}
