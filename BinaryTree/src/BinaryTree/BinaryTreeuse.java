package BinaryTree;

import java.util.Scanner;

public class BinaryTreeuse {
	
	public static void print(BinaryTreeNode<Integer>root) {
		if(root == null) {
			return ;
		}
		String tobeprinted = root.data+"";
		if(root.left != null) {
			tobeprinted += "L:"+root.left.data+",";
		}
		if(root.right != null) {
			tobeprinted += "R:" +root.right.data;
		}
		System.out.println(tobeprinted);
		print(root.left);
		print(root.right);
	}
	
	public static BinaryTreeNode<Integer> takeInput(Scanner s){
		int rootData;
		System.out.println("Enter root Data");
		rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		root.left = takeInput(s);
		root.right = takeInput(s);
		return root;
	}
	
	public static BinaryTreeNode<Integer> takeInputlevelwise(){
		Scanner s  = new Scanner(System.in);
		queueusingLL<BinaryTreeNode<Integer>> pendingnodes = new queueusingLL<>();
		int rootdata = s.nextInt();
		if(rootdata == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata);
		pendingnodes.enqueue(root);
		while(!pendingnodes.isEmpty()) {
			BinaryTreeNode<Integer>frontnode;
			try {
				frontnode = pendingnodes.dequeue();
				
			}
			catch(queueemptyexception e) {
				return null;
			}
			System.out.println("Enter the left child of"+frontnode.data);
			int leftchild = s.nextInt();
			if(leftchild != -1) {
			BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftchild);
			pendingnodes.enqueue(child);
			frontnode.left = child;
		}
			System.out.println("Enter the right  child of"+ frontnode.data);
			int rightchild = s.nextInt();
			if(rightchild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<>(rightchild);
				pendingnodes.enqueue(child);
				frontnode.right = child;
			}
		} 
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		BinaryTreeNode<Integer>root = takeInputlevelwise();
		print(root);
		
//		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
//		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
//		root.left = node1;
//		root.right = node2;

	}

}
