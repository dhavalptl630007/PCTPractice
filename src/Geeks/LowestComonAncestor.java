package Geeks;

import java.util.Scanner;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}

public class LowestComonAncestor {

	public static void main(String[] args) {

		Node root = null;
		Scanner sc = new Scanner(System.in);
		int numOfNodes = Integer.parseInt(sc.nextLine());
	

		String arr[] = sc.nextLine().split("\\s+");
		String arr1[] = sc.nextLine().split("\\s+");

		if (numOfNodes >= 1 && arr.length >= 1) {

			root = new Node(Integer.parseInt(arr[0]));

			for (int i = 1; i < numOfNodes; i++) {

				createTree(root, Integer.parseInt(arr[i]));
			}

		}
		
		
	   Node lca = findLCA(root,Integer.parseInt(arr1[0]),Integer.parseInt(arr1[1]));
		
	   if(lca!=null) {
	   System.out.println(lca.data);
	   }
	   else
	   {
		   System.out.println("None");
	   }
	   
	//	preorderTraversal(root);
		

	}

	private static Node findLCA(Node root, int n1, int n2) {
		
		if(root == null) {
			return null;
		}
		
		if(root.data == n1 || root.data == n2) {
			
			return root;
		}
		
		Node left_lca = findLCA(root.left,n1,n2);
		Node right_lca = findLCA(root.right,n1,n2);
		
		if(left_lca !=null && right_lca !=null) {
			return root;
		}
		
		if(left_lca !=null)
		{
			return left_lca;
		}
		
		else
		{
			return right_lca;
		}
		
	}

	private static void preorderTraversal(Node root) {
		
		if(root == null) {
			return;
		}
		
		System.out.print(root.data+ " ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
		
	}

	private static void createTree(Node root, int data) {

		if (root == null) {
			return;
		}

		Node node = new Node(data);

		if (data < root.data && root.left == null) {

			root.left = node;
			return;
		}

		else if (data > root.data && root.right == null) {

			root.right = node;
			return;
		}

		if (data < root.data && root.left != null) {
			createTree(root.left, data);
		}

		if (data > root.data && root.right != null) {
			createTree(root.right, data);
		}

	}

}
