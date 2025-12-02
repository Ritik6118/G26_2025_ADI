package Lec_21;

public class Knapsac_0_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w = 5;
		int[] val = { 10,40,30,50 };
		int[] wt = { 5,4,2,3 };
		System.out.println(knapsack(w, val, wt));
	}

	static Integer[][]dp;
	public static int knapsack(int w, int val[], int wt[]) {
		// code here
		dp=new Integer[val.length][w+1];
		return solve(w,val,wt,0);
	}

	private static int solve(int cap, int[] val, int[] wt, int i) {
		// TODO Auto-generated method stub
		if(i>=val.length) {
			return 0;
		}
		if(dp[i][cap]!=null) {
			return dp[i][cap];
		}
		int pick =0;
		if(wt[i]<=cap) {
			pick=solve(cap-wt[i],val,wt,i+1)+val[i];
		}
		int notpick=solve(cap,val,wt,i+1);
		
		return dp[i][cap]=Math.max(pick, notpick);
	}

}
