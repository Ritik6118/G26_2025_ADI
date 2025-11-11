package Lec_15;

public class code_To_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="11106";
		solve(s,"");
	}

	private static void solve(String s, String ans) {
		// TODO Auto-generated method stub
		if(s.length()==0) {
			System.out.println(ans);
			return;
		}
		
		int a=s.charAt(0)-'0';
		if(a==0) {
			return;
		}
//		System.out.println(a);
		if(a>0) {
			char ch=(char)(a+'a'-1);
			
			solve(s.substring(1),ans+ch);			
		}
		if(s.length()>=2) {
			int n=Integer.parseInt(s.substring(0, 2));
			char c=(char)(n+'a'-1);
			if(n<=26) {
				solve(s.substring(2),ans+c);				
			}
		}
	}

}
