package ibu.edu.ba.bubblesort;

public class BubbleSort {

    static boolean swapped;

    /* Perform the bubble sort algorithm */
    public static void sort(IPAddress[] elements) {
        for (int i = 0; i < elements.length; i++) {
            for (int j = 1; j < elements.length - i; j++) {
                if (elements[j - 1].ipFrom > elements[j].ipFrom) {
                    swap(elements, j - 1, j);
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    /* Swap two array elements: elements[a] with elements[b] */
    public static void swap(IPAddress[] elements, int a, int b) {
        IPAddress tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
        swapped = true; // a swap has occurred
    }
}
