package dsa.dp;

import java.util.*;
import java.util.stream.Collectors;

public class Robber {

    public static void main(String[] args) {
        int[] nums = {10,10,10,1,1,1,1,2,3,4,2,3,4,5};

//        Robber r = new Robber();
//        System.out.println(r.rob(nums));

        Map<Integer, Long> freqmap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(ele -> ele, Collectors.counting()));

        System.out.println(freqmap);


        LinkedHashMap<Integer, Long> sortedMap = freqmap.entrySet().stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(sortedMap);

    }

    public int rob(int[] houses) {

        int n = houses.length;
        if (n == 1) {
            return houses[0];
        }
        if (n == 2) {
            return Math.max(houses[0], houses[1]);
        }

//        return getMoney(nums, 0);
//        return robHouse(nums, 0, 0);

//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, -1);
//        return getMoney(nums, 0 , dp);

        return getMoney(houses, n);
    }

    public int getMoney(int[] houses, int n) {
        int[] dp = new int[n];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], houses[i] + dp[i-2]);
        }
        return dp[n-1];
    }

    public int getMoney(int[] houses, int idx, int[] dp) {
        if (idx >= houses.length) {
            return 0;
        }
        if (dp[idx] != -1)
            return dp[idx];

        int exc = getMoney(houses, idx + 1, dp);
        int inc = houses[idx] + getMoney(houses, idx + 2, dp);

        return dp[idx] = Math.max(inc, exc);
    }

    public int getMoney(int n, int[] houses, int idx) {
        if (idx >= n) {
            return 0;
        }

        int exc = getMoney(n, houses, idx + 1);
        int inc = houses[idx] + getMoney(n, houses, idx + 2);

        return Math.max(inc, exc);
    }


}
