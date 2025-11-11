package Lec_17;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Non_Overlapping_Intervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] intervals= {{1,2},{2,3},{3,4},{1,3}};
		System.out.println(eraseOverlapIntervals(intervals));
	}

	public static  int eraseOverlapIntervals(int[][] intervals) {
		PriorityQueue<interval> pq=new PriorityQueue<interval>(new Comparator<interval>() {

			@Override
			public int compare(interval i1, interval i2) {
				// TODO Auto-generated method stub
				return i1.ed-i2.ed;
			}
		});
		
		for(int [] arr: intervals) {
			pq.add(new interval(arr[0],arr[1]));
		}
		
		int ed=Integer.MIN_VALUE;
		int c=0;
		
		while(!pq.isEmpty()) {
			interval i=pq.poll();
			if(i.st>=ed) {
				ed=i.ed;
				c++;
			}
		}
		return intervals.length-c;
	}

}
class interval{
	int st;
	int ed;
	
	interval(int s,int e){
		st=s;
		ed=e;
	}
}
