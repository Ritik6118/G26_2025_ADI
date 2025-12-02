package Lec_23;
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
	public boolean hasPath(int v1,int v2) {
		
	}
	
	public void display() {
		System.out.println(map);
	}
}
