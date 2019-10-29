package Geeks;

import java.util.ArrayList;
import java.util.Scanner;

class Nod4 {
	int data;
	Nod4 left;
	Nod4 right;

	Nod4(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}

public class FindPathInTree {

static ArrayList<String> localpath = new ArrayList<String>();

		public static void main(String[] args) {

			Nod4 root = null;
			Scanner sc = new Scanner(System.in);
			int numOfNod4s = Integer.parseInt(sc.nextLine());
		

			String arr[] = sc.nextLine().split("\\s+");
		

			if (numOfNod4s >= 1 && arr.length >= 1) {

				root = new Nod4(Integer.parseInt(arr[0]));

				for (int i = 1; i < numOfNod4s; i++) {

					createTree(root, Integer.parseInt(arr[i]));
				}

			}
			
		  printAllPath(root);	
			

		}

		

		private static void printAllPath(Nod4 root) {
			
		  if(root == null)
		  {
			
			  return;
		  }
		  
		  localpath.add(Integer.toString(root.data));
		  System.out.print(root.data+" ");
		  if (root.left == null && root.right == null) {
			  System.out.println(localpath);
			 localpath.remove(Integer.toString(root.data));
		  }
		
		  printAllPath(root.left);
		  printAllPath(root.right);
		  
		  localpath.remove(Integer.toString(root.data));
		  
		}



		private static void createTree(Nod4 root, int data) {

			if (root == null) {
				return;
			}

			Nod4 node = new Nod4(data);

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


