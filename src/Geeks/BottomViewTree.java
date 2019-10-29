package Geeks;

//top view of tree can be found by vertical and order traversal of tree
//Next time : no need to create map for level and vertical traversal, just store the result in list

//refer https://youtu.be/c3SAvcjWb1E

//input : 1 2 5 3 6 4
//output : 1 2 5 6 

//input 1 14 3 7 4 5 15 6 13 10 11 2 12 8 9
//output 2 1 14 15 12 
//input : 13 105 278 16 60 135 47 129 234 372 271 179 189 103 302 71 377 4 112 195 360 151 348 125 393 351 236 409 68 371 210 149 255 37 24 259 243 10 91 98 126 160 308 229 297 107 95 353 175 172 191 163 379 137 386 49 67 405 257 110 199 15 327 416 184 22 38 148 383 374 200 138 263 158 339 19 132 50 79 370 401 230 34 190 48 176 41 162 346 28 64 202 414 222 161 334 76 127 244 306 96 399 177 88 239 33 73 356 344 3 45 58 219 311 332 231 156 284 204 106 178 59 44 194 237 226 354 247 99 335 304 186 410 266 114 185 81 341 92 113 375 368 55 256 396 78 218 281 197 7 72 143 395 277 46 358 282 382 142 187 251 310 290 285 57 328 292 352 317 180 82 323 364 89 260 128 119 217 100 153 397 388 164 173 345 8 43 343 196 155 307 331 117 144 301 26 272 340 324 134 240 120 337 77 391 407 201 168 250 312 17 289 53 35 5 303 14 270 192 108 208 369 390 253 147 299 305 213 400 363 373 181 295 261 309 145 298 205 408 349 29 269 152 367 413 279 238 62 102 116 392 40 51 254 140 74 227 165 330 27 63 315 54 258 85 12 104 357 118 241 31 193 198 122 130 183 361 274 291 25 146 121 321 268 273 36 316 216 70 171 75 380 296 66 264 398 359 87 338 355 220 288 225 21 94 157 207 86 97 235 83 381 221 61 42 111 150 320 188 123 300 215 329 267 170 18 167 224 265 293 23 124 212 39 376 326 378 169 415 65 365 394 245 182 211 242 350 336 385 342 233 84 283 228 154 166 418 206 389 214 133 347 232 275 52 402 287 2 318 93 280 248 313 1 131 209 412 406 249 325 276 6 286 9 333 403 314 262 387 30 56 362 141 11 109 417 136 139 322 223 246 101 80 294 404 319 32 69 20 115 174 366 252 90 384 159 411 203
//output : 17 1 2 3 4 13 105 278 372 377 393 409 416 418 

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

class Node5 {

	int data;
	Node5 left;
	Node5 right;
	int dist;

	Node5(int data) {

		this.data = data;
		this.left = null;
		this.right = null;

	}

}

public class BottomViewTree {

	static LinkedHashMap<Integer,ArrayList<Integer>> levellist = new LinkedHashMap<Integer,ArrayList<Integer>>();
	static int root_level = 0;
	static ArrayList<Integer> levelorder = new ArrayList<Integer>();
	static TreeMap<Integer,ArrayList<Integer>> verticalmap = new TreeMap<Integer,ArrayList<Integer>> ();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String arr[] = sc.nextLine().split("\\s+");

		int data = Integer.parseInt(arr[0]);
		Node5 root = new Node5(data);

		for (int i = 1; i < arr.length; i++) {
			int data1 = Integer.parseInt(arr[i]);
			createBST(root, data1,0);
		}
		
		preOrderTraversal(root);
		int h = heightTree(root);
		System.out.println(h);
		
		for(int i = 0; i<=h;i++) {
		   
			root_level = i+1;
			ArrayList<Integer> list = new ArrayList<Integer>();
			levelTraversal(root,root_level,list);
		}
		
       System.out.println(levellist); 
       
       
       verticalOrderTraversal(root);
       
       System.out.println(verticalmap);
       TopView();
       System.out.println();
       BottomView();
		
	}

	private static void BottomView() {
		
		for(Entry<Integer, ArrayList<Integer>> entry : verticalmap.entrySet()) {
			
			ArrayList<Integer> list = entry.getValue();
			
			if(list.size() == 1) {
				
			  System.out.print(list.get(0)+" ");	
			}
			else
			{
				int result = getFromInLevelOrderNew(list);
				 System.out.print(result+" ");
			}
			
		}
		
	}

	private static int getFromInLevelOrderNew(ArrayList<Integer> list) {
		
		int max_pos = Integer.MIN_VALUE;
		for (Integer data : list) {
			
			int pos = levelorder.indexOf(data);
			max_pos = Math.max(pos, max_pos);
			
		}
		
		int temp = levelorder.get(max_pos);
		
		return temp;
	}

	private static void TopView() {
		
		
		for(Entry<Integer, ArrayList<Integer>> entry : verticalmap.entrySet()) {
		
			ArrayList<Integer> list = entry.getValue();
			
			if(list.size() == 1) {
				
			  System.out.print(list.get(0)+" ");	
			}
			else
			{
				int result = getFromInLevelOrder(list);
				 System.out.print(result+" ");
			}
			
		}
		
		
		
	}

	private static int getFromInLevelOrder(ArrayList<Integer> list) {
		
	  int min_pos = Integer.MAX_VALUE;
	  int temp = 0;
	  
		for (Integer data : list) {
			
		 int pos = levelorder.indexOf(data);
		 
		 min_pos = Math.min(min_pos, pos);
			
		}
		
	  temp = levelorder.get(min_pos);
		
		return temp;
	}

	private static void verticalOrderTraversal(Node5 root) {
		
		if(root == null) {
			return;
		}
		
	    if(verticalmap.containsKey(root.dist)) {
	    	
	    	verticalmap.get(root.dist).add(root.data);
	    	
	    }
	    else {
	    	
	    	ArrayList<Integer> list = new ArrayList<Integer>();
	    	list.add(root.data);
	    	
	    	verticalmap.put(root.dist,list);
	    }
	    
	    verticalOrderTraversal(root.left);
	    verticalOrderTraversal(root.right);
	    
	}

	private static int heightTree(Node5 root) {
		
		if(root == null) {
			return -1;
		}
		return 1 + Math.max(heightTree(root.left),heightTree(root.right));
	}

	private static void levelTraversal(Node5 root, int level, ArrayList<Integer> list) {
	
		if(root==null) {
			return;
		}
		
		if(level==1) {
			
			if(levellist.containsKey(root_level)) {
				
				levellist.get(root_level).add(root.data);
			}
			else
			{

				list.add(root.data);
				levellist.put(root_level,list);
			}
			
			levelorder.add(root.data);
		}
		if(level>1) {
			levelTraversal(root.left,level-1,list);
			levelTraversal(root.right,level-1,list);
			
		}
		
	}

	private static void preOrderTraversal(Node5 root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
		
		
	}

	private static void createBST(Node5 root, int data,int dist) {
		if (root == null) {
			return;
		}

		Node5 node = new Node5(data);

		if (root.left == null && node.data < root.data) {

			root.left = node;
			node.dist = dist -1;
		}

		else if (root.right == null && node.data > root.data) {
			root.right = node;
			node.dist = dist +1;
		}

		if (node.data < root.data) {

			createBST(root.left, data,dist-1);
		}

		if (node.data > root.data) {

			createBST(root.right, data,dist+1);
		}

	}

}
