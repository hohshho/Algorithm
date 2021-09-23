package package27;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class num1991{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i, n = stoi(br.readLine());
		Tree t = new Tree();
		String[] data;
		
		for(i=0;i<n;i++){
			data = br.readLine().split(" ");
			t.add(data[0], data[1], data[2]);
		}
		t.preorder(t.root);
		System.out.println();
		t.inorder(t.root);
		System.out.println();
		t.postorder(t.root);
		br.close();
	}
	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
	
	static class Node{
		String data;
		Node left, right;
		public Node(String data){
			this.data = data;
		}
	}
	
	static class Tree{
		Node root;
		public void add(String data, String leftData, String rightData){
			if(root==null){
				if(!data.equals("")) root = new Node(data);
				if(!leftData.equals("")) root.left = new Node(leftData);
				if(!rightData.equals("")) root.right = new Node(rightData);
			}
			else search(root, data, leftData, rightData);
		}
		private void search(Node root, String data, String leftData, String rightData){
		    if(root==null) return;
		    else if(root.data.equals(data)){
			    if(!leftData.equals("")) root.left = new Node(leftData);
			    if(!rightData.equals("")) root.right = new Node(rightData);
		    }
		    else{
			    search(root.left, data, leftData, rightData);
			    search(root.right, data, leftData, rightData);
		    }
	    }
		
		public void preorder(Node root){
			System.out.print(root.data);
			if(root.left!=null) preorder(root.left);
			if(root.right!=null) preorder(root.right);
		}
		
		public void inorder(Node root){
			if(root.left!=null) inorder(root.left);
			System.out.print(root.data);
			if(root.right!=null) inorder(root.right);
		}
		
		public void postorder(Node root){
			if(root.left!=null) postorder(root.left);
			if(root.right!=null) postorder(root.right);
			System.out.print(root.data);
		}
	}
	
}
