package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissNum {

	
	public static void main(String[] args) {
		int[] nums = {2,2,2,2,2};
		List ans = findDisappearedNumbers(nums);
		System.out.println(ans);
	}

	
	
    public static List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> ans = new ArrayList<Integer>();
    	int N = nums.length;
        Arrays.sort(nums);
        if (nums[0] > 1) {
            int delta = nums[0] - 1;
            for (int j = 1; j <= delta; j++) {
                if (!ans.contains(j)) {
                    ans.add(j);
                }
                
            }
        }
        if (nums[N - 1] < N) {
            int delta = N - nums[N - 1];
            for (int j = 1; j <= delta; j++) {
                int num = nums[N - 1] + j;
                if (!ans.contains(num)) {
                    ans.add(num);
                }
                
            }
        }
        for (int i = 1; i < N; i++) {
            int delta = nums[i] - nums[i - 1];
            if (delta > 1) {
                for (int j = 1; j < delta; j++) {
                    int num = nums[i - 1] + j;
                    if (!ans.contains(num)) {
                        ans.add(num);
                    }
                }
            }
        }
        return ans;
    }
}
