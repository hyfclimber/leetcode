package leet;

import java.util.ArrayList;
import java.util.HashMap;

public class Jiaoji {
//	public static int[] intersect(int[] nums1, int[] nums2) {
//		HashMap<Integer, Integer> map1 = new HashMap<>();
//        HashMap<Integer, Integer> map2 = new HashMap<>();
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int num : nums1) {
//            map1.put(num, getValue(map1, num)+1);
//        }
//        System.out.println("map1长度： " + map1.size());
//        for (int num : nums2) {
//            map2.put(num, getValue(map2, num) + 1);
//        }
//        System.out.println("map2长度： " + map2.size());
//        int xxx = 0;
//        for (HashMap.Entry entry1 : map1.entrySet()) {
//            Integer k1 = (Integer)entry1.getKey();
//            Integer v1 = (Integer)entry1.getValue();
//            for (HashMap.Entry entry2 : map2.entrySet()) {
//                Integer k2 = (Integer)entry2.getKey();
//                Integer v2 = (Integer)entry2.getValue();
//                if (k1.equals(k2)) {
//                    int length = Math.min(v1, v2);
//                    for (int i = 0; i < length; i++) {
//                        list.add(k1);
//                    }
//                    continue;
//                }
//            }
//            xxx++;
//        }
//        System.out.println(xxx);
//        int[] ans = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            ans[i] = list.get(i).intValue();
//        }
//        return ans;
//    }
//
//    
//    public static int getValue(HashMap<Integer, Integer> map, int k) {
//        if (map.get(k) == null) return 0;
//        return map.get(k);
//    }
    
	public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int N1 = nums1.length;
        int N2 = nums2.length;
        int[] nums = N1 < N2 ? nums1 : nums2;
        int[] longNums = N1 < N2 ? nums2 : nums1;
        int N = N1 < N2 ? N1 : N2;
        for (int i = 0; i < N; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[N];
        int idx = 0;
        for (int i = 0; i < longNums.length; i++) {
            int num = longNums[i];
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
            	ans[idx++] = num;
            }
            count--;
            if (count > 0){
                map.put(num, count);
            } else {
                map.remove(num);
            }
        }
        return ans;
    }
	
    public static void main(String[] args) {
    	
    	int[] nums1 = {4,9,5};
    	int[] nums2 = {9,4,9,8,4};
    	int[] ans = intersect(nums1, nums2);
    	
    	for (int i = 0; i < ans.length; i++) {
    		System.out.print(ans[i] + " ");
    	}
    	System.out.println();
		
	}

}
