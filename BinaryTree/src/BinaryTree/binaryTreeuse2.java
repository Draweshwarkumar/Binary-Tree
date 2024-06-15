package BinaryTree;

import java.util.Scanner;

public class binaryTreeuse2 {
	
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
	
	public static void print(BinaryTreeNode<Integer>root) {
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

	public static int countnode(BinaryTreeNode<Integer>root) {
		if(root == null) {
			return 0;
		}
		int noofnodes = 1;
		noofnodes+= countnode(root.left);
		noofnodes+= countnode(root.right);
		return noofnodes;
		
	}
	
	public static pair<Integer> heightdiameter(BinaryTreeNode<Integer>root){
		if(root == null) {
			pair<Integer> output = new pair<>();
			output.first = 0;
			output.second = 0;
			return output;
		}
		
		pair<Integer> lo = heightdiameter(root.left);
		pair<Integer> ro = heightdiameter(root.right);
		int height = 1+ Math.max(lo.first, ro.first);
		int option1 = lo.first+ro.first;
		int option2 = lo.second;
		int option3 = lo.second;
		int diameter = Math.max(option1, Math.max(option2, option3));
		pair<Integer> output = new pair<>();
		output.first = height;
		output.second = diameter;
		return output;
	}
	
	public static void printInorder(BinaryTreeNode<Integer>root) {
		if(root == null) {
			return ;
		}
		printInorder(root.left);
		System.out.print(root.data+" ");
		printInorder(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root =takeInputlevelwise();
		
		
		printInorder(root);
		print(root);
		System.out.println(countnode(root));
		System.out.println("Height is"+ heightdiameter(root).first);
		System.out.println("Diameter is"+ heightdiameter(root).second);
		

	}

}
