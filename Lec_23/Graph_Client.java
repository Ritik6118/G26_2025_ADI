package Lec_23;

public class Graph_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(7);

		g.add_edge(1, 3, 3);
		g.add_edge(1, 2, 2);
		g.add_edge(2, 1, 2);
		g.add_edge(2, 4, 4);
		g.add_edge(3, 1, 3);
		g.add_edge(3, 4, 1);
		g.add_edge(4, 2, 4);
		g.add_edge(4, 3, 1);
		g.add_edge(4, 5, 6);
		g.add_edge(5, 4, 6);
		g.add_edge(5, 6, 8);
		g.add_edge(5, 7, 9);
		g.add_edge(6, 5, 8);
		g.add_edge(6, 7, 2);
		g.add_edge(7, 6, 2);
		g.add_edge(7, 5, 9);
		
		g.display();
	}

}
