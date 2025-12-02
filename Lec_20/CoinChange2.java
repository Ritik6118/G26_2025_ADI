package Lec_20;

public class CoinChange2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] coins= {1,2,5};
		int amount=5;
		
		System.out.println(change(amount,coins));
	}
	static Integer [][] dp;
	public static int change(int amount, int[] coins) {
		dp=new Integer[coins.length][amount+1];
		int a=solve(coins,amount,0);
		return a;
	}
	private static int solve(int[] coins, int amount, int i) {
		// TODO Auto-generated method stub
		if(i>=coins.length) {
			if(amount==0) {
				return 1;
			}
			return 0;
		}
		if(dp[i][amount]!=null) {
			return dp[i][amount];
		}
		int pick=0;
		if(coins[i]<=amount) {
			pick=solve(coins,amount-coins[i],i);			
		}
		int notpick=solve(coins,amount,i+1);
		
		return dp[i][amount]=pick+notpick;
	}
}
