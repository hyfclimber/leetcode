package leet;

import java.util.Arrays;

//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
//初始化 A 和 B 的元素数量分别为 m 和 n。

public class MergeArr {

	public static void main(String[] args) {
		int[] A = {1,2,3,4,0,0,0};
		int[] B = {2};
		merge(A, 4, B, 3);
		System.out.println(Arrays.toString(A));
	}
	
	public static void merge(int[] A, int m, int[] B, int n) {
		int N = m + n;
		int a = m - 1;
		int b = n - 1;
		int cur = N - 1;
		while (a >= 0 && b >= 0) {
			if (A[a] >= B[b]) {
				int tmp = A[a];
				A[a] = A[cur];
				A[cur] = tmp;
				a--;
			} else {
				A[cur] = B[b];
				b--;
			}
			cur--;
		}
		if (a < 0) {
			for (int i = 0; i <= b; i++) {
				A[i] = B[i];
			}
		}
    }

}
