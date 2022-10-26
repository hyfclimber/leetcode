package leet;

//统计一个数字在排序数组中出现的次数。
//
//示例 1:
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2
//
//示例 2:
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0


public class SearchNumTimes {

	public static void main(String[] args) {
		int[] test = {5,7,7,8,8,10};
		int ans = search(test, 5);
		System.out.println(ans);
	}
	
	public static int search(int[] nums, int target) {
		int ans = 0;
		int N = nums.length;
		int left = 0; 
		int right = N - 1;
		int targetIdx = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			int v = nums[mid];
			if (target == v) {
				targetIdx = mid;
				break;
			}else if (target > v) {
				left = left + 1;
			} else {
				right = right - 1;
			}
		}
		System.out.println("targetIdx: " + targetIdx);
		if (targetIdx >= 0) {
			ans = 1;
			for (int i = targetIdx - 1; i >=0; i--) {
				if (nums[i] != target) break;
				ans++;
			}
			System.out.println("ans: " + ans);
			for (int i = targetIdx + 1; i < N; i++) {
				if (nums[i] != target) break;
				ans++;
			}
		}
		return ans;
    }

}
