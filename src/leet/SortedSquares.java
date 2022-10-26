package leet;

import java.util.Arrays;

public class SortedSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1, 1};
		int[] ans = sortedSquares(nums);
		int x = 1000000007;
		System.out.println(Arrays.toString(ans));

	}
	
	public static int[] sortedSquares(int[] nums) {
        //0、产生平方数组
        //1、最小值
        //2、构建新数组
        //3、从最小值向两头遍历两个子数组，随便一个完毕即完成。
        //4、谁小谁放新数组。
        //5、遍历剩下的，全部放到新数组的尾部。

        int N = nums.length;
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < N ; i++) {
            int value = nums[i] * nums[i];
            if (value < min) {
                min = value;
                minIdx = i;
            }
            nums[i] = value;
        }

        int[] ans = new int[N];
        int left = minIdx - 1; 
        int right = minIdx;
        int x = 0;
        while (left >= 0 && right < N) {
            int leftV = nums[left];
            int rightV = nums[right];
            if (leftV < rightV) {
                ans[x] = leftV;
                left--;
            } else {
                ans[x] = rightV;
                right++;
            }
            x++;
        }
        if (left >= 0) {
            for (int i = left; i >= 0; i--) {
                ans[x] = nums[i];
                x++;
            }
        }
        if (right < N) {
            for (int i = right; i < N; i++) {
                ans[x] = nums[i];
                x++;
            }
        }
        return ans;

    }

}
