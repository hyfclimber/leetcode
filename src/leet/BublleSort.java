package leet;

public class BublleSort {

public static void bublleSort(int[] arr) {
		
		if (arr == null || arr.length < 2) {
			return;
		}
		int N = arr.length;
		
		//0~N, 0 ~ N -1 , 0~end
		for (int end = N - 1; end >= 0; end--) {
			//两两比较，知道最后end-1和 end比较
			for (int second = 1; second <= end; second++) {
				if (arr[second] > arr[second - 1]) {
					swap(arr, second, second - 1);
				}
			}
		}
		
		
		
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
	
	public static int reverse(int x) {
        int result = 0 ; 
        while ( x != 0){
            if(result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10){
                return 0 ; 
            }

            int digit = x % 10 ; 
            x = x / 10 ;
            result = result * 10 + digit; 
        }

        return result ; 
    }

	public static void main(String[] args) {
//		int arr[] = {4, 2, 5, 7, 9, 12, 5};
//		print(arr);
//		bublleSort(arr);
//		print(arr);
		System.out.println(Integer.MAX_VALUE);
		System.out.println("9646324351");
//		int x = 9646324351;
//		Integer.parseInt("9646324351");
		
//		-2147483412
//		-2147483647
//		-2143847412
		
		
	}
}
