package leet;

public class Atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "    +1146905820n1";
		String ans = noPreSpace(test);
		System.out.println("noPreSpace--- " + ans);
		String y = validPositive(ans);
		System.out.println("validPositive--- " + y);
		String x = validNumStr(y);
		System.out.println("validNumStr--- " + x);
		int answ = answerNum(x);
		System.out.println("answerNum--- " + answ);
	}
	
	public static String noPreSpace(String s) {
        int lastPreSpaceIdx = -1;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' '){
            	break;
            } 
            lastPreSpaceIdx++;
        }
        String ans = s;
        if (lastPreSpaceIdx == -1) {
            //原串
        } else if (lastPreSpaceIdx + 1 < s.length()) {
        	ans = s.substring(lastPreSpaceIdx + 1);
        } else {
        	ans = "";
        }
        
        return ans;
    }
	
	public static String validPositive(String s) {
		if (s.length() == 0) return "";
		if (s.length() == 1 && !Character.isDigit(s.charAt(0))) return "";
		if (!Character.isDigit(s.charAt(0)) && !Character.isDigit(s.charAt(1))) return "";
		if (!Character.isDigit(s.charAt(0)) && s.charAt(0) != '-' && s.charAt(0) != '+') return "";
		return s;
	}
	
	public static boolean isPositive(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		if (s.charAt(0) == '-') return false;
		return true;
	}
	
	public static String validNumStr(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		String ans = s;
		int idx = -1;
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 && (s.charAt(i) == '-' || s.charAt(i) == '+')) continue;
			if (!Character.isDigit(s.charAt(i))) {
				idx = i;
				break;
			}
		}
		
		if (idx != -1) {
			ans = s.substring(0, idx);
		}
		String fuhao = "";
		String numStr = ans;
		if (!Character.isDigit(s.charAt(0))) { //取出符号位
			numStr = ans.substring(1);
			fuhao = ans.charAt(0) == '-' ? ans.charAt(0) + "" : "";
		}
		int idxx = -1;
		for (int i = 0; i < numStr.length(); i++) {
			if (numStr.charAt(i) != '0') break;
			idxx++;
		}
		String validNumStr = numStr;
		if (idxx != -1) {
			validNumStr = numStr.substring(idxx);
		}
		
		return fuhao + validNumStr;
	}
	
	public static int answerNum(String s) {
		if (s == null || s.length() == 0) return 0;
		String maxStr = Integer.MAX_VALUE + "";
		String minStr = Integer.MIN_VALUE + "";
		boolean isPositive = isPositive(s);
		System.out.println("s is : " + s);
		System.out.println("a is : " + Integer.MAX_VALUE);
		System.out.println("i is : " + Integer.MIN_VALUE);
		if (isPositive) {
			if (s.length() > maxStr.length()) {
				return Integer.MAX_VALUE;
			} else if (s.length() == maxStr.length()) {
				if (s.compareTo(maxStr) > 0) {
					return Integer.MAX_VALUE; 
				} else {
					return Integer.parseInt(s);
				}
			} else {
				return Integer.parseInt(s);
			}
		}
		if (!isPositive) {
			if (s.length() > minStr.length()) {
				return Integer.MIN_VALUE;
			} else if (s.length() == minStr.length()) {
				if (s.compareTo(minStr) > 0) {
					return Integer.MIN_VALUE; 
				} else {
					return Integer.parseInt(s);
				}
			} else {
				return Integer.parseInt(s);
			}
		}
		return 0;
	}

}
