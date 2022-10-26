package leet;

public class ReplcaceSpace {

	public static void main(String[] args) {
		System.out.println(replaceSpace("We are happy."));
	}
	
	public static String replaceSpace(String s) {
		String ans = s.replaceAll(" ", "%20");
        return ans;
    }

}
