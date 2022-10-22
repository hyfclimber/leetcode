package leet;
/**
 * 计算 1！+ 2！+ 3！+ ... + N!
 * @author hyf
 *
 */

public class Factorial {
	
	
	public static int factorial(int num) {
		int total = 0;
		if (num < 1) return 0; 
		int tmp = 1;
		for (int i = 1; i <= num; i++) {
			tmp = tmp * i;
			total += tmp;
		}
		return total;
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(10));
	}
}
