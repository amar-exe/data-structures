package ba.edu.ibu;


public class HeapSort {
	
	public static void sort(IPAddress[] ipAddresses) {
		BinaryHeap<IPAddress> binaryHeap = new BinaryHeap<IPAddress>();

		for (int i = 0; i < ipAddresses.length; i++) {
			binaryHeap.insert(ipAddresses[i]);
		}

		for (int i = ipAddresses.length - 1; i >= 0; i--) {
			ipAddresses[i] = binaryHeap.delMax();
		}
	}
}
