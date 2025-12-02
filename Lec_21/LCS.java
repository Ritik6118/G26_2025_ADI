package Lec_21;

public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abde";
		String s2 = "abcde";
		System.out.println(lcs(s1, s2));
	}

	static Integer[][] dp;
	private static int lcs(String s1, String s2) {
		// TODO Auto-generated method stub
		dp=new Integer[s1.length()][s2.length()];
		return solve(s1, s2, 0, 0);
	}

	private static int solve(String s1, String s2, int i, int j) {
		// TODO Auto-generated method stub

		if (i == s1.length() || j == s2.length()) {
			return 0;
		}
		if(dp[i][j]!=null) {
			return dp[i][j];
		}
		
		int common = 0;
		int notcommon = 0;
		if (s1.charAt(i) == s2.charAt(j)) {
			common = solve(s1, s2, i + 1, j + 1) + 1;
		} else {
			notcommon = Math.max(solve(s1, s2, i + 1, j), solve(s1, s2, i, j + 1));
		}

		return dp[i][j]=Math.max(common, notcommon);
	}

}
