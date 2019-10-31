package Geeks;

//create tree using preorder and in order traversal
//https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
//Preorder sequence: A B D E C F
//Inorder sequence: D B E A F C

/*
 pre: A B D E C F 
in : D B E A F C 
post : D E B F C A 
*/
//
import java.util.Scanner;

class Node2 {
	String data;
	Node2 left;
	Node2 right;

	Node2(String data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}

public class CreateTreeUsingInPreOrder {

	
	static int prefix = 0;
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		String pre[] = sc.nextLine().split("\\s+");
		String in[] = sc.nextLine().split("\\s+");
		
		int len = in.length;

	   Node2 root = createTree(pre,in,0,len-1);
	    
	    preorderTraversal(root);
	    System.out.println();
	    inOrderTraversal(root);
	    System.out.println();
	    postOrderTraversal(root);

		}

	private static void postOrderTraversal(Node2 root) {
		// TODO Auto-generated method stub
		
		if(root == null) {
			return;
		}
		
	 
	postOrderTraversal(root.left);
	postOrderTraversal(root.right);
	  System.out.print(root.data+" ");
		
	}

	private static void inOrderTraversal(Node2 root) {
		if(root == null) {
			return;
		}
		
	 
	  inOrderTraversal(root.left);
	  System.out.print(root.data+" ");
	  inOrderTraversal(root.right);
		
	}

	private static void preorderTraversal(Node2 root) {
		if(root == null) {
			return;
		}
		
	  System.out.print(root.data+" ");
	  preorderTraversal(root.left);
	  preorderTraversal(root.right);
	  
	}

	private static Node2 createTree(String[] pre, String[] in, int inStart, int inEnd) {
		
		/*base condition */
		if(inStart>inEnd) {
		return null;
		}
		
		  /* Pick current node from Preorder traversal using preIndex 
        and increment preIndex */
		Node2 node = new Node2(pre[prefix++]);
		
		/* If this node has no children then return */
		if(inStart ==inEnd) {
			return node;
		}
		
		/* Else find the index of this node in Inorder traversal */
		 int i = search(node.data,in,inStart,inEnd);
	
		 /* Using index in Inorder traversal, construct left and 
         right subtress */ 
		node.left = createTree(pre,in,inStart,i-1);
		node.right = createTree(pre,in,i+1,inEnd);
	  	
		
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


