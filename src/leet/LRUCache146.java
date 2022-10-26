package leet;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LRUCache146 {

	public static void main(String[] args) {
		LRUCache146 c = new LRUCache146(2);
		c.put(1, 1);
		c.put(2, 2);
		c.print();
		c.get(1);
//		c.get(1);
//		c.get(1);
//		c.get(1);
//		c.get(1);
//		c.put(3, 3);
		c.print();
//		c.get(2);
//		c.print();
//		c.put(4, 4);
//		c.print();
//		c.get(1);
//		c.get(3);
//		c.get(4);
//		c.put(5, 5);
//		c.print();
//		c.put(6, 6);
//		c.print();
//		c.print();
//		c.put(7, 7);
//		c.print();
//		c.put(8, 8);
//		c.print();
//		c.put(9, 9);
//		c.print();
	}

	Map<Integer, Integer> cache;
	TreeMap<Integer, Integer> accessTimeCache;
	HashMap<Integer, Integer> accessTimeCacheCopy;
	int capacity;
	static int time = 0;

	public LRUCache146(int capacity) {
		cache = new HashMap<>();
		accessTimeCacheCopy = new HashMap<>();
		this.capacity = capacity;
		accessTimeCache = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				Integer date1 = accessTimeCacheCopy.get(o1);
				Integer date2 = accessTimeCacheCopy.get(o2);
				int ans = date1.compareTo(date2); 
				System.out.println("=====  " + ans);
				return date1.compareTo(date2); 
			}
		});
	}

	public void countAfterAccess(int key) {
		accessTimeCacheCopy.put(key, time++);
		accessTimeCache.put(key, time);
		Integer first = accessTimeCache.firstKey();
		Integer l = accessTimeCache.lastKey();
		if (accessTimeCache.size() > capacity) {
			Map.Entry<Integer, Integer> entry = accessTimeCache.pollFirstEntry();
			System.out.println("---------    " + entry.getKey());
			cache.remove(entry.getKey());
			accessTimeCacheCopy.remove(entry.getKey());
		}
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			int ele = cache.get(key);
			countAfterAccess(key);
			return ele;
		}
//		System.out.println("已废弃: " + key);
		return -1;
	}

	public void put(int key, int value) {
		cache.put(key, value);
		countAfterAccess(key);
	}
	
	public void print() {
		for (Map.Entry<Integer, Integer> ele : accessTimeCache.entrySet()) {
			System.out.print("ele: " + ele.getKey() + " access: " + ele.getValue() + ",     ");
		}
		System.out.println();
	}

}
