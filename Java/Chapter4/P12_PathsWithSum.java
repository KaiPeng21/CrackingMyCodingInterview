import java.util.*;

public class P12_PathsWithSum{
    
     public static int ct = 0;
     public static int sum = 0;
    
     public static void main(String []args){
        
        Node n1 = new Node(3);
        Node n2 = new Node(-1);
        Node n3 = new Node(-5);
        Node n4 = new Node(1);
        Node n5 = new Node(-2);
        Node n6 = new Node(4);
        Node n7 = new Node(4);
        Node n8 = new Node(-2);
        Node n9 = new Node(2);
        Node n10 = new Node(1);
        Node n11 = new Node(3);
        Node n12 = new Node(8);
        
        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        n4.left = n5;
        n4.right = n6;
        n1.right = n7;
        n7.left = n8;
        n8.right = n9;
        n9.left = n10;
        n9.right = n11;
        n7.right = n12;
        
        int k = 7;
        int methods = findPathNumbers(n1, k);
        System.out.println(methods);
        
        Node t1 = new Node(10);
        Node t2 = new Node(5);
        Node t3 = new Node(3);
        Node t4 = new Node(3);
        Node t5 = new Node(-2);
        Node t6 = new Node(1);
        Node t7 = new Node(2);
        Node t8 = new Node(-3);
        Node t9 = new Node(11);
        t1.left = t2;
        t2.left = t3;
        t3.left = t4;
        t3.right = t5;
        t2.right = t6;
        t6.right = t7;
        t1.right = t8;
        t8.right = t9;
        
        k = 8;
        methods = findPathNumbers(t1, k);
        System.out.println(methods);
     }
     
     public static int findPathNumbers(Node root, int k){
         ct = 0;
         sum = 0;
         HashMap<Integer, Integer> prevSum = new HashMap<Integer, Integer>();
         prevSum.put(0, 1);
         
         DFT(root, k, prevSum);
         return ct;
     }
     
     public static void DFT(Node n, int k, HashMap<Integer, Integer> prevSum){
         
         if (n == null){
             return;
         }
         
         sum += n.val;
         if (prevSum.containsKey(sum - k)){
             ct += prevSum.get(sum - k);
         }
         
         prevSum.put(sum, prevSum.getOrDefault(sum, 0) + 1);
         
         DFT(n.left, k, prevSum);
         DFT(n.right, k, prevSum);
         
         sum -= n.val;
         prevSum.put(sum, prevSum.get(sum) - 1);
     }
}

class Node{
    public int val;
    public Node left;
    public Node right;
    
    public Node(int val){
        this.val = val;
    }
}