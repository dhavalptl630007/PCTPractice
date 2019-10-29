package Geeks;
/*
 
create graph from matrix and check whether graph is Bipartite or not 
 
4
0 1 0 1 1 0 1 0 0 1 0 1 1 0 1 0

5
0 1 0 0 1 1 0 1 0 0 0 1 0 1 0 0 0 1 0 1 1 0 0 1 0
 */
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class GraphBipartite {

	static LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();
	static LinkedHashMap<String, Integer> colorStatus = new LinkedHashMap<String, Integer>();
	static ArrayList<String> isVisited = new ArrayList<String>();
	static int color = 1;
    static boolean flag = true;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numOfVertices = Integer.parseInt(sc.nextLine());

		int graph[][] = new int[numOfVertices][numOfVertices];

		String arr[] = sc.nextLine().split("\\s+");

		int start = 0;
		for (int i = 0; i < numOfVertices; i++) {

			for (int j = 0; j < numOfVertices; j++) {
				graph[i][j] = Integer.parseInt(arr[j + start]);

			}

			start = start + numOfVertices;

		}

		for (int i = 0; i < numOfVertices; i++) {

			for (int j = 0; j < numOfVertices; j++) {

				System.out.print(graph[i][j] + " ");

			}

			System.out.println();

		}

		for (int i = 0; i < numOfVertices; i++) {

			for (int j = 0; j < numOfVertices; j++) {

				if (graph[i][j] == 1) {
					addedge(i + 1, j + 1);
				}
			}

			System.out.println();

		}

		System.out.println(map);

		intialize();

		System.out.println(colorStatus);

		for (Entry entry : map.entrySet()) {
			String key = (String) entry.getKey();

			if (!isVisited.contains(key)) {
				DFS(key, color);
			}

		}
		
		System.out.println(colorStatus);
		
		isVisited.clear();
		isBipartite();
		System.out.println(flag);

	}

	private static void isBipartite() {
		
		for (Entry entry : map.entrySet()) {
			String key = (String) entry.getKey();

			if (!isVisited.contains(key)) {
				DFSNew(key);
			}

		}
		
	}

	private static void DFSNew(String key) {
		isVisited.add(key);
		int getColorOfParent =0;
		if (colorStatus.containsKey(key)) {
			getColorOfParent = colorStatus.get(key);
			
		}
		ArrayList<String> adjacentNodes = map.get(key);
		
		if(adjacentNodes!=null) {
		for (String adjacentNode : adjacentNodes) {
              
			 if(colorStatus.get(adjacentNode)==getColorOfParent) {
				 flag = false;
			 }
			 if(!isVisited.contains(adjacentNode)) {
				 DFSNew(adjacentNode);
			 }
		}
		
		}
		
	}

	private static void DFS(String key, int color) {

		isVisited.add(key);
		if (colorStatus.containsKey(key)) {
			int currentColor = colorStatus.get(key);
			if(currentColor == -1) {		
			colorStatus.put(key, color);
			}
			
		}

		ArrayList<String> adjacentNodes = map.get(key);
		if (adjacentNodes != null) {
			int adjacentColor = 0;
			int getColorOfParent = colorStatus.get(key);
			if(getColorOfParent==1) {
				adjacentColor = 0;
			}
			else if (getColorOfParent==0)
			{
				adjacentColor = 1;
			}
			
			for (String adjacentNode : adjacentNodes) {

				 if(!isVisited.contains(adjacentNode)) {
					 DFS(adjacentNode,adjacentColor);
				 }
			}

		}
	}

	private static void intialize() {

		for (Entry entry : map.entrySet()) {

			String key = (String) entry.getKey();
			colorStatus.put(key, -1);

			ArrayList<String> list = (ArrayList<String>) entry.getValue();
			for (String adjacenode : list) {

				colorStatus.put(adjacenode, -1);
			}

		}

	}

	private static void addedge(int a, int b) {

		String u = Integer.toString(a);
		String v = Integer.toString(b);

		if (map.containsKey(u)) {

			map.get(u).add(v);

		} else {
			ArrayList<String> list = new ArrayList<String>();
			list.add(v);
			map.put(u, list);

		}

	}

}
