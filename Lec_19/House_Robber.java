package Lec_19;

public class House_Robber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {1,2,3,1};
		System.out.println(rob(arr));
	}
	
	static Integer [] dp;
	public static int rob(int[] nums) {
		dp=new Integer[nums.length];
		return solve(nums,0);
	}

	private static int solve(int[] nums, int i) {
		// TODO Auto-generated method stub
		if(i>=nums.length) {
			return 0;
			
		}
		if(dp[i]!=null) {
			return dp[i];
		}
		int pick=solve(nums,i+2)+nums[i];
		int notpick=solve(nums,i+1);
		
		return dp[i]=Math.max(pick, notpick);
	}
}
