package leet;

import java.util.Arrays;

//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
//对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
//
//输入: g = [1,2,3], s = [1,1]
//输出: 1
//
//输入: g = [1,2], s = [1,2,3]
//输出: 2

public class CookieDispatch {

	public static void main(String[] args) {
		int[] g = {3, 4};
		int[] s = {1, 2, 3};
		int ans = findContentChildren(g, s);
		System.out.println(ans);
	}
	
	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int num = 0;
		
		int gi = 0; 
		int si= 0;
		while (gi < g.length && si < s.length) {
			if (g[gi] <= s[si]) {
				num++;
				si++;
				gi++;
			} else {
				si++;
			}
		}
		return num;
    }

}
