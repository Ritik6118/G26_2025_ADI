package Lec_19;

public class House_Robber_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 2 };
		System.out.println(rob(arr));
	}
	static Integer [] dp;
	public static int rob(int[] nums) {
		dp=new Integer[nums.length];
		int a=solve(nums,0,true);
		dp=new Integer[nums.length];
		int b=solve(nums,1,false);
		return Math.max(a, b);
	}

	private static int solve(int[] nums, int i, boolean b) {
		// TODO Auto-generated method stub
		if(i>=nums.length) {
			return 0;
		}
		if(dp[i]!=null) {
			return dp[i];
		}
		int pick=0;
		if(i<nums.length-1 || b==false) {
			pick=solve(nums,i+2,b)+nums[i];			
		}
		
		int notpick=solve(nums,i+1,b);
		
		return dp[i]=Math.max(pick, notpick);
	}

}
