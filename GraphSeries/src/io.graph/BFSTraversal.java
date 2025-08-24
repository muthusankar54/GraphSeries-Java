package io.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {

    public static void main(String[] args) {

        int vertices = 10;
        
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
		
		for(int i=0;i<vertices;i++){
		  adjacencyList.add(new ArrayList<Integer>());
		}
		
		BFSTraversal bfs = new BFSTraversal();
		bfs.addEdge(adjacencyList,1,2);
		bfs.addEdge(adjacencyList,1,6);
		bfs.addEdge(adjacencyList,2,3);
		bfs.addEdge(adjacencyList,2,4);
		bfs.addEdge(adjacencyList,6,7);
		bfs.addEdge(adjacencyList,6,9);
		bfs.addEdge(adjacencyList,4,5);
		bfs.addEdge(adjacencyList,7,8);
		bfs.addEdge(adjacencyList,5,8);
		
		
	
	
	    //Graph traversal
        displayGraphTraversal(adjacencyList,1,vertices);

    }
	
	
	public  void addEdge(ArrayList<ArrayList<Integer>> list, int i, int j){
	list.get(i).add(j);
	list.get(j).add(i);
	}
	
	
	
	public static void displayGraphTraversal(ArrayList<ArrayList<Integer>> list, int source, int vertices){
		
		boolean[] visited = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<>();
		
		visited[source]= true;
		queue.offer(source);
		System.out.println("Adjacency List Traversal: ");
		while(!queue.isEmpty()){
			int nodeValue = queue.poll();
			System.out.print(nodeValue+"  ");
			for(int neighbors : list.get(nodeValue)){
                if(!visited[neighbors]) {
                    queue.offer(neighbors);
                    visited[neighbors] = true;
                }
			}
		}
	}
	
}
