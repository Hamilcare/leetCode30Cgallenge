package leetcode30Challenge.week1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
	Set<List<Integer>> decomp = new HashSet<>();

	public static void main(String[] args) {
		System.out.println(new HappyNumber().isHappy(2));
	}

	public boolean isHappy(int n) {
		List<Integer> decomposition;
		do {
			decomposition = intToDigits(n);
			n = computeNextNumber(decomposition);
		} while (isCycling(decomposition) && n!=1);
		return n == 1;

	}

	public boolean isCycling(List<Integer> decompostion) {
		return decomp.add(decompostion);
	}

	public List<Integer> intToDigits(int i) {
		String s = "" + i;
		List<Integer> digits = new ArrayList<>(s.length());
		for (int j = 0; j < s.length(); j++) {
			int currentDigit = Character.getNumericValue(s.charAt(j));
			if (currentDigit != 0)
				digits.add(currentDigit);
		}
		return digits;
	}

	public int computeNextNumber(List<Integer> decompostion) {
		int next = 0;
		for (Integer i : decompostion) {
			next = next + i * i;
		}
		return next;
	}

}
