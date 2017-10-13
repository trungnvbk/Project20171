package DoThi;
import java.awt.*;

class StackX {
	private final int SIZE = 20;
	private int[] st;
	private int top;
	
	public StackX() {
		st = new int[SIZE];
		top = -1;
	}
	
	public void push(int j) {
		st[++top] = j;
	}
	
	public int pop() {
		return st[top--];
	}
	
	public int peek() {
		return st[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
}

class Vertex{
	public char lable;
	public boolean wasVisited;
	
	public Vertex(char lab) {
		this.lable = lab;
		this.wasVisited = false;
	}
}


class Graph{
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private StackX theStack;
	
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int i = 0; i < MAX_VERTS; i++)
			for(int j = 0; j < MAX_VERTS; j++)
				adjMat[i][j] = 0; 
		theStack = new StackX();
	}
	
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
		
	}
	
	public void displayVertex(int v) {
		System.out.println(vertexList[v].lable);
	}
	
	public void dfs() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		theStack.push(0);
		while(!theStack.isEmpty()) {
			int v = getAdjUnvisitedVertex(theStack.peek());
			if( v == -1) {
				theStack.pop();
			}else {
				vertexList[v].wasVisited = true;
				displayVertex(v);
				theStack.push(v);
			}
		}
		for(int j = 0; j < nVerts; j++) {
			vertexList[j].wasVisited = false;
		}
	}
	public int getAdjUnvisitedVertex(int v) {
		for(int j = 0; j < nVerts; j++) {
			if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
				return j;
			}
		}
		return -1;
	}
}
public class DFSapp {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A');//0
		theGraph.addVertex('B');//1
		theGraph.addVertex('C');//2
		theGraph.addVertex('D');//3
		theGraph.addVertex('E');//4
		
		theGraph.addEdge(0, 1);//AB
		theGraph.addEdge(1, 2);//BC
		theGraph.addEdge(0, 3);//AD
		theGraph.addEdge(3, 4);//DE
		System.out.println("Visits: ");
		theGraph.dfs();
		System.out.println();
		
	}

}
