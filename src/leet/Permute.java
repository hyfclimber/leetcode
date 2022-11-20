package leet;

import java.util.ArrayList;
import java.util.List;

public class Permute {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		List<List<Integer>> ans = permute(nums);
		System.out.println(ans);
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			List<Integer> l = new ArrayList<>();
			l.add(nums[i]);
			dfs(nums, 0, l);
			ans.add(l);
		}
		return ans;

	}
	
	public static void dfs (int[] nums, int i, List<Integer> list) {
		int N = nums.length;
		if (i == N) return;
		if (i < N) {
			if (!list.contains(nums[i])) {
				list.add(nums[i]);
			}
			dfs(nums, i + 1, list);
		}
	}

}
