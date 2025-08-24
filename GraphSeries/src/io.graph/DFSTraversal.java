package io.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class DFSTraversal {
	
	
	int V;
	List<List<Integer>> adjList;
	
	
	public DFSTraversal(int V){
		this.V = V;
		adjList = new ArrayList<>();
		
		for(int i=0;i<= V;i++){
			adjList.add(new ArrayList<>());
		}
	}
	
	
	public void addEdge(int u, int v){
		adjList.get(u).add(v);
		adjList.get(v).add(u);
	}
	
	
	public void dfs(int node, boolean[] visited, List<Integer> result){
		visited[node]= true;
		result.add(node);
		
		for(int neighbor : adjList.get(node)){
			if(!visited[neighbor]){
				dfs(neighbor, visited, result);
			}
		}
	}
	
	
	
	public static void main(String args[]){
		
		
		DFSTraversal dfsTraversal = new DFSTraversal(9);
		dfsTraversal.addEdge(1,2);
		dfsTraversal.addEdge(1,6);
		dfsTraversal.addEdge(2,3);
		dfsTraversal.addEdge(2,4);
		dfsTraversal.addEdge(4,5);
		dfsTraversal.addEdge(5,8);
		dfsTraversal.addEdge(6,7);
		dfsTraversal.addEdge(6,9);
		dfsTraversal.addEdge(7,8);
		
		boolean[] visited = new boolean[10];
		List<Integer> result = new ArrayList<>();
        dfsTraversal.dfs(1, visited, result);
		
		
		System.out.println("DFS traversal....");
		
		for(int value : result){
			System.out.print(value+" ");
		}
		
		
	}
}