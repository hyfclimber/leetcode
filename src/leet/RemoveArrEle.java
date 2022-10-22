package leet;

public class RemoveArrEle {

	public static void main(String[] args) {
		int[] arr = {3,2,2,3};
		int ans = removeElement(arr, 3);
		System.out.println(ans);
	}

	public static int removeElement(int[] nums, int val) {

		int left = 0;
		int right = nums.length - 1;
		int length = nums.length;
		int tmp = 0;
		while (left <= right) {
			if (nums[right] == val) {
				length--;
				right--;
			} else {
				if (nums[left] == val) {
					tmp = nums[left];
					nums[left] = nums[right];
					nums[right] = tmp;
					right--;
					length--;
				}
				left++;
			}
		}
		return length;
	}
}
