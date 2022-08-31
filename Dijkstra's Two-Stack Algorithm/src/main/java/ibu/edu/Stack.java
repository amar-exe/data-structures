package ibu.edu;

public class Stack<Item> {
    private Node<Item> top = null;
    private int size = 0;


    /* Push an item onto the stack */
    public void push(Item item) {
        Node<Item> newNode = new Node<Item>();      // 1
        newNode.data = item;
        newNode.next=top;// 1
        top=newNode;
        size++;

    }

    /* Check if the stack is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Remove the top item from the stack, and return its data */
    public Item pop() {



        if (top == null) {                                                     // 1
            throw new IndexOutOfBoundsException("The linked list is empty.");   // 1
        }     // 1
        Item data=top.data;
        top = top.next;                                                       // 2
        size--;                                                                 // 3

        return data;
    }


    /* Return the current size of the stack */
    public int size() {

        return size;
    }
}