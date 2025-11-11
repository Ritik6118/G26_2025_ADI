package Lec_05;

import java.util.ArrayList;

public class BackTrack_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> li=new ArrayList<>();
		long l=0l;
		demo(li,l,10);
//		System.out.println(l);
//		System.out.println(li);
	}

	private static void demo(ArrayList<Integer> li, long l, int n) {
		// TODO Auto-generated method stub
		if(n==0) {
			System.out.println(l);
			System.out.println(li);
			return;
		}
		
		li.add(n);
		demo(li,(l*10)+n,n-1);
		li.remove(li.size()-1);
	}

}
