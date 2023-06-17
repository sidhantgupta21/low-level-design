package dsa.dp;

public class knapsack01 {

    public static void main(String[] args) {
        int W = 10;
        int n = 3;
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 6};
//        int maxVal = recursion(W, n-1, wt, val);

        int[][] dp = new int[n][W+1];
//        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
            for (int w = 0; w < W+1; w++) {
                dp[i][w] = -1;
            }
        }
        int maxVal = dpRecur(W, n-1, wt, val, dp);
        System.out.println("maxVal = " + maxVal);

        maxVal = bottomUp(W, n, wt, val);
        System.out.println("maxVal = " + maxVal);
    }

    static int recursion(int cw, int idx, int[] wt, int[] val) {
        if (idx < 0) {
            return 0;
        }

        //dont pick
        int ans = recursion(cw, idx - 1, wt, val);

//        if (cw < 0) {
//            return ans;
//        }

        //pick
        final int remWt = cw - wt[idx];
        if (remWt >= 0) {
            ans = Math.max(ans, val[idx] + recursion(remWt, idx - 1, wt, val));
        }

//        ans = Math.max(ans, val[ind] + recursion(cw - wt[ind], ind - 1, wt, val));


        return ans;
    }

    static int dpRecur(int remWt, int eleInd, int[] wt, int[] val, int[][] dp) {
        if (eleInd < 0) {
            return 0;
        }
        if (dp[eleInd][remWt] != -1) {
            return dp[eleInd][remWt];
        }

        //dont pick
        int dontPick = dpRecur(remWt, eleInd - 1, wt, val, dp);

        //pick
        int pick = 0;
        if (remWt - wt[eleInd] >= 0) {
            pick = val[eleInd] + dpRecur(remWt - wt[eleInd], eleInd - 1, wt, val, dp);
        }

        dp[eleInd][remWt] = Math.max(dontPick, pick);
        return dp[eleInd][remWt];
    }

    static int bottomUp(int W, int n, int[] wt, int[] val) {
        int[][] dp = new int[n+1][W+1];

        for (int eleInd = 1; eleInd <= n; eleInd++) {
            for (int wtIdx = 1; wtIdx <= W; wtIdx++) {
                //dont pick
                int dontPick = dp[eleInd-1][wtIdx];

                //pick
                int pick = 0;
                if (wtIdx - wt[eleInd-1] >= 0) {
                    pick = val[eleInd-1] + dp[eleInd - 1][wtIdx - wt[eleInd-1]];
                }

                dp[eleInd][wtIdx] = Math.max(pick, dontPick);
            }
        }

        return dp[n][W];
    }
}
