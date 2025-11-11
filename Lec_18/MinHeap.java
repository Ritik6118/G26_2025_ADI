package Lec_18;

import java.util.ArrayList;

public class MinHeap {
	
	ArrayList<Integer> li=new ArrayList<>();
	
	public void add(int n) {
		li.add(n);
		upheapify(li.size()-1);
	}
	
	private void upheapify(int n) {
		// TODO Auto-generated method stub
		if(n==0) {
			return;
		}
		int p=getP(n);
//		System.out.println(p+" "+n);
		if(li.get(p)>li.get(n)) {
			swap(p,n);
			upheapify(p);
		}
	}

	public int poll() {
		if(li.size()==0) {
			return -1;
		}
		
		int temp=li.get(0);
		swap(0,li.size()-1);
		li.remove(li.size()-1);
		downheapify(0);
		return temp;
	}
	
	
	private void downheapify(int i) {
		// TODO Auto-generated method stub
		int min=i;
		int lc=getLC(i);
		int rc=getrC(i);
		
		if(lc<li.size() && li.get(lc)<li.get(min)) {
			min=lc;
		}
		if(rc<li.size() && li.get(rc)<li.get(min)) {
			min=rc;
		}
		
		if(min!=i) {
			swap(min,i);
			downheapify(min);
		}
	}

	private void swap(int i,int j) {
		int temp=li.get(i);
		li.set(i, li.get(j));
		li.set(j, temp);
	}
	
	private int getLC(int i) {
		return (i*2)+1;
	}
	private int getrC(int i) {
		return (i*2)+2;
	}
	private int getP(int i) {
		return (i-1)/2;
	}
}
