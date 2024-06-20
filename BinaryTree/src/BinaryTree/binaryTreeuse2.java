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

	public static BinaryTreeNode<Integer> buildTreeHelper(int in[], int pre[], int inS, int inE, int preS, int preE){
		if(inS > inE) {
			return null;
		}
		int rootData = pre[preS];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		int rootInIndex = -1;
		for(int i = inS; i <= inE; i++) {
			if(in[i] == rootData) {
				rootInIndex = i;
				break;
			}
		}
		if (rootInIndex == -1) {
			return null;
		}
		
		int leftInS = inS;
		int leftInE = rootInIndex-1;
		int leftPreS = preS+1;
		int leftPreE = leftInE - leftInS + leftPreS;
		int rightInS = rootInIndex+1;
		int rightInE = inE;
		int rightPreS = leftPreE + 1;
		int rightPreE = preE;
		root.left = buildTreeHelper(in,pre,leftInS,leftInE,leftPreS,leftPreE);
		root.right = buildTreeHelper(in,pre,rightInS,  rightInE, rightPreS, rightPreE);
		return root;
	}
	
	public static BinaryTreeNode<Integer> buildTree(int in[],int pre[]){
		return buildTreeHelper(in, pre, 0, in.length-1, 0, pre.length-1);
	}
	
	public static void printInorder(BinaryTreeNode<Integer>root) {
		if(root == null) {
			return ;
		}
		printInorder(root.left);
		System.out.print(root.data+" ");
		printInorder(root.right);
	}

	
	public static BinaryTreeNode<Integer> BST(BinaryTreeNode<Integer> root,int s){
		if(root == null) {
			return null;
		}
		if(root.data == s) {
			return root;
		}
		if(s>root.data) {
			return BST(root.right,s);
		}
		else {
			return BST(root.left,s);
		}
	}
	
	public static void printInRange(BinaryTreeNode<Integer> root, int first, int second) {
	    if (root == null) {
	        return;
	    }

	    // Traverse the left subtree if there is a possibility of finding values within range
	    if (first < root.data) {
	        printInRange(root.left, first, second);
	    }

	    // Print the current node if it is within the range
	    if (first <= root.data && second >= root.data) {
	        System.out.print(root.data + " ");
	    }

	    // Traverse the right subtree if there is a possibility of finding values within range
	    if (second > root.data) {
	        printInRange(root.right, first, second);
	    }
	}

	public static boolean isBst(BinaryTreeNode<Integer>root) {
		if(root == null) {
			return true;
		}
		int leftMax = maximum(root.left);
		int rightMin = minimum(root.right);
		if(root.data <= leftMax) {
			return false;
		}
		if(root.data > rightMin) {
			return false;
		}
		
		boolean isLeftBST = isBst(root.left);
		boolean isRightBSt = isBst(root.right);
		if(isLeftBST && isRightBSt) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isBst2(BinaryTreeNode<Integer>root,int min,int max) {
		if(root == null) {
			return true;
		}
		if(root.data < min || root.data > max) {
			return false;
		}
		boolean isleftok = isBst2(root.left,min,root.data-1);
		boolean isrightok = isBst2(root.right,root.data,max);
		return isleftok && isrightok;
		
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
