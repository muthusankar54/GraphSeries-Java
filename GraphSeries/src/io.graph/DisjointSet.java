package io.graph;


import java.io.*;
import java.util.*;

public class DisjointSet {
	
	private List<Integer> parent;
	private List<Integer> rank;
	
	public DisjointSet(int V){
		parent = new ArrayList<>(V);
		rank = new ArrayList<>(V);
		
		for(int i=0;i<V;i++){
			parent.add(i);
			rank.add(1);
		}
	}
	
	public int find(int val){
		if(parent.get(val) != val){
			parent.set(val, find(parent.get(val)));
		}
		
		return parent.get(val);
		
	}
	
	public void union(int x, int y){
		
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX == rootY){
			return;
		}
		
		if(rank.get(rootX) > rank.get(rootY)){
			parent.set(rootY, rootX);
		}else if(rank.get(rootX) < rank.get(rootY)){
			parent.set(rootX, rootY);
		}else{
			parent.set(rootY, rootX);
			rank.set(rootX, rank.get(rootX)+1);
		}
		
	}
	
	
	public boolean connected(int x, int y){
		return find(x) == find(y);
	}
	
	
	
	
	public static void main(String args[]){
		
		DisjointSet ds = new DisjointSet(10);
		
		ds.union(1,2);
		ds.union(3,4);
		ds.union(5,6);
		ds.union(2,6);
		ds.union(7,8);
		ds.union(8,9);
		ds.union(4,9);
	
	
		//Checking the connectivity
		System.out.println("1 and 5 are connected ?" + ds.connected(1,5));
		
		
		
	}
}