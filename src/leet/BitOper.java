package leet;

public class BitOper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(7 & 6);
		System.out.println(6 & 5);
		System.out.println(5 & 4);
		System.out.println(4 & 3);
		System.out.println(3 & 2);
		System.out.println("==============");
		int x = 0;
		int count = 0;
		while (x != 0) {
			
			System.out.println("x: " + x + "  x-1 :" + (x - 1));
			x = x & (x - 1);
			System.out.println("jieguo   " + x);
			count++;
		}
		System.out.println("------------");
		System.out.println(count);
	}

}
