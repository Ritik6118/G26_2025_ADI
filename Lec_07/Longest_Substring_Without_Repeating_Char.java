package Lec_07;

public class Longest_Substring_Without_Repeating_Char {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcabcbb";
		
		int si=0;                  // window initalized
		int ei=0;
		int [] arr=new int[128];  // freq array
		int ans=0;
		while(ei<s.length()) { 
			char ch=s.charAt(ei);   // window's expansion
			arr[ch]++;
			while(si<ei && arr[ch]>1) {   // window's shrinking
				arr[s.charAt(si)]--;
				si++;
			}
			ans=Math.max(ans, ei-si+1);  // calculation of length that is our answer
			ei++;
		}
		System.out.println(ans);
		
	}

}
