package leet;

public class SearchCycle {

	public static void main(String[] args) {
//		int[] nums = {4,5,6,7,0,1,2};
//		int target = 0;
		int[] nums = {1};
		int target = 0;
		int ans = search(nums, target);
		System.out.println(ans);
	}
	
	public static int search(int[] nums, int target) {
		int N = nums.length;
		if (N == 1) {
			return nums[0]  == target ? 0 : -1;
		}
		int head = nums[0];
		int tail = nums[N - 1];
		if (head < tail) { //没旋转
			int L = 0; 
			int R = N - 1;
			return searchIdx(nums, target, L, R);
			
		} else { 
			int middle = 0;
			int L = 0; 
			int R = N - 1;
			while (L <= R) {
				int mid = (L + R) / 2;
				if (mid < N - 1 && nums[mid] > nums[mid + 1]) { //找到了分割点
					middle = mid;
					break;
				} else {
					if (nums[mid] > tail) {
						L = mid + 1;
					}
					if (nums[mid] < head) {
						R = mid - 1;
					}
				}
			}
			L = 0;
			R = middle;
			int ans = searchIdx(nums, target, L, R);
			if (ans != -1) return ans; 
			L = middle + 1;
			R = N - 1;
			return searchIdx(nums, target, L, R);
		}
    }
	
	public static int searchIdx(int[] nums, int target, int L, int R) {
		while (L <= R) {
			int mid = (L + R) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return -1;
	}

}
