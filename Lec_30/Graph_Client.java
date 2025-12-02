package Lec_30;

public class Graph_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(7);

		g.add_edge(1, 3, 1);
		g.add_edge(1, 2, 2);
		g.add_edge(2, 4, 2);
		g.add_edge(3, 4, 4);
		g.add_edge(4, 5, 2);
		g.add_edge(5, 6, 2);
		g.add_edge(5, 7, 6);
		g.add_edge(6, 7, 1);
		g.add_edge(2, 1, 2);
		g.add_edge(3, 1, 3);
		g.add_edge(4, 2, 4);
		g.add_edge(4, 3, 1);
		g.add_edge(5, 4, 6);
		g.add_edge(6, 5, 8);
		g.add_edge(7, 6, 2);
		g.add_edge(7, 5, 9);
//		System.out.println(g.component_count());
//		System.out.println(g.cout_cycle());
//		g.dft();
//		g.bft();
//		g.display();
		
//		g.dij(1);
		g.display();
		System.out.println(g);
		g.prims();
	}

}
