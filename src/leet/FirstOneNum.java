package leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FirstOneNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "loveleetcode";
		int ans = firstUniqChar(test);
		System.out.println(ans);
	}

	
	public static int firstUniqChar(String s) {
        //遍历char[]，把idx和对应的次数，存在HashMap中。
        //遍历HashMap,把次数只有1的key存数组
        //遍历数组，找到最小index。 时间复杂度O(N),空间复杂度O(N)
        //优化空间，空间复杂度能否到O(1)?


        char[] chars = s.toCharArray();
        int N = chars.length;
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
        	Character ch = chars[i];
        	Boolean succ = set.add(ch);
        	System.out.println("字符：" + ch + "是否插入Set: " + succ);
            map.put(ch, succ);
        }
        System.out.println(map);

        ArrayList<Integer> idxList = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(Boolean.TRUE)) {
            	char c = (Character) entry.getKey();
                idxList.add(s.indexOf(c));
            }
        }
        int idx = Integer.MAX_VALUE;
        for (int i = 0; i < idxList.size(); i++) {
            idx = Math.min(idx, idxList.get(i));
        }
        return idx == Integer.MAX_VALUE ? -1 : idx;
    }
}
