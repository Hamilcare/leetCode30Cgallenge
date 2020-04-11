package leetcode30Challenge;

import java.util.Stack;

public class BackspaceCompare {
	public static void main(String[] args) {
		String S = "ab#c";
		String T = "ad#c";
//		System.out.println(new BackspaceCompare().backspaceCompare(S, T));
//
//		S = "ab##";
//		T = "c#d#";
//		System.out.println(new BackspaceCompare().backspaceCompare(S, T));
//
//		S = "a##c";
//		T = "#a#c";
//		System.out.println(new BackspaceCompare().backspaceCompare(S, T));
//
//		S = "a#c";
//		T = "b";
//		System.out.println(new BackspaceCompare().backspaceCompare(S, T));

		S = "y#fo##f";
		T = "y#f#o##f";

		System.out.println(new BackspaceCompare().backspaceCompare(S, T));
	}

	public boolean backspaceCompare(String S, String T) {

		Stack<Character> s1 = strToStack(S);
		Stack<Character> s2 = strToStack(T);
		System.out.println(s1.size());
		System.out.println(s2.size());
		return s1.equals(s2);

	}

	private Stack<Character> strToStack(String S) {
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '#') {
				if (!s.empty())
					s.pop();
			} else {
				s.push(c);
			}
		}
		return s;
	}

}
