package dsa.dp;

// https://leetcode.com/problems/decode-ways/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DecodeWays {

    private static final HashMap<Integer, Character> alphabet = new HashMap<>();
    static  {
        for (int i = 1; i<=26; i++) {
            alphabet.put(i, (char) (i + 64));
        }
    }

    public int numDecodings(String s) {
        List<String> res = new ArrayList<>();
        helper(s, res, 0 , "");
        System.out.println(res);
        return  res.size();
    }

    void helper (String s, List<String> res, int index, String curr) {
        if (index >= s.length()) {
            res.add(curr);
            return;
        }

        if (s.charAt(index) == '0') {
            return;
        }

        int a = Integer.parseInt(s.substring(index, index + 1));
        helper(s, res, index + 1, curr + alphabet.get(a));

        if (index < s.length() - 1) {
            int b = Integer.parseInt(s.substring(index, index + 2));
            if (b <= 26) {
                helper(s, res, index + 2, curr + alphabet.get(b));
            }
        }
    }

    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
//        System.out.println(d.numDecodings("123168"));
        System.out.println(d.helper2("10", 0));
    }

    int helper2(String s, int index) {

        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        //single
        int ans = helper2(s, index + 1);

        //double
        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ans += helper2(s, index + 2);
        }

        return ans;
    }

}
