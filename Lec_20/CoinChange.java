package Lec_20;

public class CoinChange {
	public static void main(String [] args) {
		int [] arr= {1,2,5};
		int amount=11;
		System.out.println(coinChange(arr,amount));
		
	}
	
	static Integer [][] dp;
	public static int coinChange(int[] coins, int amount) {
		dp=new Integer[coins.length][amount+1];
		int a=solve(coins,amount,0);
		if(a==99999) {
			a=-1;
		}
		return a;
	}

	private static int solve(int[] coins, int amount, int i) {
		// TODO Auto-generated method stub
		if(i>=coins.length) {
			if(amount==0) {
				return 0;
			}
			return 99999;
		}
		if(dp[i][amount]!=null) {
			return dp[i][amount];
		}
		int pick=99999;
		if(coins[i]<=amount) {
			pick=solve(coins,amount-coins[i],i)+1;			
		}
		int notpick=solve(coins,amount,i+1);
		
		return dp[i][amount]=Math.min(pick, notpick);
	}
}
