package io.graph;


import java.io.*;
import java.util.*;



public class DFSIterative{
	
	
	int V;
	List<List<Integer>> adjList;
	
	
	public DFSIterative(int V){
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
	
	public void dfs(int node, boolean[] visited){
		
		Stack<Integer> stack = new Stack<>();
		stack.push(node);
		
		while(!stack.isEmpty()){
			int nodeVal = stack.pop();
			if(!visited[nodeVal]){
				System.out.print(nodeVal+"  ");
				visited[nodeVal]= true;
				for(int neighbor : adjList.get(nodeVal)){
					if(!visited[neighbor]){
						stack.push(neighbor);
					}
				}
			}
		}
	}
	
	
	public static void main(String args[]){
		
		DFSIterative dfsTraversal = new DFSIterative(9);
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
		
		System.out.println("DFS Traversal...");
		dfsTraversal.dfs(1, visited);
	}
}