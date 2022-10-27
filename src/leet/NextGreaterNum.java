package leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//496. 下一个更大元素 I
//https://leetcode.cn/problems/next-greater-element-i/
public class NextGreaterNum {

	
	public static void main(String[] args) {
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
//		int[] nums1 = {2,4};
//		int[] nums2 = {1,2,3,4};
		int[] ans = nextGreaterElement1(nums1, nums2);
		System.out.println(Arrays.toString(ans));
	}

	//暴力破解
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int M = nums1.length;
		int N = nums2.length;
		int[] ans = new int[M];
		//每一个nums1的数字。
		for (int i = 0; i < M;  i++) {
			int v = nums1[i];
			//寻找相等的值的idx
			for (int j = 0; j < N; j++) {
				int v2 = nums2[j];
				if (v == v2) {
					//寻找第一个更大的
					int idx = -1;
					for (int k = j; k < N; k++) {
						if (nums2[k] > v) {
							idx = k;
							break;
						}
					}
					//寻找的结果
					if (idx != -1) {
						ans[i] = nums2[idx];
					} else {
						ans[i] = -1;
					}
					break;
				}
			}
		}
		
		return ans;

    }
	
	//栈+哈希。时间复杂度为:O(M+NLog(N))
	public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
		int M = nums1.length;
		int N = nums2.length;
		int[] ans = new int[M];
		Stack<Integer> stack = new  Stack<>(); //利用栈的后进先出特性，将后进来的第一个进行和前面的比较。
		Map<Integer, Integer> map = new HashMap<>(); //存储<值，右侧第一个大值>
		
		for (int i = 0; i < N; i++) {
			int v = nums2[i];
			while (!stack.isEmpty() && stack.peek() < v) {
				map.put(stack.pop(), v);
			}
			stack.add(nums2[i]);
		}
		
		for (int i = 0; i < M; i++) {
			ans[i] = map.getOrDefault(nums1[i], -1);
		}
		
		return ans;

    }
}
