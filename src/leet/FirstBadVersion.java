package leet;

public class FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = firstBadVersion1(2126753390);
		System.out.println(ans);
	}

	public static int firstBadVersion(int n) {
	        
		int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }
	
	public static int firstBadVersion1(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean midB = isBadVersion(mid);
            if (mid > 1) {
                if (midB && !isBadVersion(mid - 1)) return mid;
            }
            if (mid < n) {
                if (!midB && isBadVersion (mid + 1)) return mid + 1;
            }
            if (mid == 1 || mid == n) return isBadVersion(mid) ? mid : -1;
            if (midB) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
        
    }
	
	
	
	
	public static boolean isBadVersion(int n) {
		if (n >= 1702766719) return true;
		return false;
	}
}
