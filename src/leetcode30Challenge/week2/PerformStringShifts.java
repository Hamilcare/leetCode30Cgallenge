package leetcode30Challenge.week2;

public class PerformStringShifts {

	public static void main(String[] args) {
		PerformStringShifts pss = new PerformStringShifts();
		String str = "abc";
		int[][] shifts = new int[][] { { 0, 1 }, { 1, 2 } };
		System.out.println(pss.stringShift(str, shifts));
		
		str= "yzeuobhwxatulpruiab";
		shifts = new int[][]{{1,15},{0,18},{0,12},{0,7},{0,7},{1,17},{1,15},{0,9},{1,4},{0,19},{1,16},{0,7},{1,4},{1,17},{1,19},{1,10},{1,2},{0,18},{1,15}};
		System.out.println(pss.stringShift(str, shifts));
	}

	public String stringShift(String s, int[][] shift) {
		int countLeftShit = 0;
		for (int[] sh : shift) {
			if (sh[0] == 0) {
				countLeftShit += sh[1];
			} else {
				countLeftShit -= sh[1];
			}
		}
		
		if(countLeftShit<0) {
			countLeftShit = -1*countLeftShit;
			countLeftShit=countLeftShit % s.length();
			countLeftShit=s.length()-countLeftShit;
		}
		countLeftShit=countLeftShit % s.length();
		System.out.println("total left shit : " + countLeftShit);
		
		return perferomLeftShift(s, countLeftShit);
	}

	private String perferomLeftShift(String strToShift, int nbShift) {
//		nbShift = nbShift % strToShift.length();
		if (nbShift == 0) {
			return strToShift;
		}
		StringBuilder sb = new StringBuilder(strToShift);
		for (int i = 0; i < strToShift.length(); i++) {
			int newIndex = computeNewIndex(i, strToShift.length(), nbShift);
			sb.setCharAt(newIndex, strToShift.charAt(i));
		}
		return sb.toString();
	}

	private int computeNewIndex(int oldIndex, int strLen, int nbShift) {
		int newIndex = oldIndex - nbShift;
		if (newIndex < 0) {
			newIndex = strLen + newIndex;
		}
		return newIndex;
	}
}
