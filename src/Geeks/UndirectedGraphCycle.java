package Geeks;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

public class UndirectedGraphCycle {

	static LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();
	static ArrayList<String> visitedList = new ArrayList<String>();
	static ArrayList<String> cycleChecked = new ArrayList<String>();
	static int cycle = 0;
	static Stack<String> stack = new Stack<String>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numberOfVertices = Integer.parseInt(sc.nextLine());
		int numberofEdges = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < numberofEdges; i++) {

			String[] strings = sc.nextLine().split("\\s+");

			addEdgesToGraph(strings[0], strings[1]);

		}

		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {

			String startNode = entry.getKey();
			if (!visitedList.contains(startNode)) {

				DFSRecursionToFindCycle(startNode, startNode);
			}

		}

		System.out.println(cycle);
		sc.close();

	}

	private static void DFSRecursionToFindCycle(String node, String startNode) {

		visitedList.add(node);
        stack.push(node);
		ArrayList<String> adjacentNodes = map.get(node);

		if (adjacentNodes != null) {

			for (String adjcentNode : adjacentNodes) {

				if (!visitedList.contains(adjcentNode)) {

					DFSRecursionToFindCycle(adjcentNode, startNode);
				}
			}

		}
		
		if (adjacentNodes != null) {
			
			for (String adjcentNode : adjacentNodes) {

				if (visitedList.contains(adjcentNode) && !adjcentNode.equals(getParent(node)) && !cycleChecked.contains(adjcentNode) ) {

					cycle++;
				}
			}
			
			
			
		}
		
		
		
		stack.pop();
		if(stack.isEmpty()) {
			stack.push(startNode);
		}

		cycleChecked.add(node);
	}
	
	private static String getParent(String node) {
		
		Stack<String> copyStack = (Stack<String>) stack.clone();
		
		String topNode = copyStack.pop();
		String parent = null;
		
		if(copyStack.isEmpty()) {
			copyStack.push(topNode);
		}
		
		if(topNode.equals(node)) {
			
			parent = copyStack.lastElement();
		}
		
		return parent;
		
		
		
		
	}

	private static void addEdgesToGraph(String a, String b) {

		if (map.containsKey(a)) {
			map.get(a).add(b);
		} else {

			ArrayList<String> list = new ArrayList<String>();
			list.add(b);
			map.put(a, list);

		}
		if (map.containsKey(b)) {
			map.get(b).add(a);
		} else {

			ArrayList<String> list = new ArrayList<String>();
			list.add(a);
			map.put(b, list);

		}

	}

}