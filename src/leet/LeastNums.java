package leet;

import java.util.Arrays;
import java.util.LinkedList;

public class LeastNums {

	public static void main(String[] args) {

		int[] test = {4,6,7,1, 2, 3};
		int[] ans = getLeastNumbers(test, 4);
		System.out.println(Arrays.toString(ans));
	}
	
	
	public static int[] getLeastNumbers(int[] arr, int k) {
		if (arr == null || arr.length == 0) return null;
		Arrays.sort(arr);
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = arr[i];
		}
		return ans;
    }
	
	
	public static int[] getLeastNumbers1(int[] arr, int k) {
		if (arr == null || arr.length == 0) return null;
		LinkedList<Integer> queue = new LinkedList<>();
		int N = arr.length;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if (arr[i] <= min) {
				offer(arr[i], queue, k);
				min = arr[i];
			}
		}
		int size = queue.size();
		if (size < k) {
			for (int i = size; i < k; i++) {
				offer(arr[i], queue, k);
			}
		}
		
		int[] ans = new int[k];
		int x = 0;
		while (!queue.isEmpty()) {
			ans[x] = queue.poll();
			x++;
		}
		return ans;
    }
	
	public static void offer(int v, LinkedList<Integer> queue, int k) {
		if (queue.size() >= k) {
			queue.poll();
		}
		queue.offer(v);
	}

}
