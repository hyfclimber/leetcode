package leet;

public class MaxProfit {

	public static void main(String[] args) {
		int[] stocks = {7,1,5,3,6,4};
		int ans = maxProfit(stocks);
		System.out.println(ans);
	}

	public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int N = prices.length;
        for (int i = 0; i < N; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
