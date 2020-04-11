package leetcode30Challenge;

public class MoveZeroes {
	public static void main(String[] args) {
		int[] nums = { 0,1,0,3,12};
		new MoveZeroes().moveZeroes(nums);
	}
	public void moveZeroes(int[] nums) {
		int cptZeroes = 0;
		int i=0; 
		for(i=0;i<nums.length; i++ ) {
			if(nums[i]==0) {
				cptZeroes++;
			}else {
				nums[i-cptZeroes]=nums[i];
			}
		}
		for(int j=nums.length-1; j>=nums.length-cptZeroes;j--) {
			nums[j]=0;
		}
		
		for(int k=0;k<nums.length; k++) {
			System.out.print(nums[k]);
		}
	}
}
