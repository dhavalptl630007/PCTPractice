package Geeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

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

public class DirectedGraphCycle {

	private static Map<String,ArrayList<String>> map = new HashMap<>();
	private static List<String> visitedList = new ArrayList<>();
	private static Stack<String> stack = new Stack<String>();
	//private static String parent;
	private static Map<String,String> nodeFlag = new HashMap<>();
	private static boolean isCycleDetected = false;
	private static int cycleCount = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int numberOfVertices = Integer.parseInt(sc.nextLine());
		int numberofEdges = Integer.parseInt(sc.nextLine()); 
		
		for (int i = 0; i < numberofEdges; i++) {
			
			String[] strings = sc.nextLine().split("\\s+");
			
			addEdgesToGraph(strings[0],strings[1]);
			
		}
		
		
		
		
		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
			
			String rootNode = entry.getKey();
			
			if(!visitedList.contains(rootNode)) {
				
				DFSTraversalToDetectCycleInDirectedGraph(rootNode,rootNode);
				
			}
			
			initializeNodeFlag();
		}
		
		
		System.out.println("numberOfVertices -- "+numberOfVertices);
		System.out.println("cycleCount -- "+cycleCount);
		System.out.println("cycleDetected -- "+isCycleDetected);
		
		sc.close();
		
	}


	private static void DFSTraversalToDetectCycleInDirectedGraph(String node, String rootNode) {
		
		visitedList.add(node);
		nodeFlag.put(node, "0"); // visited = 0 , unvisted = -1 , visited and popedout = 1
		
		stack.push(node);
		//parent = getParent(node);
		
		ArrayList<String> adjacentNodes =  map.get(node);
		
		if(adjacentNodes!=null) {
			for (String adjacentNode : adjacentNodes) {
				
				if(!visitedList.contains(adjacentNode)) {
					DFSTraversalToDetectCycleInDirectedGraph(adjacentNode, rootNode);
				}
			}
		}
		
		// while backtracking if there is an adjacentNode which is VISITED(0)
		if(adjacentNodes!=null) {
			for (String adjacentNode : adjacentNodes) {

				if(nodeFlag.get(adjacentNode).equals("0")) {
					
					isCycleDetected = true;
					cycleCount ++;
					printCycle(node,adjacentNode);
				}
				
			}
		}
		
		
		String lastElement = stack.pop();
		if(lastElement.equals(rootNode)) {
			stack.push(rootNode);
		}
		
		nodeFlag.put(node, "1"); // visited and poped out
		
	}

	private static void printCycle(String node, String adjacentNode) {
		
		//node = e		
		//adjacentNode = b
		ArrayList<String> al = new ArrayList<>();
		
		
		@SuppressWarnings("unchecked")
		Stack<String> temp = (Stack<String>) stack.clone();
		
		while(!adjacentNode.equals(temp.lastElement())) {
			String pop = temp.pop();
			//System.out.print(pop+" ");
			al.add(pop);
		}
		//System.out.println(adjacentNode);
		al.add(adjacentNode);
		Collections.reverse(al);
		System.out.println(al);
		
		
		
	}

	
	private static void addEdgesToGraph(String stra, String strb) {

		if(map .containsKey(stra)) {
			map.get(stra).add(strb);
		}else {
			ArrayList<String> al = new ArrayList<>();
			al.add(strb);
			map.put(stra, al);
		}
		
	}
	
	
	private static void initializeNodeFlag() {
		
		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {

			nodeFlag.put(entry.getKey(), "-1");
			
			for (String allnodes : entry.getValue()) {
				nodeFlag.put(allnodes, "-1");
			}
		}
	}
	
	
	
}