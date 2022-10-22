package leet;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		int[] nums = {3,30,34,5,9, 28};
		String largest = largestNumber(nums);
		System.out.println(largest);
	}

	/**
     * @param nums 一组非负整数
     * @return - String.compareTo() 是按照 lexicographically, 字典顺序排列的
     * - 利用compareTo, 来倒序排列 string, 刚好就得到我们要的结果.
     */
	public static String largestNumber(int[] nums) {
        int N = nums.length;
        String[] strs = new  String[N];
        for (int i = 0; i< N; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(strs[i]);
        }
        String ans = sb.toString();
        if (ans.charAt(0) == '0') {
            return "0";
        }
        return ans;
    }
}
