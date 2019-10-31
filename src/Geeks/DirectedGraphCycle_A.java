package Geeks;

/*

understanding check -- https://www.youtube.com/watch?v=AK7BuT5MgU0

input
5
6
a b
a c
b c
b d
d e
e b

output


 */

/*
5
6
a c
c b
b a
b d
d e
e b
[b, d, e]
[a, c, b]
2
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

public class DirectedGraphCycle_A {

	private static Map<String, ArrayList<String>> map = new HashMap<>();
	private static List<String> visitedList = new ArrayList<>();
	private static Stack<String> stack = new Stack<String>();
	// private static String parent;
	private static Map<String, Integer> nodeFlag = new HashMap<>();
	private static boolean isCycleDetected = false;
	private static int cycleCount = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numberOfVertices = Integer.parseInt(sc.nextLine());
		int numberofEdges = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < numberofEdges; i++) {

			String[] strings = sc.nextLine().split("\\s+");

			addEdgesToGraph(strings[0], strings[1]);

		}

		initializeNodes();
		
		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
			
			String startNode = entry.getKey();
			
			 if(!visitedList.contains(startNode)) {
				 
				 DFSTraversal(startNode,startNode);
			 }		
			
		}

		System.out.println(cycleCount);
		
		
	}

	private static void DFSTraversal(String node, String startNode) {

		visitedList.add(node);
		nodeFlag.put(node, 0);
		stack.push(node);

		ArrayList<String> adjacentNodes = map.get(node);

		if (adjacentNodes != null) {
			for (String adjacentNode : adjacentNodes) {

				if (!visitedList.contains(adjacentNode)) {

					DFSTraversal(adjacentNode, startNode);
				}
			}

		}
		
		if (adjacentNodes != null) {
			for (String adjacentNode : adjacentNodes) {

				if (nodeFlag.get(adjacentNode) == 0) {

					cycleCount++;
					printCycle(node,adjacentNode);
				}
			}

		}
		
		
		
		

		stack.pop();
		
		if(stack.isEmpty()) {
			stack.push(startNode);
		}
		
		nodeFlag.put(node, 1);	
		
	}

	private static void printCycle(String node, String adjacentNode) {
	
		Stack<String> copyStack = (Stack<String>) stack.clone();
		String lastElement = copyStack.lastElement();
		ArrayList<String> list = new ArrayList<String>();
		list.add(lastElement);
		while(!adjacentNode.equals(lastElement)) {
			
			copyStack.pop();
			lastElement = copyStack.lastElement();
			list.add(lastElement);
		}
		
		Collections.reverse(list);
		System.out.println(list);	
		
	}

	private static void initializeNodes() {

		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {

			String key = entry.getKey();
			nodeFlag.put(key, -1);

			ArrayList<String> list = entry.getValue();

			if (list != null) {
				for (String string : list) {
					nodeFlag.put(string, -1);
				}

			}
		}
		
	}

	private static void addEdgesToGraph(String stra, String strb) {

		if (map.containsKey(stra)) {
			map.get(stra).add(strb);
		} else {
			ArrayList<String> al = new ArrayList<>();
			al.add(strb);
			map.put(stra, al);
		}

	}

}
