
/*

Given a linked list with a length of 2*n 

a1 -> a2 -> a3 ... => an -> b1 -> b2 -> b3 ... -> bn

Rearrange the list to 

a1 -> b1 -> a2 -> b2 -> ... -> an -> bn

You can assume the length of linked list is even.
However, you do not know the length of the linked list.
 */

public class RearrangeLinkedList{

    public static void RearrangeNode(Node head){

        if (head == null){
            return;
        }

        // split the list to half
        Node slow = head;
        Node fast = head;

        // O(n/2)
        while(fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // rearrange the list
        Node aptr = head;
        Node afptr = aptr.next;
        Node bptr = slow.next;
        Node bfptr = bptr.next;

        // O(n)
        while(bptr != null){
            aptr.next = bptr;
            if (bfptr != null) bptr.next = afptr;

            aptr = afptr;
            afptr = aptr.next;
            bptr = bfptr;
            if (bptr == null) break;
            bfptr = bptr.next;
        }

    }

    public static void main(String[] args){
        Node test1 = new Node(1);
        for (int i = 2; i <= 10; i++){
            test1.insert(new Node(i));
        }

        Node test2 = new Node(1);
        for (int i = 2; i <= 4; i++){
            test2.insert(new Node(i));
        }

        Node test3 = new Node(1);
        test3.insert(new Node(2));

        System.out.println("Test Case 1");
        test1.printList();
        RearrangeNode(test1);
        test1.printList();

        System.out.println("Test Case 2");
        test2.printList();
        RearrangeNode(test2);
        test2.printList();

        System.out.println("Test Case 3");
        test3.printList();
        RearrangeNode(test3);
        test3.printList();

        RearrangeNode(null);
    }
}

class Node{

    int value;
    Node next;

    public Node(int value){
        this.value = value;
        this.next = null;
    }

    public void insert(Node node){
        Node curr = this;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = node;
    }

    public void printList(){
        Node curr = this;
        do{
            System.out.print(curr.value);
            System.out.print(" -> ");

            curr = curr.next;
        }while(curr != null);
        System.out.println();
    }
}