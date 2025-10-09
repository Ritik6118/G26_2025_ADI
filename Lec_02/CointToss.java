package Lec_02;

public class CointToss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
//		toss(n, "");
//		System.out.println(tossCount(n, ""));
		tossWithoutRepeatingH(5,"");
		
	}

	private static void toss(int n, String ans) {
		// TODO Auto-generated method stub
		if (n == 0) {
			System.out.println(ans);
			return;
		}

		toss(n - 1, ans + "H");
		toss(n - 1, ans + "T");

	}

	private static void tossWithoutRepeatingH(int n, String ans) {
		// TODO Auto-generated method stub
		if (n == 0) {
			System.out.println(ans);
			return;
		}

		if (ans.length() == 0 || ans.charAt(ans.length() - 1) == 'T') {
			tossWithoutRepeatingH(n - 1, ans + "H");
			tossWithoutRepeatingH(n - 1, ans + "T");
		} else {
			tossWithoutRepeatingH(n - 1, ans + "T");
		}
	}
	private static int tossCount(int n, String ans) {
		// TODO Auto-generated method stub
		if (n == 0) {
			System.out.println(ans);
			return 1;
		}
		
		int a = tossCount(n - 1, ans + "H");
		int b = tossCount(n - 1, ans + "T");
		return a + b;
	}

}
