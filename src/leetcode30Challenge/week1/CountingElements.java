package leetcode30Challenge.week1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CountingElements {

	public static void main(String[] args) {
		
		CountingElements ce = new CountingElements();
		
		int[] arr = new int[] {1,2,3};
		ce.countElements(arr);
		
		arr = new int[] {1,1,3,3,5,5,7,7};
		ce.countElements(arr);
		
		arr = new int[] {1,3,2,3,5,0};
		ce.countElements(arr);
		
		arr = new int[] {1,1,2,2};
		ce.countElements(arr);
		
		arr = new int[] {1,1,2};
		ce.countElements(arr);
	}

		public int countElements(int[] arr) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>(arr.length);
			for (int i : arr) {
				Integer value = map.get(i);
				if (null == value) {
					map.put(i, 1);
				} else {
					map.put(i, value + 1);
				}
			}
	
			int resul = 0;
			Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
	
			while (iterator.hasNext()) {
				Map.Entry<Integer, Integer> entry = iterator.next();
				int value = entry.getKey();
				int countValue = entry.getValue();
				Integer nbNext = map.get(value + 1);
				if (null != nbNext) {
					resul +=countValue;
				}
			}
	
		System.out.println(resul);
			return resul;
		}

}
