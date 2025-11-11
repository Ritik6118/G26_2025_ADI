package Lec_06;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr= {2,3,6,7};
		int t=7;
		combinationSum(arr,t);
//		System.out.println(ans);
	}
	public static List<List<Integer>> combinationSum(int[] arr, int t) {
        solve(arr,t,0);
        return ans;
    }
	static List<Integer> li=new ArrayList<>();
	static List<List<Integer>> ans=new ArrayList<>();
	private static void solve(int[] arr, int t, int idx) {
		// TODO Auto-generated method stub
		if(t==0) {
			System.out.println(li);
			ans.add(new ArrayList<>(li));
			return;
		}
		if(t<0) {
			return;
		}
		
		for(int i=idx;i<arr.length;i++) {
			li.add(arr[i]);
			solve(arr,t-arr[i],i);
			li.remove(li.size()-1);
		}
	}

}
