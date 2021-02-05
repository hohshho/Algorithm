package package27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num2263 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node tree = new Node(stoi(br.readLine()));
		
        String s = "";
        while ((s = br.readLine()) != null && s.length() != 0) {    //EOF까지 입력받음
            tree = tree.add(tree, stoi(s));
        }
        
        postorder(tree);
        System.out.println(sb);
    }
	
	static int stoi(String string) {
		return Integer.parseInt(string);
	}
 
    public static void postorder(Node tree) {
        if (tree.left != null) postorder(tree.left);
        if (tree.right != null) postorder(tree.right);
        sb.append(tree.data + "\n");
    }
    
	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
	    public Node add(Node tree, int data) {
	    	Node curTree = null;
	        if (tree == null) return new Node(data);
	        if (tree.data > data) {
	            curTree = add(tree.left, data);  
	            tree.left = curTree;                
	        } else if (tree.data < data) {
	            curTree = add(tree.right, data); 
	            tree.right = curTree;            
	        }
	        return tree;
	    }
	}
}
