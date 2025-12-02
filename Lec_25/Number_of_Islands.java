package Lec_25;

import java.util.LinkedList;
import java.util.Queue;

public class Number_of_Islands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numIslands(char[][] arr) {
		boolean [][] vis=new boolean[arr.length][arr[0].length];
		int c=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]=='1' && vis[i][j]==false) {
                    // System.out.println(i+" "+j);
					bfs(arr,i,j,vis);	
					c++;
				}
			}
		}
		return c;
	}

	int [] row= {0,1,0,-1};
	int [] col= {1,0,-1,0};
	
//	r+1,c;
//	c+1,r;
//	r-1,c;
//	c-1,r;
//	
	private void bfs(char[][] arr, int r, int c, boolean[][] vis) {
		// TODO Auto-generated method stub
		Queue<pair> q=new LinkedList<>();
		q.add(new pair(r,c));
		
		while(!q.isEmpty()) {
			pair p=q.poll();
			if(vis[p.r][p.c]==true) {
				continue;
			}
            // System.out.println(p.r+" "+p.c+" <<<<");
			vis[p.r][p.c]=true;
			for(int i=0;i<4;i++) {
				int nr=p.r+row[i];
				int nc=p.c+col[i];
				
				if(nr>=0 && nc>=0 && nr<arr.length && nc<arr[0].length && arr[nr][nc]=='1') {
					q.add(new pair(nr,nc));
				}
			}
		}
	}

}
class pair{
	int r;
	int c;
	
	pair(int r,int c){
		this.r=r;
		this.c=c;
	}
}

