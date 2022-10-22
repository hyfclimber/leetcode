package leet;

public class ExcelTans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ans = convertToTitle(701);
//		System.out.println(ans);
		
		System.out.println(titleToNumber("FXSHRXW"));
	}


	
	public static String convertToTitle(int columnNumber) {
      StringBuilder sb = new StringBuilder();
      int num = columnNumber;
      while (num > 0) {
          int yu = num % 26;
          int shang = num / 26;
          if (yu == 0) {
          	num = shang - 1;
          	yu = 26;
          } else {
          	num = shang;
          }         
          char ch = (char)('A' - 1 + yu);
//          System.out.println(ch);
          sb.append(ch);
      }
      return sb.reverse().toString();
  }
	
	public static String convertToTitle1(int columnNumber) {
		StringBuffer sb = new StringBuffer();
        while (columnNumber != 0) {
            columnNumber--;
            char ch = (char)(columnNumber % 26 + 'A');
            sb.append(ch);
            System.out.println(ch);
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
	
	public static int titleToNumber(String columnTitle) {
		int ans = 0;
		int N = columnTitle.length();
		for (int i = 0; i < N; i++) {
			char ch = columnTitle.charAt(i);
			int wei = N - 1 - i;
			ans += (ch - 'A' + 1) * Math.pow(26, wei);
		}
		return ans;

    }
}
