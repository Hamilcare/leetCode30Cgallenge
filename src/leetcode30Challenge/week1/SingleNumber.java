package leetcode30Challenge.week1;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
	public static void main(String[] args) {

	}

	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				map.remove(i);
			} else {
				map.put(i, 0);
			}
		}
		return map.entrySet().stream().findAny().get().getKey();
	}
}
