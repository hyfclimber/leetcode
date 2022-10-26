package leet;

import java.util.Arrays;

public class ExchangeOddEven {
//	输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {0,0,3,3,3,3,3,1,4};
		int[] ans = exchange(test);
		System.out.println(Arrays.toString(ans));
	}

	public static int[] exchange(int[] nums) {
		int N = nums.length;
		int[] ans = new int[N];
		int left = 0;
		int right = N - 1;
		for (int i = 0; i < N; i++) {
			int v = nums[i];
			if (v % 2 == 0) {
				ans[right] = v;
				right--;
			} else {
				ans[left] = v;
				left++;
			}
		}
		return ans;
    }
}
