package leetcode30Challenge.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContiguousArray {

	public static void main(String[] args) {
		ContiguousArray ca = new ContiguousArray();

		int[] arr = new int[] { 0, 1 };
		System.out.println("Assert 2 : " + ca.findMaxLength(arr));
//		System.out.println("Assert 2 : "+ca.solution(arr));

		arr = new int[] { 1, 0 };
		System.out.println("Assert 2 : " + ca.findMaxLength(arr));
//		System.out.println("Assert 2 : "+ca.solution(arr));
		arr = new int[] { 0, 1, 0 };
		System.out.println("Assert 2 : " + ca.findMaxLength(arr));
//		System.out.println("Assert 2 : "+ca.solution(arr));
		arr = new int[] { 1, 0, 1 };
		System.out.println("Assert 2 : " + ca.findMaxLength(arr));
//		System.out.println("Assert 2 : "+ca.solution(arr));
		arr = new int[] { 0, 0, 0, 1, 1, 1, 0 };
		System.out.println("Assert 6 : " + ca.findMaxLength(arr));
//		System.out.println("Assert 6 : "+ca.solution(arr));

		arr = new int[] { 0, 0, 1, 0, 0, 0, 1, 1 };
//		System.out.println("Assert 6 : "+ca.solution(arr));
		System.out.println("Assert 6 : " + ca.findMaxLength(arr));
	}

	public int findMaxLength(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		// Init
		nums = transformZeroes(nums);
		int[] tmp = new int[nums.length];
		tmp[0] = nums[0];
		StringBuilder sbArrayOfSums = new StringBuilder(tmp.length);
		sbArrayOfSums.append(tmp[0] + ",");

		Map<Integer, List<Integer>> mapValue = new HashMap<>();
		List<Integer> l = new ArrayList<Integer>();
		l.add(0);
		mapValue.put(tmp[0], l);

		for (int i = 1; i < nums.length; i++) {
			tmp[i] = nums[i] + tmp[i - 1];
			sbArrayOfSums.append(tmp[i] + ",");
			List<Integer> indexesOfValue = mapValue.get(tmp[i]);
			if (null == indexesOfValue) {
				List<Integer> lst = new ArrayList<>();
				lst.add(i);
				mapValue.put(tmp[i], lst);
			} else {
				indexesOfValue.add(i);
			}
		}

		StringBuilder sbOfMap = new StringBuilder();
		for (Map.Entry<Integer, List<Integer>> entry : mapValue.entrySet()) {
			sbOfMap.append(entry.getKey() + " : [");
			for (Integer i : entry.getValue()) {
				sbOfMap.append(i + ", ");
			}
			sbOfMap.append("]\n");
		}

		System.out.println(sbArrayOfSums.toString());
		System.out.println(sbOfMap.toString());

		int maxEcart = mapValue.values().stream().filter(lst -> lst.size() > 1)
				.map(lst -> lst.get(lst.size() - 1) - lst.get(0)).mapToInt(v -> v).max().orElse(0);

		int zeroMaxIndex = 0;
		if (mapValue.containsKey(0)) {
			zeroMaxIndex = mapValue.get(0).stream().mapToInt(v -> v).max().getAsInt() + 1;
		}

		return Math.max(maxEcart, zeroMaxIndex);
	}

	/**
	 * Renvoie un tableau similaire au tableau d'entrée mais où les 0 sont remplacés
	 * par -1
	 * 
	 * @param nums tableau de 0 et de 1
	 * @return [0,1,0,1] -> [-1,1,-1,1]
	 */
	public int[] transformZeroes(int[] nums) {
		int[] transformed = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				transformed[i] = -1;
			} else {
				transformed[i] = 1;
			}
		}
		return transformed;
	}

	public int bruteForce(int[] nums) {
		int max = 0;
		nums = transformZeroes(nums);
		for (int i = 0; i < nums.length - max; i++) {
			int currentMax = 0;
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum == 0) {
					currentMax = j - i + 1;
				}
			}
			max = Math.max(max, currentMax);
		}
		return max;
	}

}
