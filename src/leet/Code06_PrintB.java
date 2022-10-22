package leet;

public class Code06_PrintB {
	
	public static void print32Int(int num) {
		for (int i = 31; i >= 0; i--) {
			System.out.print((num & (1 << i)) == 0 ? "0" : "1");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
//		print32Int(10);
//		print32Int(Integer.MAX_VALUE);
//		print32Int(Integer.MIN_VALUE );
		
//		int a = Integer.MIN_VALUE;
//		print32Int(a);
//		print32Int(a >>> 1); //不带符号右移
//		print32Int(a >> 1); //带符号右移
		
//		int c = 5;
//		int c = Integer.MIN_VALUE;;
//		int d = -c;
//		int e = ~c + 1;
//		System.out.println(d);
//		System.out.println(e);
		
		int dis = hammingDistance(1, 4);
		System.out.println(dis);
	}

	public static int hammingDistance(int x, int y) {
        int num = 0;
        for (int i = 0; i < 3; i++){
             int xi = (x & (1 << i));
             int yi = (y & (1 << i));
             System.out.print("x" + i + " ");
             print32Int(xi);
             System.out.print("y" + i + " ");
             print32Int(yi);
             System.out.println("xy" + i + "异或：" + (xi ^ yi));
             if ((xi ^ yi) != 0) {
            	 num++;
             }
//            if (((x & (1 << i)) ^ (y & (1 << i))) == 1) num++;
        }
        return num;
    }
}
