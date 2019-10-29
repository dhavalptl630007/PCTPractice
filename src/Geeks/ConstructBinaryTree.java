package Geeks;

/*
 * input : 1 2 3 4 5 6 7 8
 * output : 1 2 4 8 5 3 6 7
 *          8 4 2 5 1 6 3 7
 * input :1 2 3 4 5 6 6 6 6
          1 2 4 6 6 5 3 6 6 
          6 4 6 2 5 1 6 3 6 
 *        
 */

import java.util.Scanner;

class Node6{
	
int data;
Node6 left;
Node6 right;


Node6(int data){
	
	this.data = data;
	this.left = null;
	this.right = null;
	
}

	
}

public class ConstructBinaryTree {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	String arr[] = sc.nextLine().split("\\s+");
	
	int data = Integer.parseInt(arr[0]);

	
	Node6 root=	constructBinaryTree(arr,0);
		
		preorder(root);
		System.out.println();
		inorder(root);
			
	}	

	private static void inorder(Node6 root) {
		// TODO Auto-generated method stub
		
		if(root == null) {
			return;
		}
		
		inorder(root.left);
		System.out.print(root.data+ " ");
		inorder(root.right);
		
	}

	private static Node6 constructBinaryTree( String[] arr, int i) {
		
		Node6 root = null;
		if(i<arr.length) {
			
		 root = new Node6(Integer.parseInt(arr[i]));
			
		
			root.left = constructBinaryTree(arr,2*i+1);
			root.right = constructBinaryTree(arr,2*i+2);
					
		}
		
		
		return root;	
		
	}

	

	private static void preorder(Node6 root) {
	
		if(root == null) {
			return;
		}
		System.out.print(root.data+ " ");
		preorder(root.left);
		preorder(root.right);
		
	}

}
