package Lec_08;

public class MaximizeConfusion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxConsecutiveAnswers("TFFT",1));
	}

	public static int maxConsecutiveAnswers(String s, int k) {
		return Math.max(maximize(s,k,'T'),maximize(s,k,'F'));
	}

	private static int maximize(String s, int k, char ch) {
		// TODO Auto-generated method stub
		int si=0;
		int ei=0;
		int ans=0;
		
		while(ei<s.length()) {
			if(s.charAt(ei)!=ch) {
				k--;
			}
			while(si<ei && k<0) {
				if(s.charAt(si)!=ch) {
					k++;
				}
				si++;
			}
			ans=Math.max(ans, ei-si+1);
			ei++;
		}
		
		return ans;
	}

}
