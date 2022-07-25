/*Find a pair with a given sum in Binary Search Tree
 *     40
 *     /\
 *    /  \
 *   20  60
 *   /\   /\
 * 10 30 50 70
 * 
 * sum=80
 * 
 */
package com.vm.treesum;
import java.util.ArrayList;
import java.util.List;

public class SumOfNodes {
	 private static int node1;
	    private static int node2;
	    private static List<Integer> list;

	    public static void main(String[] args) {
	        Node root=new Node(40);
	        root.leftNode= new Node(20)	;	
	        root.rightNode=new Node(60);
	        root.leftNode.leftNode=new Node(10);
	        root.leftNode.rightNode=new Node(30);
	        root.rightNode.leftNode=new Node(50);
	        root.rightNode.rightNode=new Node(70);
	    		       

	        if (findNodesInBST(root,80)){
	            System.out.println(node1 +" and "+ node2);
	        }
	        else
	            System.out.println("Pair does not exist");
	    }

	    private static boolean findNodesInBST(Node root, int sum) {
	        list = new ArrayList<>();
	        treeToList(root);
	        int start = 0;
	        int end = list.size() - 1;
	        while (start < end) {
	            int pairSum = list.get(start) + list.get(end);
	            if (pairSum == sum) {
	                node1 = list.get(start);
	                node2 = list.get(end);
	                return true;
	            }
	            else  if (pairSum > sum)
	                end--;
	            else
	                start++;
	        }

	        return false;
	    }

	    private static void treeToList(Node root) {
	        if (root == null)
	            return;
	        treeToList(root.leftNode);
	        list.add(root.nodeData);
	        treeToList(root.rightNode);
	    }
	}


	

