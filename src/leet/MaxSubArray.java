package leet;

public class MaxSubArray {

//	输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//	要求时间复杂度为O(n)。
	
//	输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//	输出: 6
//	解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
	
//	1 <= arr.length <= 10^5
//	-100 <= arr[i] <= 100
	
	public static void main(String[] args) {
		int[] test = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(test));
	}
	
	public static int maxSubArray(int[] nums) {
		int N = nums.length;
		int[] dp = new int[N];
		dp[0] = nums[0];
		int max = dp[0];
		// case1:上一个位置的最大值 + 当前值 case2: 从当前值开始，不要前面的了。
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
			max = Math.max(max, dp[i]);
		}
		return max;
    }

}
