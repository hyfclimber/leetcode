package leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArrayJiaoji {

	public static void main(String[] args) {
		int[] nums1 = {4,7,9,7,6,7};
		int[] nums2 = {5,0,0,6,1,6,2,2,4};
		int[] ans = intersection(nums1, nums2);
		System.out.println(Arrays.toString(ans));
		
	}
	
	public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ans = new HashSet<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            int ele = nums2[i];
            if (set.contains(ele)) {
                ans.add(ele);
            }
        }
        int[] ansArr = new int[ans.size()];
        int i = 0;
        Iterator it = ans.iterator();
        while(it.hasNext()) {
            ansArr[i] = (Integer)it.next();
            i++;
        }
        return ansArr;
    }

}
