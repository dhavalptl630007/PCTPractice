package Geeks;

import java.util.Scanner;

class Nod1 {
	int data;
	Nod1 left;
	Nod1 right;

	Nod1(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}

public class Diameter {


		public static void main(String[] args) {

			Nod1 root = null;
			Scanner sc = new Scanner(System.in);
			int numOfNod1s = Integer.parseInt(sc.nextLine());
		

			String arr[] = sc.nextLine().split("\\s+");
		

			if (numOfNod1s >= 1 && arr.length >= 1) {

				root = new Nod1(Integer.parseInt(arr[0]));

				for (int i = 1; i < numOfNod1s; i++) {

					createTree(root, Integer.parseInt(arr[i]));
				}

			}
			
			
	     int fd =  Diameter(root);
	     
	     System.out.println(fd);
		   
		//	preorderTraversal(root);
			

		}

		

		private static int Diameter(Nod1 root) {
			
			if(root == null) {
				return 0;
			}
			
			int left_height = height(root.left);
			int right_height = height(root.right);
			
			int ldiameter = Diameter(root.left);
			int rdiameter = Diameter(root.right);
			
			return Math.max (left_height+right_height+1, Math.max(ldiameter,rdiameter));
			
		}



		private static int height(Nod1 root) {
			
			if(root == null)
			{
				return -1;	
			}
			
			return 1 + Math.max(height(root.left),height(root.right));
		}



		private static void preorderTraversal(Nod1 root) {
			
			if(root == null) {
				return;
			}
			
			System.out.print(root.data+ " ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
			
		}

		private static void createTree(Nod1 root, int data) {

			if (root == null) {
				return;
			}

			Nod1 node = new Nod1(data);

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


