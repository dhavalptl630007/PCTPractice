package Geeks;

//create tree using preorder and in order traversal
//https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
//Inorder sequence: D B E A F C
//Preorder sequence: A B D E C F
import java.util.Scanner;

class Node3 {
	String data;
	Node3 left;
	Node3 right;

	Node3(String data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}

public class CreateTreeUsingInPostOrder {

	
	static int prefix = 0;
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		String pre[] = sc.nextLine().split("\\s+");
		String in[] = sc.nextLine().split("\\s+");
		
		int len = in.length;
		prefix = len-1;
	   Node3 root = createTree(pre,in,0,len-1);
	    
	    preorderTraversal(root);
	    inOrderTraversal(root);

		}

	private static void inOrderTraversal(Node3 root) {
		if(root == null) {
			return;
		}
		
	 
	  inOrderTraversal(root.left);
	  System.out.print(root.data+" ");
	  inOrderTraversal(root.right);
		
	}

	private static void preorderTraversal(Node3 root) {
		if(root == null) {
			return;
		}
		
	  System.out.print(root.data+" ");
	  preorderTraversal(root.left);
	  preorderTraversal(root.right);
	  
	}

	private static Node3 createTree(String[] pre, String[] in, int inStart, int inEnd) {
		
		/*base condition */
		if(inStart>inEnd) {
		return null;
		}
		
		  /* Pick current node from Preorder traversal using preIndex 
        and increment preIndex */
		Node3 node = new Node3(pre[prefix--]);
		
		/* If this node has no children then return */
		if(inStart ==inEnd) {
			return node;
		}
		
		/* Else find the index of this node in Inorder traversal */
		 int i = search(node.data,in,inStart,inEnd);
	
		 /* Using index in Inorder traversal, construct left and 
         right subtress */ 
		 node.right = createTree(pre,in,i+1,inEnd);
		node.left = createTree(pre,in,inStart,i-1);
		
	  	
		
		return node;
		
		
	}

	private static int search(String data, String[] in, int start, int end) {
	
		int i;
		for( i = start; i<=end;i++)
		{
			if(in[i].equals(data)) {
				return i;
			}
		}
		return i;
	}
		
	}


