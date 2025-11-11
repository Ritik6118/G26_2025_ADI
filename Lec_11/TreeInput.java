package Lec_11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeInput {
	
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Node root=CreateTree();
//		int n=sc.nextInt();
//		Node root=CreateTreeInt(n);
		Node root=CreateTreeLevelOrder();
		display(root);
	}

	// 10 20 30 40 50 -1 60 -1 -1 -1 -1 70 -1 -1 -1
	private static Node CreateTreeLevelOrder() {
		// TODO Auto-generated method stub
		Queue<Node> q=new LinkedList<>();
		int n=sc.nextInt();
		Node nn=new Node (n);
		q.add(nn);
		while(!q.isEmpty()) {
			Node nd=q.poll();
			int l=sc.nextInt();
			if(l!=-1) {
				Node ln=new Node(l);
				nd.left=ln;
				q.add(ln);
			}
			int r=sc.nextInt();
			if(r!=-1) {
				Node rn=new Node(r);
				nd.right=rn;
				q.add(rn);
			}
		}
		return nn;
	}


	// 10 20 40 -1 -1 50 -1 -1 30 -1 60 70 -1 -1 -1
	private static Node CreateTreeInt(int n) {
		// TODO Auto-generated method stub
		Node nn=new Node(n);
		int l=sc.nextInt();
		if(l!=-1) {
			nn.left=CreateTreeInt(l);
		}
		int r=sc.nextInt();
		if(r!=-1) {
			nn.right=CreateTreeInt(r);
		}
		return nn;
	}

	private static void display(Node root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
		String l="Null";
		if(root.left!=null) {
			l=""+root.left.val;
		}
		String r="Null";
		if(root.right!=null) {
			r=""+root.right.val;
		}
		System.out.println(l+" <- "+root.val+" -> "+r);
		display(root.left);
		display(root.right);
	}

	private static Node CreateTree() {
		// TODO Auto-generated method stub
		int n=sc.nextInt();
		Node nn=new Node(n);
		
		boolean hlc=sc.nextBoolean();
		if(hlc) {
			nn.left=CreateTree();
		}
		boolean hrc=sc.nextBoolean();
		if(hrc) {
			nn.right=CreateTree();
		}
		return nn;
	}

}

class Node {
	int val;
	Node left;
	Node right;

	Node(int v) {
		val = v;
	}

	Node() {

	}
}