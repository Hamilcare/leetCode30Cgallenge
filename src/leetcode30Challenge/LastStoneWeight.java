package leetcode30Challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LastStoneWeight {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 7, 4, 1, 8, 1 };
		LastStoneWeight lsw = new LastStoneWeight();
		lsw.lastStoneWeight(arr);
	}

	public int lastStoneWeight(int[] stones) {
		IntegerDescComparator comparator = new IntegerDescComparator();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(stones.length, comparator);

		for (int i : stones) {
			queue.add(i);
		}
		
		int queueSize = stones.length;
		while (queueSize>1) {
			int y = queue.poll();
			int x = queue.poll();
			if(y>x) {
				queue.add(y-x);
				queueSize--;
			}else {
				queueSize-=2;
			}
		}
		System.out.println(queue.poll());
		return 0;
	}
}

class IntegerDescComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {

		return o2 - o1;
	}

}
