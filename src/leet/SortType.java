package leet;

import java.util.Arrays;

public class SortType {

	public static void main(String[] args) {
		int[] nums = {1,0, 1,1,1,1,2,0,2,1,1,0,0,0,0};
		sortColors2(nums);
		System.out.println(Arrays.toString(nums));
	}

	public void sortColors(int[] nums) {
        int redNum = 0, whiteNum = 0, blueNum = 0;
        int N = nums.length;
        for (int i = 0; i< N; i++) {
            if (nums[i] == 0) {
                redNum++;
            } else if(nums[i] == 1) {
                whiteNum++;
            } else {
                blueNum++;
            }
        }
        for (int i = 0; i < N; i++) {
            if (i < redNum) {
                nums[i] = 0;
            } else if (i < redNum + whiteNum) {
                nums[i] = 1; 
            } else {
                nums[i] = 2;
            }
        }
    }
	
	public static void sortColors2(int[] nums) {
        int N = nums.length;
        int left = 0, right = N - 1;
        for (int i = 0; i < N; i++) {
            if (nums[i] == 0 && left <= i) {
                swap(nums, left, i);
                left++;
            } else if(nums[i] == 2 && right >= i) {
                swap(nums, right, i);
                right--;
                i--;
            } 
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
