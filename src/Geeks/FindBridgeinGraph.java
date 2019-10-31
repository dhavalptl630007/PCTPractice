package Geeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;


	/*

	understanding check -- https://www.youtube.com/watch?v=CsGP_s_3GWg
input
5
5
1 2
2 3
2 4
3 4
4 5

output
2 5

input
9
11
1 2
2 3
3 4
2 4
1 3
2 8
5 7
6 7
5 6
0 7
0 8
output
3 8

 */

	public class FindBridgeinGraph { 

		private static Map<String,ArrayList<String>> map = new HashMap<>();
		private static List<String> visitedList = new ArrayList<String>();
		private static int time = 0;
		private static Map<String,Integer> mapNodeTime = new LinkedHashMap<>();
		private static Stack<String> stack = new Stack<String>();
		private static int bridge = 0;
		private static int maxNodeBridge = 0;
		
		
		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
			
			int numberofVertice = Integer.parseInt(sc.nextLine());
			int numberofEdges = Integer.parseInt(sc.nextLine());
			
			for (int i = 0; i < numberofEdges; i++) {
				
				String[] strings = sc.nextLine().split("\\s+");
				addEdgesToGraph(strings[0],strings[1],map);
			}
			
			
			for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
				
				String startNode = entry.getKey();
				
				 if(!visitedList.contains(startNode)) {
					 
					 DFSTraversal(startNode,startNode);
				 }		
				
			}
			
			
			
			System.out.println(bridge+" "+maxNodeBridge);
			sc.close();
		}

		
	private static void DFSTraversal(String node, String startNode) {

		visitedList.add(node);
		time++;
		mapNodeTime.put(node, time);
		stack.push(node);

		ArrayList<String> adjacentNodes = map.get(node);

		if (adjacentNodes != null) {

			for (String adjacentNode : adjacentNodes) {

				if (!visitedList.contains(adjacentNode)) {

					DFSTraversal(adjacentNode, startNode);
				}
			}

		}
		
		
		String lastelement = stack.lastElement();
		String parent = null;
		stack.pop();
		if(stack.isEmpty()) {
			
			stack.push(node);
			parent = node;
		}
		else {
			
			if(lastelement.equals(node)) {
				
				parent = stack.lastElement();
			}
			
		}
		
		int smalltime = getMinimumDistTime(node,parent);
		
		if(mapNodeTime.get(parent)< smalltime) {
			
			bridge++;
			maxNodeBridge = Math.max(maxNodeBridge, Math.max(Integer.parseInt(node), Integer.parseInt(parent)));
		}

	}


		private static int getMinimumDistTime(String node, String parent) {
		
		int smalltime = mapNodeTime.get(node);
		
		ArrayList<String> adjacentNodes = map.get(node);

		if (adjacentNodes != null) {

			for (String adjacentNode : adjacentNodes) {

				if (!adjacentNode.equals(parent)) {

					smalltime = Math.min(smalltime,mapNodeTime.get(adjacentNode));
					
				}
			}

		}
			
		mapNodeTime.put(node, smalltime);
		return smalltime;
	}


		private static void addEdgesToGraph(String string0, String string1, Map<String, ArrayList<String>> map) {
			
			if(map.containsKey(string0)) {
				map.get(string0).add(string1);
			}else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(string1);
				map.put(string0, al);
			}
			
			if(map.containsKey(string1)) {
				map.get(string1).add(string0);
			}else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(string0);
				map.put(string1, al);
			}
			
		}

	}