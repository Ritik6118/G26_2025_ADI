package Lec_18;

public class Min_Heap_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap m=new MinHeap();
		m.add(3);
		m.add(2);
		m.add(1);
		
		System.out.println(m.poll());
		System.out.println(m.poll());
		System.out.println(m.poll());
	}

}
