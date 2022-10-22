package leet;

import java.util.HashMap;
import java.util.Map;

public class SearchInsert {

	public static void main(String[] args) {
//		Map a = new HashMap<>();
//		Map x = a;
//		Map y = a;
//		System.out.println(x == y);
		
		int[] nums = {1, 3, 5, 6};
		int ans = searchInsert(nums, 2);
		System.out.println(ans);
	}
	
	public static int searchInsert(int[] nums, int target) {
        int N = nums.length;
        int left = 0;
        int right = N - 1;
        int mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return mid;

    }

}
