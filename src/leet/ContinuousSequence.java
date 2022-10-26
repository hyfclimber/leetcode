package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContinuousSequence {

	public static void main(String[] args) {
//		List<ArrayList<Integer>> ans = findContinuousSequence1(9);
//		for (int i = 0; i < ans.size(); i++) {
//			System.out.println(ans.get(i));
//		}
		
		 int[][] ans = findContinuousSequence(9);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(Arrays.toString(ans[i]));
		}
		
	}

	
	public static int[][] findContinuousSequence(int target) {
        List<ArrayList<Integer>> ansList = new ArrayList<ArrayList<Integer>>();
        for (int x = 1; x <= target / 2; x++) {
            ArrayList<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int i = x; i <= target; i++) {
                sum += i;
                list.add(i);
                if (sum == target) {
                    ansList.add(list);
                    break;
                } else if (sum > target) {
                    break;
                }
            }
        }
        int[][] ans = new int[ansList.size()][];
        for (int i = 0; i < ansList.size(); i++) {
            List<Integer> subList = ansList.get(i);
            int[] subAns = new int[subList.size()];
            for (int x = 0; x < subList.size(); x++) {
                subAns[x] =  subList.get(x);
            }
            ans[i] = subAns;
        }
        return ans;
    }
	
	public static List<ArrayList<Integer>> findContinuousSequence1(int target) {
        List<ArrayList<Integer>> ansList = new ArrayList<ArrayList<Integer>>();
        for (int x = 1; x <= target / 2; x++) {
            ArrayList<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int i = x; i <= target; i++) {
                sum += i;
                list.add(i);
                if (sum == target) {
                    ansList.add(list);
                    break;
                } else if (sum > target) {
                    break;
                }
            }
        }
        return ansList;
    }
}
