package leet;

public class MisssingNumber {

	public static void main(String[] args) {
		int[] test = {0};
		System.out.println(missingNumber(test));
	}

	public static int missingNumber(int[] nums) {
        int N = nums.length;
        if (nums[0] != 0) return 0;
        for (int i = 1; i < N; i++) {
            if (nums[i] - nums[i-1] > 1) return nums[i - 1] + 1;
        }
        return N;
    }
	
}
