package Lec_16;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Furtherest_Building_u_can_reach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {4,12,2,7,3,18,20,3,19};
		int b=10;
		int l=2;
		System.out.println(solve(arr,b,l));
	}

	private static int solve(int[] arr, int b, int l) {
		// TODO Auto-generated method stub
		
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder()); // max heap
		int i=0;
		
		while(i<arr.length-1) {
			if(arr[i]-arr[i+1]>=0) {
				i++;
			}
			else {
				if(b>0 && arr[i+1]-arr[i]<=b) {
					// i will use bricks
					b-=arr[i+1]-arr[i];
					pq.add(arr[i+1]-arr[i]);
					i++;
					
				}
				else if(l>0) {
					// i will use ladders but optimally
					if(!pq.isEmpty() && pq.peek()>arr[i+1]-arr[i]) {
						// yha pe laddre use nahi krni chiye muje peeche ladder use krni chaiye thi 
						l--;
						b+=pq.poll();
					}
					else {
						// yha pe ladder hi use hongi 
						l--;
						i++;
					}
					
				}
				else {
					// i can not move further
					break;
				}
			}
		}
		return i;
	}

}
