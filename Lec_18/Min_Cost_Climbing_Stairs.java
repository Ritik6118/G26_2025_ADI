package Lec_18;

public class Min_Cost_Climbing_Stairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {1,100,1,1,1,100,1,1,100,1};
		System.out.println(minCostClimbingStairs(arr));
	}
	
	static Integer[]dp;
	
	public static int minCostClimbingStairs(int[] cost) {
		dp=new Integer[cost.length];
		int a=solve(0,cost);
		int b=solve(1,cost);
		return Math.min(a, b);
		
	}

	private static int solve(int i, int[] cost) {
		// TODO Auto-generated method stub
		
		if(i>=cost.length) {
			return 0;
		}
		
		if(dp[i]!=null) {
			return dp[i];
		}
		
		int a=solve(i+1,cost)+cost[i];
		int b=solve(i+2,cost)+cost[i];
		
		dp[i]=Math.min(a, b);
		return dp[i];
	}

}
