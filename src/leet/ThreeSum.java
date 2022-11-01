package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> ans = threeSum(nums);
		System.out.println(ans);

	}


public static List<List<Integer>> threeSum(int[] nums) {
	int N = nums.length;
	List<List<Integer>> ans = new ArrayList<>();
	Arrays.sort(nums);
	for (int i = 0; i < N; i++) {
		if (nums[i] > 0) return ans;
		if (i > 0 && nums[i] == nums[i - 1]) continue; //如果和上一个的值相同，则略过。去重！
		int L = i + 1;
		int R = N - 1;
		int cur = nums[i];
		while (L < R) {
			int res = cur + nums[L] + nums[R];
			if (res == 0) {
				List<Integer> l = new ArrayList<>();
				l.add(cur);
				l.add(nums[L]);
				l.add(nums[R]);
				ans.add(l);
				while (L < R && nums[L] == nums[L + 1]) {
					L = L + 1;
				}
				while (L < R && nums[R] == nums[R - 1]) {
					R = R - 1;
				}
				L = L + 1;
				R = R - 1;
			} else if (res > 0) {
				R = R - 1;
			} else {
				L = L + 1;
			}
		}
		
	}
	return ans;
}

public static List<List<Integer>> threeSum2(int[] nums) {
    List<List<Integer>> lists = new ArrayList<>();
    //排序
    Arrays.sort(nums);
    //双指针
    int len = nums.length;
    for(int i = 0;i < len;++i) {
        if(nums[i] > 0) return lists;

        if(i > 0 && nums[i] == nums[i-1]) continue;

        int curr = nums[i];
        int L = i+1, R = len-1;
        while (L < R) {
            int tmp = curr + nums[L] + nums[R];
            if(tmp == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(curr);
                list.add(nums[L]);
                list.add(nums[R]);
                lists.add(list);
                while(L < R && nums[L+1] == nums[L]) ++L;
                while (L < R && nums[R-1] == nums[R]) --R;
                ++L;
                --R;
            } else if(tmp < 0) {
                ++L;
            } else {
                --R;
            }
        }
    }
    return lists;
}

//去补了重，或者取了重，里面的也不支持同值了。比如[-1,-1,2] 显示为[-1, 2]
	public static List<List<Integer>> threeSum1(int[] nums) {
		int N = nums.length;
		List<List<Integer>> ans = new ArrayList<>();
		Set<List<Integer>> setAns = new HashSet<>(); 
		for (int i = 0; i < N; i++) {
			int target = nums[i];
			Set<List<Integer>> subAns = twoSum(nums, -target, i);
			setAns.addAll(subAns);
		}
		for (List<Integer> l : setAns) {
			ans.add(l);
		}
		return ans;
	}

	public static Set<List<Integer>> twoSum(int[] nums, int target, int exceptIdx) {
		int N = nums.length;
		Set<List<Integer>> ans = new HashSet<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			if (i == exceptIdx) continue;
			List<Integer> sub = new ArrayList<>();
			sub.add(-target);
			int n = nums[i];
			if (set.contains(n)) {
				set.add(n);
				sub.add(n);
				sub.add(target - n);
				ans.add(sub);
			} else {
				set.add(target - n);
			}
		}
		return ans;
	}

}
