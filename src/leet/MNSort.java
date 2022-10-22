package leet;

import java.util.Arrays;

public class MNSort {

	public static void main(String[] args) {

//		int[] nums1 = {0,0,3,0,0,0,0,0,0};
//		int[] nums2 = {-1,1,1,1,2,3};
//		int m = 3;
//		int n = 6;
		int[] nums1 = {2,0};
		int[] nums2 = {1};
		int m = 1;
		int n = 1;
//		int[] nums1 = {4,5,6,0,0,0};
//		int[] nums2 = {1,2,3};
//		int m = 3;
//		int n = 3;
		merge(nums1, m, nums2, n);
		
		System.out.println(Arrays.toString(nums1));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
        
        int zeroIdx = m + n - 1;
        int ns1Idx = m - 1;
        int ns2Idx = n - 1;
        while (ns1Idx >= 0 && ns2Idx >= 0) {
        	if (nums1[ns1Idx] > nums2[ns2Idx]) {
        		nums1[zeroIdx] = nums1[ns1Idx];
        		nums1[ns1Idx] = 0;
        		ns1Idx--;
        		zeroIdx--;
        	} else {
				nums1[zeroIdx] = nums2[ns2Idx];
				ns2Idx--;
				zeroIdx--;
			}
        }
        if(ns1Idx == -1) {
        	for (int i = 0; i <= ns2Idx; i++) {
        		nums1[i] = nums2[i];
        	}
        }
//        if (m <= n) {
//        	int zeroIdx = m;
//            int ns1Idx = 0;
//            int ns2Idx = 0;
//            while (ns1Idx < m + n && ns2Idx < n) {
//                if (nums1[ns1Idx] > nums2[ns2Idx] || (ns1Idx - ns2Idx >= m)) {
//                    nums1[zeroIdx] = nums1[ns1Idx];
//                    nums1[ns1Idx] = nums2[ns2Idx];
//                    ns2Idx++;
//                    zeroIdx++;
//                }
//                ns1Idx++;
//            }
//        } else { // m > n
//        	int zeroIdx = m + n - 1;
//            int ns1Idx = m - 1;
//            int ns2Idx = n - 1;
//            while (ns1Idx >= 0 && ns2Idx >= 0) {
//            	if (nums1[ns1Idx] > nums2[ns2Idx]) {
//            		nums1[zeroIdx] = nums1[ns1Idx];
//            		nums1[ns1Idx] = 0;
//            		ns1Idx--;
//            		zeroIdx--;
//            	} else {
//					nums1[zeroIdx] = nums2[ns2Idx];
//					ns2Idx--;
//					zeroIdx--;
//				}
//            }
//            
//        }
        
        
        
    }
}
