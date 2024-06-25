package BinaryTree;

public class binarysearchtree {
	private  BinaryTreeNode<Integer>root;
	private boolean hasdatahelper(int data,BinaryTreeNode<Integer>root) {
		if(root == null) {
			return false;
		}
		if(root.data == data) {
			return true;
		}
		else if(data < root.data) {
			return hasdatahelper(data, root.left);
		}
		else {
			return hasdatahelper(data, root.right);
		}
	}
	
	public  boolean hasdata(int data) {
		return hasdatahelper(data,root);
		
	}
	
	public BinaryTreeNode<Integer> insertdata(int data,BinaryTreeNode<Integer>root){
		if(root == null) {
			BinaryTreeNode<Integer> newnode = new BinaryTreeNode<>(data);
			return newnode;
		}
		if(root.data > data) {
			root.left = insertdata(data,root.left);
		}
		else {
			root.right = insertdata(data,root.right);
		}
		return root;
	}
	
	public void insert(int data) {
		root = insertdata(data,root);
	}
	
	public BinaryTreeNode<Integer> deletenode(int data,BinaryTreeNode<Integer>root){
		if(root == null) {
			return null;
		}
		if(root.data == data) {
			return null;
		}
		if(root.data > data) {
			root.left = deletenode(data,root.left);
			return root;
		}
		else if (root.data < data){
			root.right = deletenode(data,root.right);
			return root;
		}
		else {
		if(root.left == null && root.right == null){
			return null;
		}
		else if(root.left == null) {
			return root.right;
		}
		else if(root.right == null) {
			return root.left;
		}
		else {
			BinaryTreeNode<Integer> minnode = root.right;
			while(minnode.left != null) {
				minnode = minnode.left;
			}
			root.data = minnode.data;
			root.right = deletenode(minnode.data,root);
			return root;
		}
		}
		
	}
	
	public void delete(int data) {
		root = deletenode(data,root);
	}
	
	private  void print(BinaryTreeNode<Integer>root) {
		if(root == null) {
			return;
		}
		String tobeprinted = root.data+":";
		if(root.left != null) {
			tobeprinted+= "L:"+root.left.data+",";
		}
		if(root.right != null) {
			tobeprinted+= "R:"+root.right.data+",";
		}
		System.out.println(tobeprinted);
		print(root.left);
		print(root.right);
	}
	public void printTree() {
		print(root);
	}

}
