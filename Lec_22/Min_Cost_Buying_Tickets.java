package Lec_22;

public class Min_Cost_Buying_Tickets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] days= {1,2,3,4,5,6,7,8,9,10,30,31};
		int [] costs= {2,7,15};
		System.out.println(mincostTickets(days,costs));
	}

	static Integer[] dp;
	public static int mincostTickets(int[] days, int[] costs) {
		int [] freq=new int [366];
		dp=new Integer[366];
		for(int i:days) {
			freq[i]++;
		}
		 return solve(freq,costs,0);
	}

	private static int solve(int[] days, int[] costs, int i) {
		// TODO Auto-generated method stub
		if(i>=days.length) {
			return 0;
		}
		if(dp[i]!=null) {
			return dp[i];
		}
		int a=99999;
		int b=99999;
		if(days[i]!=0) {
			// purchase tickets
			a=Math.min(a, solve(days,costs,i+1)+costs[0]);
			a=Math.min(a, solve(days,costs,i+7)+costs[1]);
			a=Math.min(a, solve(days,costs,i+30)+costs[2]);
		}
		else {
			// no need to purchase tickets
			b=Math.min(b, solve(days,costs,i+1));
		}
		return dp[i]= Math.min(a, b);
	}

}
