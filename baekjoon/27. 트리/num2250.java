package package27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num2250 {
	static int N, maxWidth, maxDepth, root, vCount = 1;
	static Node[] tree;
	
	static int[] depthLeft;
	static int[] depthRight;
	static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = stoi(br.readLine());
		
		init();
		
		inputTreeData();
		
		searchRootIndex();
		
		inOrder(root, 1);
		
		printResult();
		
	}
	
	public static void init() {
		tree = new Node[N+1];
		depthLeft = new int[N+1];
		depthRight = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			tree[i] = new Node(-1, -1, -1);
			depthLeft[i] = N+1;
		}
	}
	
	public static void inputTreeData() throws IOException {
		for(int i=0; i<N; i++) {
			String[] inputData = br.readLine().split(" ");
			
			int num = stoi(inputData[0]);
			int left = stoi(inputData[1]);
			int right = stoi(inputData[2]);
			
			tree[num].left = left;
            tree[num].right = right;
            if(left != -1)
                tree[left].parent = num;
            
            if(right != -1)
                tree[right].parent = num;
		}
	}
	
	public static void searchRootIndex() {
		for(int i=1; i <= N; i++) {
			if(tree[i].parent == -1) {
				root = i;
				break;
			}
		}
	}
	
	public static void inOrder(int parentIndex, int depth) {
        Node root = tree[parentIndex];
        if(maxDepth < depth) maxDepth = depth;
        if(root.left != -1) {
            inOrder(root.left, depth + 1);
        }
        
        depthLeft[depth] = Math.min(depthLeft[depth], vCount);
        depthRight[depth] = vCount++;
        
        if(root.right != -1) {
            inOrder(root.right, depth + 1);
        }
	}
	
	public static void printResult() {
        int index = 1;
        int maxWitdh = depthRight[1] - depthLeft[1] + 1;
        for(int i=2; i <= maxDepth; i++) {
            int tmp = depthRight[i] - depthLeft[i] +1;
            if(maxWitdh < tmp) {
            	index = i;
            	maxWitdh = tmp;
            }
        }
        
        System.out.println(index + " " + maxWitdh);
	}
	
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
	
	static class Node{
		int parent, value, left, right;
		Node(int value, int left, int right){
			this.parent = -1;
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
}
