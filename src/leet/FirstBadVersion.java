package leet;

public class FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = firstBadVersion(3);
		System.out.println(ans);
	}

	public static int firstBadVersion(int n) {
	        
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return isBadVersion(left) ? left : right;
    }
	
	public static boolean isBadVersion(int n) {
		if (n > 2) return false;
		return true;
	}
}
