import java.util.*;
class Node { 

	int data; 
	Node left, right; 

	Node(int d) 
	{ 
		data = d; 
		left = right = null; 
	} 
} 

class Height { 
	int height = 0; 
} 

class BSTTree { 

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
		if(s[s.length-1]=='L')
			temp.left=newnode;
		else
			temp.right=newnode;
	}
	
	boolean isBST() { 
		return isBSTUtil(root, Integer.MIN_VALUE, 
							Integer.MAX_VALUE); 
	} 

	boolean isBSTUtil(Node node, int min, int max) 
	{ 
		
		if (node == null) 
			return true; 

		if (node.data < min || node.data > max) 
			return false; 

		return (isBSTUtil(node.left, min, node.data-1) && 
				isBSTUtil(node.right, node.data+1, max)); 
	} 

	public static void main(String args[]) 
	{ 
		Height height = new Height(); 

		BSTTree t = new BSTTree(); 
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

		if (t.isBST()) 
			System.out.println("Tree is BST"); 
		else
			System.out.println("Tree is not BST"); 
	} 
} 
