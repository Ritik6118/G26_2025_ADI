package Lec_03;

public class Path_Dice_n_faced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		int d=6;
		
		solve(n,d,"");
	}

	private static void solve(int n, int d, String ans) {
		// TODO Auto-generated method stub
		if(d==0) {
			System.out.println(ans);
			return;
		}
		if(d<0) {
			return;
		}
		for(int i=1;i<=n;i++) {
			solve(n,d-i,ans+i+" ");
		}
		
	}

}
