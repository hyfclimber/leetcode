package leet;

public class ArrMiddleIdx {

	public static void main(String[] args) {
		int[] arr = {1, 7, 3, 6, 5, 6};
		int ans = pivotIndex(arr);
		System.out.println(ans);
	}
	
	public static int pivotIndex(int[] nums) {
        int N = nums.length;
        if (N == 1) return 0;
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];

        dp1[0] = nums[0];
        dp2[N - 1] = nums[N - 1];

        for (int i = 1; i < N; i++) {
            dp1[i] = dp1[i - 1] + nums[i];
        }
        for (int i = N - 2; i >= 0; i--) {
            dp2[i] = dp2[i + 1] + nums[i];
        }

        if (dp2[1] == 0) return 0;
        for (int i = 0; i < N - 2; i++) {
            int leftSum = dp1[i];
            int rightSum = dp2[i + 2]; //左边(i + 1) + 右边j+1个 + 中间1个 = N  所以要减3
            if (leftSum == rightSum) return i + 1;
        }
        if (dp1[N - 2] == 0) return N - 1;
        return -1;
    }

}
