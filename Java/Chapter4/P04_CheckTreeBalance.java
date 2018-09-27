
public class P04_CheckTreeBalance{
    public static void main(String[] args){
        Node tree1 = new Node(10);
        tree1.insert(5);

        System.out.print("Should be True: ");
        System.out.println(IsBalance(tree1));

        tree1.insert(3);
        System.out.print("Should be False: ");
        System.out.println(IsBalance(tree1));

        tree1.insert(7);
        System.out.print("Should be False: ");
        System.out.println(IsBalance(tree1));

        tree1.insert(15);
        System.out.print("Should be True: ");
        System.out.println(IsBalance(tree1));

        tree1.insert(13);
        System.out.print("Should be True: ");
        System.out.println(IsBalance(tree1));

        tree1.insert(17);
        System.out.print("Should be True: ");
        System.out.println(IsBalance(tree1));
    }

    public static boolean IsBalance(Node root){
        return DFT(root) >= 0;
    }

    public static int DFT(Node curr){
        if (curr == null) return 0;

        int h_left = DFT(curr.left);
        if (h_left == -1) return -1;
        int h_right = DFT(curr.right);
        if (h_right == -1) return -1;
        int diff = h_left - h_right;
        if (diff > 1 || diff < -1) return -1;
        return Math.max(h_left, h_right) + 1;
    }
}

class Node{
    public int value;
    public Node left;
    public Node right;

    public Node(int value){
        this.value = value;
    }

    public void insert(int value){
        if (value > this.value){
            if (right == null){
                right = new Node(value);
            } else {
                right.insert(value);
            }
        } else {
            if (left == null){
                left = new Node(value);
            } else {
                left.insert(value);
            }
        }
    }

    public void printInOrder(Node root){
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(String.format("%d ", root.value));
        printInOrder(root.right);
    }
}