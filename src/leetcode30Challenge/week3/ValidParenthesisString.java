package leetcode30Challenge.week3;

import java.util.HashSet;
import java.util.Set;

public class ValidParenthesisString {
	
	public static void main(String[] args) {
		ValidParenthesisString vps = new ValidParenthesisString();
		System.out.println(vps.checkValidString("("));
		System.out.println(vps.checkValidString(""));
		System.out.println(vps.checkValidString(")"));
		
		System.out.println(vps.checkValidString("()"));
		System.out.println(vps.checkValidString("(())"));
		System.out.println(vps.checkValidString("(*)"));
	}

	public boolean checkValidString(String s) {
		if (s.length() == 0) {
			return true;
		}
		char[] chars = s.toCharArray();

		Set<Integer> states = init(chars[0]);
		if (states.isEmpty()) { // ie first = ')'
			return false;
		}

		Set<Integer> newStates = new HashSet<>();
		for (int i = 1; i < chars.length; i++) {
			newStates.removeAll(newStates);
			char currentChar = chars[i];
			for (Integer state : states) {
				switch (currentChar) {
				case '(':
					newStates.add(state + 1);
					break;
				case '*':
					newStates.add(state + 1);
					newStates.add(state);
					newStates.add(state - 1);
					break;
				case ')':
					newStates.add(state - 1);
					break;
				default:
					break;
				}
			}
			newStates.remove(-1);
			states.removeAll(states);
			states.addAll(newStates);
//			System.out.println(states.size());
		}
		

		return states.contains(0);
	}

	private Set<Integer> init(Character first) {
		Set<Integer> set = new HashSet<>();

		switch (first) {
		case '(':
			set.add(1);
			break;
		case '*':
			set.add(1);
			set.add(0);
			break;
		case ')':
			break;
		default:
			break;
		}
		return set;
	}
}
