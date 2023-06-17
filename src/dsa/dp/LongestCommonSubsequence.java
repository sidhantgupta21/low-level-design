package dsa.dp;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        System.out.println(new LongestCommonSubsequence().lcsLength(s1, s2));
    }

    int lcsLength(String s1, String s2) {

        // recursion
        //return recur(s1, s2, 0 ,0);

        //memoization
//        int[][] dp = new int[s1.length()][s2.length()];
//        for (int i = 0; i < s1.length(); i++)
//            for(int j = 0; j < s2.length(); j++)
//                dp[i][j] = -1;
//        return memoization(s1, s2, 0, 0, dp);

        //bottomup
        return bottomUp(s1, s2);
    }

    int recur(String s1, String s2, int index1, int index2) {
        if (s1.length() == index1 || s2.length() == index2) {
            return 0;
        }

        if (s1.charAt(index1) == s2.charAt(index2)) {
            return 1 + recur(s1, s2, index1 + 1, index2 + 1);
        }

        return Math.max(recur(s1, s2, index1 + 1, index2), recur(s1, s2, index1, index2 + 1));
    }

    int memoization(String s1, String s2, int index1, int index2, int[][] dp) {
        if (s1.length() == index1 || s2.length() == index2) {
            return 0;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }
        if (s1.charAt(index1) == s2.charAt(index2)) {
            dp[index1][index2] = 1 + memoization(s1, s2, index1 + 1, index2 + 1, dp);
        } else {
            dp[index1][index2] = Math.max(memoization(s1, s2, index1 + 1, index2, dp),
                    memoization(s1, s2, index1, index2 + 1, dp));
        }
        return dp[index1][index2];
    }

    int bottomUp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for(int i = 1; i<= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
