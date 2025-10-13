package DP.Questions;

public class NumberOfPeopleAware {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1000000007;
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 1; i <= n; i++) {
            int people = dp[i];

            int start = i + delay;
            int end = Math.min(n, i + forget - 1);

            for (int j = start; j <= end; j++) {
                dp[j] = (dp[j] + people) % MOD;
            }
        }

        int days = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            days = (days + dp[i]) % MOD;
        }

        return days;
    }
}
