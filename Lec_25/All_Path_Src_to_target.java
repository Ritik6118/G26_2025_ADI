package Lec_25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;



public class All_Path_Src_to_target {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [][] graph= {{1,2},{3},{3},{}};
		int [][] graph= {{4,3,1},{3,2,4},{3},{4},{}};
		System.out.println(allPathsSourceTarget(graph));
	}

	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
		for(int i=0;i<graph.length;i++) {
			map.put(i, new HashSet<>());
			for(int j=0;j<graph[i].length;j++) {
				map.get(i).add(graph[i][j]);
			}
		}
		List<List<Integer>> ans=new ArrayList<>();
		return findAll(map,0,graph.length-1,ans);
		
	}
	static List<Integer> li=new ArrayList<>();
	private static List<List<Integer>> findAll(HashMap<Integer, HashSet<Integer>> map, int src, int des, List<List<Integer>> ans) {
		// TODO Auto-generated method stub
		if(src==des) {
			li.add(src);
			ans.add(new ArrayList<>(li));
			li.remove(li.size()-1);
			return ans;
		}
		
		for(int i:map.get(src)){
			li.add(src);
			findAll(map,i,des,ans);
			li.remove(li.size()-1);
			
		}
		return ans;
	}
}
