package leet;

public class FindMedianNum {

	public static void main(String[] args) {
		int[] nums1 = {1,2};
		int[] nums2 = {3,4,5,7,9};
		double ans = findMedianSortedArrays(nums1, nums2);
		System.out.println(ans);
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            return medianNum(nums2);
        }
        if (n == 0) {
            return medianNum(nums1);
        }
        int[] arr = new int[m + n];
        int l1 = 0;
        int l2 = 0;
        int index = 0;
        while (l1 < m && l2 < n) {
            int v1 = nums1[l1];
            int v2 = nums2[l2];
            if (v1 <= v2) {
                arr[index] = v1;
                l1++;
            } else {
                arr[index] = v2;
                l2++;
            }
            index++;
        }
        if (l1 == m) {
            for (int i = l2; i < n; i++) {
                arr[index] = nums2[i];
                index++;
            }
        }
        if (l2 == n) {
            for (int i = l1; i < m; i++) {
                arr[index] = nums1[i];
                index++;
            }
        }

        return medianNum(arr);
    }

    public static double medianNum(int[] nums) {
        int n = nums.length;
        if (n % 2 == 0) { //n为2、4、6 ... n/2 为 1，2，3 ...为中位右侧index，故取之与前一个
                return (nums[n/2] + nums[n/2 - 1]) / 2.0;
            } else { // n为1 3 5  n/2为  0,1,2
                return nums[n/2];
            }
    }

}
