package Lec_30;
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
//		map.get(v2).remove(v1);
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
	
	public void prims() {
		PriorityQueue<Ppair> pq=new PriorityQueue<>(new Comparator<Ppair>() {

			@Override
			public int compare(Ppair p1, Ppair p2) {
				// TODO Auto-generated method stub
				return p1.cost-p2.cost;
			}
		});
		
		pq.add(new Ppair(1,1,0));
		
		HashSet<Integer> vis=new HashSet<>();
		while(!pq.isEmpty()) {
			Ppair p=pq.poll();
			if(vis.contains(p.vtx)==true) {
				continue;
			}
			vis.add(p.vtx);
			System.out.println(p);
			for(int i:map.get(p.vtx).keySet()) {
				Ppair np=new Ppair(i,p.vtx,map.get(p.vtx).get(i));
				pq.add(np);
			}
		}
		
	}
	
	public void dij(int src) {
		// TODO Auto-generated method stub
		HashSet<Integer> vis=new HashSet<>();
		PriorityQueue<dpair> pq=new PriorityQueue<>(new Comparator<dpair>() {

			@Override
			public int compare(dpair o1, dpair o2) {
				// TODO Auto-generated method stub
				return o1.cost-o2.cost;
			}
		});
		pq.add(new dpair(src,"",0));   // pair for src vtx
		
		while(!pq.isEmpty()) {
			dpair p=pq.poll();
			if(vis.contains(p.v)) {
				continue;
			}
			System.out.println(p);
			vis.add(p.v);
			
			for(int i:map.get(p.v).keySet()) {
				dpair np=new dpair(i,p.path+"->"+p.v,p.cost+map.get(p.v).get(i));
				pq.add(np);
			}
		}
	}
}
class dpair{
	int v;
	String path;
	int cost;
	dpair(){
		
	}
	dpair(int v,String p,int c){
		this.v=v;
		this.path=p;
		this.cost=c;
	}
	
	public String toString() {
		return v+ " via path -> "+ path +" @ cost ->"+cost ;
	}
}

class Ppair{    // prims pair
 	int vtx;
 	int aqvtx;
 	int cost;
 	
 	Ppair(int v,int av,int c){
 		vtx=v;
 		aqvtx=av;
 		cost=c;
 	}
 	
 	Ppair(){
 		
 	}
 	
 	public String toString() {
 		return "acquired vtx->" +vtx+" via ->" +aqvtx+" with cost -> "+cost;
 	}
}