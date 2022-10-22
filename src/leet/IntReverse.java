package leet;

import java.util.Arrays;

public class IntReverse {

	public static void main(String[] args) {
		int x = -2147483412;
		int ans = reverse(x);
		System.out.println(ans);
	}

	
	public static int reverse(int x) {
        if (x == Integer.MIN_VALUE || x == 0) { //边界返回0
            return 0;
        }
        
        while (x % 10 == 0) { //去掉最后面的0，因为倒过来之后是不要的。
            x = x / 10;
        }

        String sStr = x + "";
        char[] xc = sStr.toCharArray(); // 将剩下的数转化为char[]
        int N = xc.length;

        int left = x > 0 ? 0 : 1; //区分正负数
        int right = N - 1;

        while (left <= right) { //双指针翻转char[]
            char tmp = xc[left];
            xc[left] = xc[right];
            xc[right] = tmp;
            left++;
            right--;
        }

        //摘除翻转之后的大数。
        char[] max = (Integer.MAX_VALUE + "").toCharArray(); 
        int charN = max.length;
        int firstNumIdx = x > 0 ? 0 : 1;
        if (x > 0 ? xc.length == charN : xc.length - 1 == charN) { //正负数都判断。
            if (xc[firstNumIdx] > '2') {
            	return 0;
            }	
            char[] lastArray = Arrays.copyOfRange(xc, firstNumIdx + 1, xc.length);
            int last = Integer.parseInt(new StringBuffer().append(lastArray).toString());
            if (last > 147483647) return 0;
        }
        int ans = Integer.parseInt(new StringBuffer().append(xc).toString());

        
        return ans;
    }
}
