package dsa.dp;

import java.util.*;

public class Subset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper2(nums, ans, new ArrayList<>(), 0);

//        Collections.sort(ans, Comparator.comparingInt(List::size));

        return ans;
    }

    public void helper(int[] nums, List<List<Integer>> ans, List<Integer> temp, int index) {
        if (nums.length == index) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        helper(nums, ans, temp, index + 1);

        //include
        temp.add(nums[index]);
        helper(nums, ans, temp, index + 1);

        //exclude
        temp.remove(temp.size() - 1);
        helper(nums, ans, temp, index + 1);
    }

    public void helper2(int[] nums, List<List<Integer>> ans, List<Integer> temp, int index) {

        ans.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            helper2(nums, ans, temp, i+1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subset s = new Subset();
        int[] nums = {1,2,3};
        System.out.println(s.subsets(nums));

//        String orig = "abc";
//        System.out.println(s.subSequences(orig));
    }

    List<String> subSequences(String orig) {
        List<String> ans = new ArrayList<>();
        helperString(orig, "", 0, ans);
        return ans;
    }

    void helperString(String orig, String curr, int index, List<String> ans) {
        if (orig.length() == index) {
            ans.add(curr);
            return;
        }

        helperString(orig, curr, index + 1, ans);
        helperString(orig, curr + orig.charAt(index), index + 1, ans);


    }

}
