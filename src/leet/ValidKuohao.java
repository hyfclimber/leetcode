package leet;

public class ValidKuohao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "[({(())}[()])]";
		boolean x = isValid(s);
		System.out.println(x);
	}
	
		public static boolean isValid(String s) {
	        char[][] pattern = {{'(',')'}, {'[',']'}, {'{','}'}};
	        int start = -1;
	        int end = -1;
	        int numL = 0;
	        int numR = 0;
	        int numYin = 0;
	        int numYang = 0;
	        for (int x = 0; x < pattern.length; x++) {
	            for (int i = 0; i < s.length(); i++) {
	                char cur = s.charAt(i);
	                if (cur == pattern[x][0]) {
	                    numL++;
	                    if (end == -1) {
	                        start = i;
	                    } else {
	                        return false;
	                    }
	                    numYang = 0;
	                    numYin = 0;
	                } else if (cur == pattern[x][1]) {
	                    numR++;
	                    if (start != -1) {
	                    	end = i;
	                    }
	                    if (numYang == numYin) {
	                        start = -1;
	                        end = -1;
	                        numYang = 0;
	                        numYin = 0;
	                    } else {
	                        return false;
	                    }
	                } else {
	                    if (cur == pattern[0][0] || cur == pattern[1][0] || cur == pattern[2][0]) {
	                    	if (start != -1) {
	                    		numYang++;
	                    	}
	                    } else {
	                    	if (start != -1) {
	                    		numYin++;
	                    	}
	                    }
	                }
	                if (i == s.length() - 1 && start != -1 && end == -1) {
	                	return false;
	                }
	            }
	            start = -1;
	            end = -1;
	            numYang = 0;
	            numYin = 0;
	            if (numL != numR) return false;
	            numL = 0;
	            numR = 0;
	        }
	
	        return true;
	    }

}
