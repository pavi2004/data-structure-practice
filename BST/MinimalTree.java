import java.util.*;
class Node { 
	
	int data; 
	Node left, right; 
	
	Node(int d) { 
		data = d; 
		left = right = null; 
	} 
} 

class MinimalTree { 
	
	 Node root; 

	Node sortedArrayToBST(int arr[], int start, int end) { 

		if (start > end) { 
			return null; 
		} 

		int mid = (start + end) / 2; 
		Node node = new Node(arr[mid]); 

		node.left = sortedArrayToBST(arr, start, mid - 1); 

		node.right = sortedArrayToBST(arr, mid + 1, end); 
		
		return node; 
	} 

	void preOrder(Node node) { 
		if (node != null) { 
		System.out.print(node.data + " "); 
		preOrder(node.left); 
		preOrder(node.right); 
		}
	} 
	
	public static void main(String[] args) { 
		MinimalTree tree = new MinimalTree(); 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array");
		int n=sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		
		tree.root = tree.sortedArrayToBST(arr, 0, n - 1); 
		System.out.println("Preorder traversal of constructed BST"); 
		tree.preOrder(tree.root); 
	} 
} 

