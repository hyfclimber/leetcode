package leet;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
//		int[] nums = {-1,2,1,-4};
		int[] nums = {0,0,0};
		int target = 1;
		int ans = threeSumClosest(nums, target);
		System.out.println(ans);
	}
	
	public static int threeSumClosest(int[] nums, int target) {
        int N = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < N - 2; i++) { //第一个数
            int L = i + 1; 
            int R = N - 1;
            int cur = nums[i];
            while (L < R) {
                int res = nums[L] + nums[R] + cur;
                int abs = Math.abs(res - target);
                if (Math.abs(res - target) < min) {
                    min = abs;
                    ans = res;
                    System.out.println("min: " + min + " ans: " + ans);
                }
                L++;
                R--;
            }
        }
        return ans;
    }

}
