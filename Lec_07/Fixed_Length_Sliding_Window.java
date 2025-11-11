package Lec_07;

public class Fixed_Length_Sliding_Window {

	public static void main(String[] args) {
		// TODO Auto-gener2,3,9ated method stub
		int [] arr= {1,2,3,9,2,8,7,6,5,4,3,2,1};
		int k=3;
		int sum=0;
		
		for(int i=0;i<k;i++) {
			sum+=arr[i];
		}
		int ans=sum;
//		System.out.println(sum);
		int st=0;
		for(int ei=k;ei<arr.length;ei++) {
//			int st=ei-k;
//			System.out.println(sum);
			sum+=arr[ei];
			sum-=arr[st];
//			System.out.println("+="+arr[ei]+" -="+arr[st]+" = "+sum);
			ans=Math.max(ans,sum);
			st++;
		}
		System.out.println(ans);
	}	

}
