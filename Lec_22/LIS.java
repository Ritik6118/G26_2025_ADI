package Lec_22;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int a=lis(arr);
		System.out.println(a);
	}
	static Integer[][] dp;
 	private static int lis(int[] arr) {
		// TODO Auto-generated method stub
 		dp=new Integer[arr.length][arr.length+1];
		return lis(arr, 0, -1);
	}

	private static int lis(int[] arr, int curr, int prev) {
		// TODO Auto-generated method stub

		if(curr>=arr.length) {
			return 0;
		}
		if(dp[curr][prev+1]!=null) {
			return dp[curr][prev+1];
		}
		int pick = 0;
		if (prev == -1 || arr[prev] < arr[curr]) {
			pick = lis(arr, curr + 1, curr) + 1;
		}
		int notpick = lis(arr, curr + 1, prev);
		
		
		return dp[curr][prev+1]=Math.max(pick, notpick);

	}

}
