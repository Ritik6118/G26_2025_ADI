package Lec_24;
import java.util.*;

public class Graph {
	HashMap<Integer,HashMap<Integer,Integer>> map;
	
	Graph(){
		map=new HashMap<>();
	}
	
	Graph(int n){
		map=new HashMap<>();
		for(int i=1;i<=n;i++) {
			this.add_vertex(i);
		}
	}
	
	public void add_vertex(int v) {
		map.put(v,new HashMap<>());
	}
	
	public void add_edge(int v1, int v2, int wt) {
		map.get(v1).put(v2, wt);
	}
	
	public void remove_edge(int v1, int v2) {
		map.get(v1).remove(v2);
		map.get(v2).remove(v1);
	}
	
	public void remove_vertex(int v) {
		for(int i:map.get(v).keySet()) {
			this.remove_edge(v, i);
//			map.get(i).remove(v);
		}
		map.remove(v);
	}
	public int getWeight(int v1,int v2) {
		return map.get(v1).get(v2);
	}
	public void setWeight(int v1, int v2, int wt) {
		map.get(v1).put(v2, wt);
	}
	
	HashSet<Integer> vis=new HashSet<>();
	public boolean hasPath_dfs(int src,int des) {
			
		if(src==des) {
			return true;
		}
		if(vis.contains(src)) {
			return false;
		}
		vis.add(src);
		for(int i:map.get(src).keySet()) {
			if(vis.contains(i)==false) {
				if(hasPath_dfs(i,des)) {
					return true;
				}				
			}
		}
		return false;
	}
	
	public boolean hasPath_bfs(int src,int des) {
		Queue<Integer> q=new LinkedList<>();
		HashSet<Integer> vis =new HashSet<>();
		
		q.add(src);
		while(!q.isEmpty()) {
			int n=q.poll();
			vis.add(n);
			if(n==des) {
				return true;
			}
			for(int i:map.get(n).keySet()) {  // loop to iterate on neighbours of n
				if(vis.contains(i)==false) {
					q.add(i);   // adding all the neighbours to queue					
				}
			}
		}
		return false;
		
	}
	public void dft() {
		HashSet<Integer> vis=new HashSet<>();
		Stack<Integer> st=new Stack<>();
		for(int i: map.keySet()) {
			if(vis.contains(i)==false) {
				st.add(i);
				while(!st.isEmpty()) {
					int n=st.pop();
					System.out.println(n);
					vis.add(n);
					
					for(int nn:map.get(n).keySet()) {  // loop to iterate on neighbours of n
						if(vis.contains(nn)==false) {
							st.push(nn);   // adding all the neighbours to queue					
						}
					}
				}
			}
		}
	}
	
	public void bft() {
		HashSet<Integer> vis=new HashSet<>();
		Queue<Integer> q=new LinkedList<>();
		for(int i: map.keySet()) {
			if(vis.contains(i)==false) {
				q.add(i);
				while(!q.isEmpty()) {
					int n=q.poll();
					System.out.println(n);
					vis.add(n);
					
					for(int nn:map.get(n).keySet()) {  // loop to iterate on neighbours of n
						if(vis.contains(nn)==false) {
							q.add(nn);   // adding all the neighbours to queue					
						}
					}
				}
			}
		}
	}
	public int component_count() {
		// same code of bft
		HashSet<Integer> vis=new HashSet<>();
		Queue<Integer> q=new LinkedList<>();
		int c=0; // count for components
		for(int i: map.keySet()) {
			if(vis.contains(i)==false) {
				q.add(i);
				while(!q.isEmpty()) {
					int n=q.poll();
//					System.out.println(n);
					vis.add(n);
					
					for(int nn:map.get(n).keySet()) {  // loop to iterate on neighbours of n
						if(vis.contains(nn)==false) {
							q.add(nn);   // adding all the neighbours to queue					
						}
					}
				}
				c++; 
			}
		}
		return c;
	}
	
	public int cout_cycle() {
		// same code of bft
				HashSet<Integer> vis=new HashSet<>();
				Queue<Integer> q=new LinkedList<>();
				int c=0; // count for cycles
				for(int i: map.keySet()) {
					if(vis.contains(i)==false) {
						q.add(i);
						while(!q.isEmpty()) {
							int n=q.poll();
							if(vis.contains(n)) {
								c++;
								continue;
							}
//							System.out.println(n);
							vis.add(n);
							
							for(int nn:map.get(n).keySet()) {  // loop to iterate on neighbours of n
								if(vis.contains(nn)==false) {
									q.add(nn);   // adding all the neighbours to queue					
								}
							}
						}
					}
				}
				return c;
	}
	public void display() {
		System.out.println(map);
	}
}
