import java.util.*;
class Node { 
	int data; 
	Node left, right; 

	public Node(int d) 
	{ 
		data = d; 
		left = right = null; 
	} 
} 

class BinaryTreeSpiral { 
	Node root; 
	void insert(char[] s,int d)
	{
		Node newnode= new Node(d);
		Node temp=this.root;
		int i=0;
		if(temp==null && s[i]=='n')
		{
			this.root=newnode;
			return;
		}
		while(i<s.length-1)
		{
			if(s[i]=='L' && temp.left!=null)
			{
				temp=temp.left;
			}
			else if(s[i]=='R' && temp.right!=null)
			{
				temp=temp.right;
			}
			i++;
		}
		if(s[i]=='L')
			temp.left=newnode;
		else
			temp.right=newnode;
	}
	void printSpiral(Node node) 
	{ 
		int h = height(node); 
		int i; 

		boolean dir = false; 
		for (i = 1; i <= h; i++) { 
			printGivenLevel(node, i, dir); 

			dir = !dir; 
		} 
	} 

	int height(Node node) 
	{ 
		if (node == null) 
			return 0; 
		else { 

			int lheight = height(node.left); 
			int rheight = height(node.right); 

			if (lheight > rheight) 
				return (lheight + 1); 
			else
				return (rheight + 1); 
		} 
	} 

	void printGivenLevel(Node node, int level, boolean dir) 
	{ 
		if (node == null) 
			return; 
		if (level == 1) 
			System.out.print(node.data + " "); 
		else if (level > 1) { 
			if (dir == true) { 
				printGivenLevel(node.left, level - 1, dir); 
				printGivenLevel(node.right, level - 1, dir); 
			} 
			else { 
				printGivenLevel(node.right, level - 1, dir); 
				printGivenLevel(node.left, level - 1, dir); 
			} 
		} 
	} 
	
	public static void main(String[] args) 
	{ 
		BinaryTreeSpiral t = new BinaryTreeSpiral(); 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of nodes:");
		int n=sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			String s1=sc.next();
			char s[]=s1.toCharArray();
			int d=sc.nextInt();
			t.insert(s,d);
		}
		System.out.println("Spiral order traversal of Binary Tree is "); 
		t.printSpiral(t.root); 
	} 
} 


