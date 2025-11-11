package Lec_15;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FractionalKnapsac {

	public static void main(String[] args) {
		int[] val = { 60, 100, 120 }; // {100,120,60}
		int[] wt = { 10, 20, 30 }; // {20,30,60}
		int cap = 50;
		System.out.println(solve(val, wt, cap));
	}

	private static double solve(int[] val, int[] wt, int cap) {
		// TODO Auto-generated method stub
		PriorityQueue<item> pq = new PriorityQueue<>(new Comparator<item>() {

			@Override
			public int compare(item o1, item o2) {
				// TODO Auto-generated method stub
				double v1 = ((double) o1.val) / ((double) o1.wt);
				double v2 = ((double) o2.val) / ((double) o2.wt);

				return (int) v2 - (int) v1;

//				if(v2>v1) {
//					return 1;
//				}
//				else if(v2==v1) {
//					return 0;
//				}
//				else {
//					return -1;
//				}
			}
		});

		for (int i = 0; i < val.length; i++) {
			pq.add(new item(val[i], wt[i]));
		}
//		while(!pq.isEmpty()) {
//			System.out.println(pq.poll());
//		}
//		System.out.println(pq);
		double ans = 0;
		while (!pq.isEmpty()) {
			item i = pq.poll();
			if (cap >= i.wt) {
				ans += i.val;
				cap -= i.wt;
			} else {
				double v = ((double) i.val) / ((double) i.wt);
				ans += cap * v;
				break;
			}
//			System.out.println(ans);
		}

		return ans;
	}

}

class item {
	int val;
	int wt;

	item(int v, int w) {
		this.val = v;
		this.wt = w;
	}

	item() {

	}

	@Override
	public String toString() {
		return val + "<>" + wt;
	}
}
