package DoThi;

public class DemoGraph {
	private final int MAX_VERTS = 5;
	private Vertex vertexList[];// array of vertices: Mảng các đỉnh, mỗi một đỉnh có dataType Vertex
	private int adjMat[][]; // Ma trận kề
	private int nVerts; // current number of vertices: Số đỉnh hiện tại
	
	public DemoGraph() {
		vertexList  = new Vertex[MAX_VERTS];// Tối đa 20 đỉnh nhé
		adjMat = new int[MAX_VERTS][MAX_VERTS];// Ma trận kề maxKT:20x20
		nVerts = 0;
		for(int j = 0; j < MAX_VERTS; j++) {
			for(int k = 0; k < MAX_VERTS; k++) {
				adjMat[j][k] = 0;// Ban đầu khởi tạo MaTranKe toàn số 0
			}
		}
	}
	
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void printAdjMat() {
		System.out.print("  ");
		for(int i = 0; i < MAX_VERTS; i++) {
			System.out.print(vertexList[i].lable + " ");
		}
		System.out.println();
		for(int i = 0; i < MAX_VERTS; i++) {
			System.out.print(vertexList[i].lable + " ");
			for(int j = 0; j < MAX_VERTS; j++) {
				System.out.print(adjMat[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		DemoGraph graph = new DemoGraph();
		
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		
		graph.addEdge(2, 1);
		graph.printAdjMat();
	}
}
