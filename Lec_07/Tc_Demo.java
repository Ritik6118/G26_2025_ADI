package Lec_07;

public class Tc_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long st=System.currentTimeMillis();
		int a=0;
		int b=1;
		int n=1000000;
		for(int i=0;i<n;i++) {
			int c=a+b;
			a=b;
			b=c;
		}
		long et=System.currentTimeMillis();
		System.out.println(et-st);
		
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				// constant work
			}
		}
		
		// n^2
		 
		for(int i=0;i<n;i++) {       // n operations
			for(int j=0;j<i;j++) {   // sum of n natural numbers 
 				// constant work
			}
		}
		
		//  n^2
		
		
		
	}

}
