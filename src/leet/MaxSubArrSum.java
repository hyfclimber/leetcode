package leet;

import java.util.Stack;

public class MaxSubArrSum {

	public static void main(String[] args) {
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int ans = maxSubArray(arr);
		System.out.println(ans);
		Stack<Integer> stack = new Stack<>();
	}

	public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);//要前面的连续子数组，和不要前面的连续子数组。
            System.out.println("dp"+ i + " = " + dp[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
