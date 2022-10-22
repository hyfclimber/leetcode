package leet;

public class SelectionSort {
	
	public static void selectSort(int[] arr) {
		
		if (arr == null || arr.length < 2) {
			return;
		}
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			int minValIdx = i;
			for (int j = i + 1; j < N; j++) {
//				//遍历i之后的每一个值，如果比第i个值小，就交换i和j的位置。
//				if (arr[j] < arr[i]) {
//					swap(arr, i, j);
//				}
				//优化 交换属于操作数组，可以先找到最小的数，最后操作一次数组
				minValIdx = arr[minValIdx] > arr[j] ? j : minValIdx;
			}
			//优化 交换属于操作数组，可以先找到最小的数，最后操作一次数组
			swap(arr, i, minValIdx);
		}	
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		int arr[] = {4, 2, 5, 7, 9, 12, 5};
		print(arr);
		selectSort(arr);
		print(arr);
	}

}
