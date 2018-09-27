
/*

Write code to remove duplicates from an unsorted linked list. How would you solve this problem if a temporary buffer is not allowed?

*/
public class P01_RemoveDuplicate{
    public static void main(String[] args){
        Node head1 = new Node(1);
        appendNode(head1, new Node(3));
        appendNode(head1, new Node(2));
        appendNode(head1, new Node(3));
        appendNode(head1, new Node(3));

        printNode(head1);

        removeDuplicate2(head1);

        printNode(head1);

        //

        Node head2 = new Node(3);
        appendNode(head2, new Node(3));
        appendNode(head2, new Node(3));
        appendNode(head2, new Node(3));
        appendNode(head2, new Node(3));
        appendNode(head2, new Node(3));

        printNode(head2);
        removeDuplicate2(head2);
        printNode(head2);

        //
        Node head3 = new Node(2);
        appendNode(head3, new Node(4));
        appendNode(head3, new Node(2));
        appendNode(head3, new Node(2));
        appendNode(head3, new Node(4));

        printNode(head3);
        removeDuplicate2(head3);
        printNode(head3);

    }

    public static void appendNode(Node head, Node node){
        Node curr = head;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = node;
    }

    public static void printNode(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(String.format("%s -> ", curr.value));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void removeDuplicate(Node head){
        Node check = head;
        Node curr = head;
        while(curr != null){
            check = head;
            while(check != curr){
                if (check.value == curr.value){
                    check.value = check.next.value;
                    check.next = check.next.next;
                    break;
                }
                check = check.next;
            }
            curr = curr.next;
        }
    }


    public static void removeDuplicate2(Node head){
        Node curr = head;

        while(curr != null){
            Node runner = curr;
            while(runner.next != null){
                if (runner.next.value == curr.value){
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            curr = curr.next;
        }
    }
}
class Node{
    public int value;
    public Node next;

    public Node(int value){
        this.value = value;
    }
}