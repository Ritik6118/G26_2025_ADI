package Lec_05;

import java.util.Arrays;
import java.util.Scanner;

public class Rat_Chases_its_Cheese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt();
		int c=sc.nextInt();
		char[][] arr=new char[r][];
//		System.out.println(arr.length);
		for(int i=0;i<r;i++) {
			arr[i]=sc.next().toCharArray();
		}
//		for(char[] ar:arr) {
//			System.out.println(Arrays.toString(ar));
//		}
		int [][] ans=new int [r][c];
		solve(arr,ans,0,0);
		if(!pathchek) {
			System.out.println("NO PATH FOUND");
		}
		
	}
	static boolean pathchek=false;
	private static void solve(char[][] arr, int[][] ans, int r, int c) {
		// TODO Auto-generated method stub
		if(r<0 || c<0 || r>=arr.length || c>=arr[0].length || arr[r][c]=='X' ||ans[r][c]==1) {
			return;
		}
		if(r==arr.length-1 && c==arr[0].length-1) {
			ans[r][c]=1;
			for(int [] ar: ans) {
				for(int i:ar) {
					System.out.print(i+" ");
				}
				System.out.println();
			}
			ans[r][c]=0;
			pathchek=true;
			return;
		}
		
		
		ans[r][c]=1;
		solve(arr,ans,r+1,c);  // v
		solve(arr,ans,r,c+1);  // >
		solve(arr,ans,r-1,c);  // ^
		solve(arr,ans,r,c-1);  // <
		ans[r][c]=0;
	}

}
